package c4_media_view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MediaController implements Initializable {
	
	@FXML private MediaView mediaView;
	@FXML private Label lblTime;
	@FXML private Button btnPlay, btnPause, btnStop;
	@FXML private ProgressBar progressBar;
	@FXML private ProgressIndicator progressIndicator;
	@FXML private Slider sliderPlay, sliderVolume;
	
	// 파일의 끝까지 재생 완료를 확인할 flag
	private boolean endOfMedia;
	// 재생해야할 resource 정보를 저장하는 객체
	private Media media;
	// MediaView를 통해 재생되는 resource를 제어하는 객체
	private MediaPlayer mediaPlayer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// slider 0~ 100까지의 실수 값을 표현
		sliderVolume.setValue(50);
		progressBar.setProgress(0.5);
		progressIndicator.setProgress(0.5);
		media = new Media(
				getClass().getResource("../media/audio.wav")
				.toString()
		);
		init(media);
	}
	// 재생할 Resource를 넘겨받아 MediaPlayer를 초기화 하는 method
	private void init(Media media) {
		// mediaPlayer가 존재하면 초기화
		if(mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer = null;
		}
		
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
		setProgress(0.0,"0/0 sec");
		setMediaPlayer();
		
		// volume 조절
		sliderVolume.valueProperty().addListener(
				new ChangeListener<Number>() {
					@Override
					public void changed(
							ObservableValue<? extends Number> observable,
							Number oldValue,
							Number newValue) {
						double volume = newValue.doubleValue();
						// volume 조절 method
						// mediaPlayer 의 volume 은 0 ~ 1.0
						volume = (volume / 100.0);
						System.out.println("volume : " + volume);
						mediaPlayer.setVolume(volume);
					}
				});
		
		sliderPlay.valueProperty()
		.addListener((target,oldValue,newValue)->{
			Duration totalDuration = mediaPlayer.getTotalDuration();
			// 0 ~ 1.0
			double value = sliderPlay.getValue() / 100.0;
			// 26 * 0.5 = 13 : 50%
			//0 ~ 1
			// 1/1000 단위로 전체 재생시간을 가지고 와서 slider의 값으로 %를 산출
			double totalValue = totalDuration.toMillis();
			double now = totalValue * value;
			System.out.println("now : " + now);
			// Duration 에 지정된 플레이 시간으로
			// 재생시간을 변경
			mediaPlayer.seek(new Duration(now));
			mediaPlayer.play();
		});
		
		// 재생, 일시정지, 중지 버튼 초기화
		btnPlay.setOnAction(event->{
			// resource 실행
			if(endOfMedia) {
				mediaPlayer.stop();
			}
			endOfMedia = false;
			mediaPlayer.play();
			
			// Duration
			mediaPlayer.currentTimeProperty()
			.addListener((target,oldValue,newValue)->{
				// 현재 재생 중인 파일의 전체 시간을 초단위로 가져옴
				double totalTime 
					= mediaPlayer.getTotalDuration().toSeconds();
				// 현재 재생 위치 시간을 초단위로 가져옴
				double currentTime 
					= mediaPlayer.getCurrentTime().toSeconds();
				String lblText = (int)currentTime+"/"+(int)totalTime+" sec";
				double progress = currentTime/totalTime;
				setProgress(progress, lblText);
			});
		});
		
		btnPause.setOnAction(event->{
			// 일시정지
			mediaPlayer.pause();
		});
		
		btnStop.setOnAction(event->{
			// 중지
			mediaPlayer.stop();			
		});
	}
	
	// MediaPlayer 초기화
	public void setMediaPlayer() {
		// 재생 준비가 완료 되었을때
		mediaPlayer.setOnReady(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);
			}
		});
		// play 상태 일때
		mediaPlayer.setOnPlaying(()->{
			btnPlay.setDisable(true);
			btnPause.setDisable(false);
			btnStop.setDisable(false);
		});
		
		// 일시 정지
		mediaPlayer.setOnPaused(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});
		
		// endOfFile
		mediaPlayer.setOnEndOfMedia(()->{
			endOfMedia = true;
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});
		
		// 중지 Stop
		mediaPlayer.setOnStopped(()->{
			// mediaPlayer에 등록된 미디어의 재생 시작 시간을 가져옴
			Duration duration = mediaPlayer.getStartTime();
			// 재생시간을 설정하는 method
			mediaPlayer.seek(duration);
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});
	}
	
	// progress 초기화
	public void setProgress(double p , String lblText) {
		progressBar.setProgress(p);
		progressIndicator.setProgress(p);
		lblTime.setText(lblText);
	}
	
	
	// Media 교체 이번트 처리 - 재생파일변경
	public void changeResource(ActionEvent event) {
		Button btn = (Button)event.getTarget();
		String text = btn.getText();
		URL url = null;
		switch(text) {
			case "영상1" :
				url = getClass().getResource("../media/video.m4v");
				break;
			case "영상2" :
				url = getClass().getResource("../media/video.mp4");
				break;
			case "노래1" :
				url = getClass().getResource("../media/audio.mp3");
				break;
			case "노래2" :
				url = getClass().getResource("../media/audio.wav");
				break;
		}
		
		media = new Media(url.toString());
		init(media);
				
	}

}


















