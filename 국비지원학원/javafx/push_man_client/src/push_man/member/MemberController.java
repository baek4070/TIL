package push_man.member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import push_man.main.ClientMain;
import push_man.vo.MemberVO;

public class MemberController implements Initializable , MemberInterface{

	@FXML private WebView webView;
	@FXML private ImageView imageView;
	@FXML private AnchorPane joinAnchor, loginAnchor;
	@FXML private TextField loginID, joinID, joinName;
	@FXML private PasswordField loginPW, joinPW, joinRePW;
	@FXML private Button btnLogin, btnJoin;
	@FXML private Hyperlink loginLinkBtn, joinLinkBtn;
	@FXML private Label checkID;
	
	// 중복아이디 체크 완료
	boolean isJoin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ClientMain.thread.memberController = this;
		
		WebEngine wg = webView.getEngine();
		wg.load("https://www.youtube.com/embed/0xBu251omcw");
		wg.getLoadWorker().stateProperty()
		.addListener(new ChangeListener<State>() {
			@Override
			public void changed(
					ObservableValue<? extends State> observable, 
					State oldValue, 
					State newValue) {
				// WebView Load 완료 상태
				if(newValue.equals(State.SUCCEEDED)) {
					imageView.setVisible(false);
				}
			}
		});
		
		setHyperLink();
		setJoinEvent();
		setLoginEvent();
		System.out.println("완료");
		
	}
	
	
//-------------------------------------Memberinterface 구현---------------------------------------
	// 로그인  <-> 회원가입 화면 전환
	@Override
	public void setHyperLink() {
		joinLinkBtn.setOnAction(e->{
			Platform.runLater(()->{
				loginAnchor.setVisible(false);
				loginAnchor.setDisable(true);
				joinAnchor.setVisible(true);
				joinAnchor.setDisable(false);
				joinID.requestFocus();
			});
		});
		
		loginLinkBtn.setOnAction(e->{
			loginAnchor.setVisible(true);
			loginAnchor.setDisable(false);
			joinAnchor.setVisible(false);
			joinAnchor.setDisable(true);
			loginID.requestFocus();
		});
	}
	// login UI 초기화
	@Override
	public void initLoginUI() {
		Platform.runLater(()->{
			loginID.clear();
			loginPW.clear();
			loginID.requestFocus();
		});
	}
	// join UI 초기화
	@Override
	public void initJoinUI() {
		Platform.runLater(()->{
			joinID.clear();
			joinPW.clear();
			joinName.clear();
			joinRePW.clear();
			joinID.requestFocus();
		});
	}
	// login event 초기화
	@Override
	public void setLoginEvent() {
		
	}
	// join event 초기화
	@Override
	public void setJoinEvent() {
		joinID.textProperty().addListener((o,b,text)->{
			System.out.println(text);
			if(!text.trim().equals("")) {
				MemberVO member = new MemberVO(text);
				// 아이디 중복 체크
				member.setOrder(0);
				ClientMain.thread.sendData(member);
			}else {
				setJoinIDCheck(false);
			}
		});
		
		btnJoin.setOnAction(event->{
			String id = joinID.getText().trim();
			String pw = joinPW.getText().trim();
			String repw = joinRePW.getText().trim();
			String nick = joinName.getText().trim();
			
			if(id.equals("") || !isJoin) {
				joinID.clear();
				joinID.requestFocus();
			}else if(!pw.equals(repw)) {
				joinPW.clear();
				joinRePW.clear();
				joinPW.requestFocus();
				checkID.setText("비밀번호가 일치하지 않습니다.");
			}else {
				MemberVO member = new MemberVO(nick,id,pw);
				member.setOrder(1);
				ClientMain.thread.sendData(member);
			}
					
		});
	}

	// 아이디 중복체크 UI 변경
	@Override
	public void setJoinIDCheck(boolean isChecked) {
		Platform.runLater(()->{
			String style = isChecked ? "-fx-text-fill:green;" : "-fx-text-fill:red;" ;
			String text = isChecked ? "사용가능합니다." : "사용할 수 없는 아이디입니다." ;
			checkID.setStyle(style);
			checkID.setText(text);
		});
	}
	// 회원가입 성공 유무
	@Override
	public void setJoinCheck(boolean isSuccess) {
		if(isSuccess) {
			System.out.println("회원가입 성공");
			joinAnchor.setVisible(false);
			joinAnchor.setDisable(true);
			loginAnchor.setVisible(true);
			loginAnchor.setDisable(false);
			initLoginUI();
		}else {
			System.out.println("회원가입 실패");
			initJoinUI();
		}
	}
	// 로그인 성공 여부 check
	@Override
	public void setLoginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}
	// 0 : 아이디 중복체크 | 1 : 회원가입 | 2 로그인
	@Override
	public void receiveData(MemberVO vo) {
		// 0  아이디 중복 체크  1 회원가입 2 로그인
		switch(vo.getOrder()) {
		case 0 :
			System.out.println("아이디 중복 체크");
			isJoin = vo.isSuccess();
			setJoinIDCheck(isJoin);
			break;
		case 1 : 
			System.out.println("회원가입 요청 처리 결과");
			setJoinCheck(vo.isSuccess());
			break;
		case 2 : 
			System.out.println("로그인 요청 처리 결과");
			break;
		}
	}
	// 게임화면 오픈
	@Override
	public void showGameRoom() {
		
	}
//-------------------------------------Memberinterface 구현 끝---------------------------------------

}









