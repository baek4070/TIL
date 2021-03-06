package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import login.ButtonSound;
import login.JDBCModel;
import waiting.Waiting;

public class Game{
	
	private JFrame frame;
	private Canvas canvas;
	private JButton blackBtn, redBtn, greenBtn, blueBtn, yellowBtn, eraserBtn, clearBtn, exitBtn, startBtn;
	private JSlider slider;
	private PaintCanvas paintCanvas;
	private JLabel timerLabel, nickname1, grade1, score1, nickname2, grade2, score2, nickname3, grade3, score3, nickname4, grade4, score4;
	private Thread timer, nickname_and_score_Setter, startThread;
	private double i, j;
	private JDBCModel model;
	private JTextField chatInput;
	private JTextArea chatLog;
	private GameChat gameChat;
	private String nickName, answer;
	private boolean isowner;
	private GameBGM gameBGM;
	private static int gameNumber;
	private ButtonSound bs;
	
	
	
	public Game(String nickName, JDBCModel model, JFrame exFrame) {
		this.nickName = nickName;
		this.model = model;
		gameBGM = new GameBGM();
		gameBGM.playBGM();
		
		
		
		
		ImageIcon blackBtnIcon = new ImageIcon("blackBtnIcon.png");
		ImageIcon redBtnIcon = new ImageIcon("redBtnIcon.png");
		ImageIcon greenBtnIcon = new ImageIcon("greenBtnIcon.png");
		ImageIcon blueBtnIcon = new ImageIcon("blueBtnIcon.png");
		ImageIcon yellowBtnIcon = new ImageIcon("yellowBtnIcon.png");
		ImageIcon eraserBtnIcon = new ImageIcon("eraserBtnIcon.png");
		ImageIcon clearBtnIcon = new ImageIcon("clearBtnIcon.png");
		ImageIcon exitBtnIcon = new ImageIcon("exitBtnIcon.png");
		ImageIcon startBtnIcon = new ImageIcon("startBtnIcon.jpg");
		//---------------------------frame------------------------------
		frame = new JFrame("?????????");
		frame.setBounds(500,100,1024,768);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(exFrame);
		
		startBtn = new JButton(startBtnIcon);
		startBtn.setBounds(846, 367, 110, 36);
		frame.getContentPane().add(startBtn);
		
		timerLabel = new JLabel("");
		timerLabel.setBounds(222, 596, 133, 36);
		frame.getContentPane().add(timerLabel);
		
		blackBtn = new JButton(blackBtnIcon);
		blackBtn.setBounds(272, 546, 42, 70);
		frame.getContentPane().add(blackBtn);
		
		redBtn = new JButton(redBtnIcon);
		redBtn.setBounds(326, 546, 42, 70);
		frame.getContentPane().add(redBtn);
		
		greenBtn = new JButton(greenBtnIcon);
		greenBtn.setBounds(380, 546, 42, 70);
		frame.getContentPane().add(greenBtn);
		
		blueBtn = new JButton(blueBtnIcon);
		blueBtn.setBounds(434, 546, 42, 70);
		frame.getContentPane().add(blueBtn);
		
		yellowBtn = new JButton(yellowBtnIcon);
		yellowBtn.setBounds(488, 546, 42, 70);
		frame.getContentPane().add(yellowBtn);
		
		eraserBtn = new JButton(eraserBtnIcon);
		eraserBtn.setBounds(584, 578, 42, 38);
		frame.getContentPane().add(eraserBtn);
		
		clearBtn = new JButton(clearBtnIcon);
		clearBtn.setBounds(638, 566, 112, 50);
		frame.getContentPane().add(clearBtn);
		
		exitBtn = new JButton(exitBtnIcon);
		exitBtn.setBounds(894, 10, 106, 43);
		frame.getContentPane().add(exitBtn);
		
		slider = new JSlider();
		slider.setBackground(new Color(0, 153, 204));
		slider.setBounds(570, 527, 180, 36);
		frame.getContentPane().add(slider);
		
		paintCanvas = new PaintCanvas(Game.this);
		canvas = paintCanvas.getCanvas(); 
		canvas.setBounds(250, 157, 516, 345);
		frame.getContentPane().add(canvas);
		
		canvas.addMouseListener(new MouseAdapter() {         
	         @Override
	         public void mouseEntered(MouseEvent e) {
	        	if(!isowner) return;
	            Toolkit tk = Toolkit.getDefaultToolkit();
	            Image cursorimage=tk.getImage("pencilcursor.png");
	            Point point=new Point(0,0);
	            Cursor cursor=tk.createCustomCursor(cursorimage, point, "GG");
	            canvas.setCursor(cursor);
	         }
	      });

		nickname1 = new JLabel("");
		nickname1.setHorizontalAlignment(SwingConstants.CENTER);
		nickname1.setBounds(38, 157, 94, 26);
		frame.getContentPane().add(nickname1);
		
		grade1 = new JLabel("");
		grade1.setHorizontalAlignment(SwingConstants.CENTER);
		grade1.setBounds(38, 182, 94, 26);
		frame.getContentPane().add(grade1);
		
		score1 = new JLabel("");
		score1.setHorizontalAlignment(SwingConstants.CENTER);
		score1.setBounds(39, 207, 94, 26);
		frame.getContentPane().add(score1);
		
		nickname2 = new JLabel("");
		nickname2.setHorizontalAlignment(SwingConstants.CENTER);
		nickname2.setBounds(806, 154, 94, 26);
		frame.getContentPane().add(nickname2);
		
		grade2 = new JLabel("");
		grade2.setHorizontalAlignment(SwingConstants.CENTER);
		grade2.setBounds(806, 178, 94, 26);
		frame.getContentPane().add(grade2);
		
		score2 = new JLabel("");
		score2.setHorizontalAlignment(SwingConstants.CENTER);
		score2.setBounds(806, 202, 94, 26);
		frame.getContentPane().add(score2);
		
		nickname3 = new JLabel("");
		nickname3.setHorizontalAlignment(SwingConstants.CENTER);
		nickname3.setBounds(34, 269, 94, 26);
		frame.getContentPane().add(nickname3);
		
		grade3 = new JLabel("");
		grade3.setHorizontalAlignment(SwingConstants.CENTER);
		grade3.setBounds(34, 294, 94, 26);
		frame.getContentPane().add(grade3);
		
		score3 = new JLabel("");
		score3.setHorizontalAlignment(SwingConstants.CENTER);
		score3.setBounds(34, 318, 94, 26);
		frame.getContentPane().add(score3);
		
		nickname4 = new JLabel("");
		nickname4.setHorizontalAlignment(SwingConstants.CENTER);
		nickname4.setBounds(806, 266, 94, 26);
		frame.getContentPane().add(nickname4);
		
		grade4 = new JLabel("");
		grade4.setHorizontalAlignment(SwingConstants.CENTER);
		grade4.setBounds(806, 290, 94, 26);
		frame.getContentPane().add(grade4);
		
		score4 = new JLabel("");
		score4.setHorizontalAlignment(SwingConstants.CENTER);
		score4.setBounds(806, 314, 94, 26);
		frame.getContentPane().add(score4);
		
		chatInput = new JTextField();
		chatInput.setBounds(798, 624, 210, 26);
		frame.getContentPane().add(chatInput);
		chatInput.setColumns(10);
		
		chatLog = new JTextArea();
		JScrollPane scroll = new JScrollPane(chatLog);
		scroll.setBounds(798, 413, 210, 205);
		frame.getContentPane().add(scroll);
		
		
		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		//---------------------------End of frame------------------------------
		
		
		//---------------------------button actions----------------------------
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				bs = new ButtonSound();
				int sel = JOptionPane.showConfirmDialog(frame, "?????? ???????");
				if(!(sel == JOptionPane.YES_OPTION)) {
					bs = new ButtonSound();
					return; 
				}
				bs = new ButtonSound();
				
				
				model.addScoreWhenExitRoom(nickName);
				int no = model.exitScoreReset(nickName);
	
				System.out.println("?????? ?????? ??????");
				
				//?????? ?????? ???????????? ????????? db?????? ????????? isonline ?????? 0?????? ??????
				model.setOffline(model.getEmailByNickName(nickName));
				//room1593 ??????????????? ????????? ????????? ??????
				model.exitGame(nickName);
				
				//????????? ????????? ?????? room1593 ??????????????? ????????? ?????? row??? isOwner ?????? 0?????? ??????
				if(model.isOwner(nickName)) {
					System.out.println("????????? ???????????????");
					model.ownerExit(nickName);
					
					//??? ?????? ????????????
					
					//1. ?????? ?????? ?????? ????????? 1?????? isOwner 1??? ??????
					if(model.isEmptyRoom()) {
						model.setOwner(1);
					}else {
					//2. ?????? ?????? ?????? ????????? ?????? ?????? no?????? ?????? ???????????? isOwner 1 ??????  
						no = model.getFilledRow();
						model.setOwner(no);
					}
				}

				//?????? ?????? ????????????
				GameChatDTO gameChatDTO = new GameChatDTO();
				gameChatDTO.setCommand(Info.EXIT);
				try {
					gameChat.getWriter().writeObject(gameChatDTO);
					gameChat.getWriter().flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//?????? ?????? ????????????
				PaintDTO paintDTO = new PaintDTO();
				paintDTO.setSignal(3);
				try {
					paintCanvas.getWriter().writeObject(paintDTO);
					paintCanvas.getWriter().flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bs = new ButtonSound();
				int sel = JOptionPane.showConfirmDialog(frame, "???????????? ??????????????????????!!!!!!!!");
				if(!(sel == JOptionPane.YES_OPTION)) {
					bs = new ButtonSound();
					return;
				}
				
				model.addScoreWhenExitRoom(nickName);
				int no = model.exitScoreReset(nickName);
				
				gameBGM.stopBGM();
				bs = new ButtonSound();
				System.out.println("?????? ?????? ??????");
				//?????? ?????? ????????????(????????? ????????? ??????)
				//????????? ???????????? 0?????? ?????? 1?????? ?????????1 ?????? room1593??????????????? ?????? ?????? 
				if(model.isEmptyRoom()) {
					System.out.println("????????????");
					model.ownerExit(nickName);
					System.out.println("???????????? ??????");
					model.setOwner(1);
					System.out.println("1?????? ?????? ??????");
					model.exitGame(nickName);
					System.out.println("db?????? ?????????");
				}
				
				//?????? ?????? ??? ?????? + ?????? | ??????????????? ?????? ??????
				if(model.isOwner(nickName)) {
					model.ownerExit(nickName);
					model.exitGame(nickName);
					no = model.getFilledRow();
					System.out.println(no + "????????? ?????? ???????????????");
					model.setOwner(no);
					System.out.println("?????? ?????? ??????");
				}else model.exitGame(nickName);
				
				
				//?????? ?????? ????????????
				GameChatDTO gameChatDTO = new GameChatDTO();
				gameChatDTO.setCommand(Info.EXIT);
				try {
					gameChat.getWriter().writeObject(gameChatDTO);
					gameChat.getWriter().flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//?????? ?????? ????????????
				PaintDTO paintDTO = new PaintDTO();
				paintDTO.setSignal(3);
				try {
					paintCanvas.getWriter().writeObject(paintDTO);
					paintCanvas.getWriter().flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				new Waiting(frame, model.getEmailByNickName(nickName), model);
				frame.dispose();
			}
		});
		
		
		
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bs = new ButtonSound();
				answer = model.randomAnswer();
				if(isowner) {
					JOptionPane.showMessageDialog(frame, "???????????? ????????? : " + answer);
				}
				startBtn.setEnabled(false);
			}
		});
		
		
		
		//???????????? ??? ????????? ?????? ?????? ?????? ???????????? ?????????
		Thread nickname_and_score_Setter = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					model.displayForRoom(1593, nickname1, nickname2, nickname3, nickname4, score1, score2, score3, score4);
					model.setGrade(nickname1.getText(), grade1);
					model.setGrade(nickname2.getText(), grade2);
					model.setGrade(nickname3.getText(), grade3);
					model.setGrade(nickname4.getText(), grade4);
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("?????? ??? ????????? ?????? ???????????? ?????? ???????????????");
					}
				}
			}
		});
		nickname_and_score_Setter.setDaemon(true);
		nickname_and_score_Setter.start();

		//????????? ???????????? ????????????????????? ???????????? ?????????
		Thread barSetter = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					//model.displayEXP(nickname1, nickname2, nickname3, nickname4);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("??? ?????? ???????????? ?????? ???????????????");
					}
				}
				
			}
		});
		barSetter.setDaemon(true);
		//barSetter.start();
		
		Thread startThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (model.isOwner(nickName)) {
						startBtn.setBounds(846, 367, 110, 36);
						isowner = true;
						chatInput.setEnabled(false);
					}else {
						startBtn.setBounds(-200, -100, 110, 36);
						isowner = false;
						chatInput.setEnabled(true);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("????????? ????????? ???????????? ?????? ???????????????");
					}
				}
			}
		});
		startThread.setDaemon(true);
		startThread.start();

		gameChat = new GameChat(Game.this);
		
		
		
		JPanel panel = new JPanel(){
			Image background = new ImageIcon("gamebackground.png").getImage();
			@Override
			public void paint(Graphics g) {
				g.drawImage(background, 0, 0, frame);		
			};
		};
		panel.setBounds(-5,5,1024,768);
		frame.getContentPane().add(panel);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		
		
		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + ", " + e.getY());
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	//GamePlayRoom Constructor
	
	
	//---------------------getter & setter-----------------------
	public JFrame getFrame() {return frame;}
	public Canvas getCanvas() {return canvas;}
	public JButton getBlackBtn() {return blackBtn;}
	public JButton getRedBtn() {return redBtn;}
	public JButton getGreenBtn() {return greenBtn;}
	public JButton getBlueBtn() {return blueBtn;}
	public JButton getYellowBtn() {return yellowBtn;}
	public JButton getEraserBtn() {return eraserBtn;}
	public JButton getClearBtn() {return clearBtn;}
	public JButton getExitBtn() {return exitBtn;}
	public JSlider getSlider() {return slider;}
	public PaintCanvas getPaintCanvas() {return paintCanvas;}
	public JTextArea getChatLog() {return chatLog;}
	public JTextField getChatInput() {return chatInput;}
	public String getNickName() {return nickName;}
	public JDBCModel getModel() {return model;}
	public boolean getIsOwner() {return isowner;}
	public String getAnswer() {return answer;}
	public JButton getStartBtn() {return startBtn;}
	public int getGameNumber() {return gameNumber;}
	
	
	
}