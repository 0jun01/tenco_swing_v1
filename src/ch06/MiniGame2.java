package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame2 extends JFrame {

	private JLabel jPlayer;
	private JLabel jPlayer_R;
	private int x = 100;
	private int y = 100;
	private final int MOVDE_DISTANCE = 50;
	private final int FRAME_WIDTH = 1000;
	private final int FRAME_HEIGHT = 1000;
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 1300;
	private JLabel backgroundMap;

	public MiniGame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("그만");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("Images/backgroundMap.png");
		Icon icon1 = new ImageIcon("Images/playerL.png");
		Icon icon2 = new ImageIcon("Images/playerR.png");
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(1000, 1000);
		backgroundMap.setLocation(0, 0);

		jPlayer = new JLabel(icon);
		jPlayer_R = new JLabel(icon2);
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		jPlayer_R = new JLabel(new ImageIcon("images/playerR.png"));
		jPlayer_R.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
	}

	private void setInitLayout() {
		setLayout(null); // 좌표 기반으로 배치관리자 변경
		add(backgroundMap);
		backgroundMap.add(jPlayer);
		jPlayer.setLocation(x, y);
		setVisible(true);

	}

	private void addEventListener() {
		// jPlayer 객체에게서만 keyListener 동작을 시키고자 한다면
		// 익명 구현클래스로 KeyLintener 인터페이스를 재정의 할 수 있다.
		// jPlayer.addKeyListener(this);
		// 데이터 타입은 키리스너

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					// 변수는 변하는 수이기도 하다.
					y -= MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

					x -= MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					x += MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					y += MOVDE_DISTANCE;
				}
				jPlayer.setLocation(x, y);
			}
		});

	}

	// 코드 테스트
	public static void main(String[] args) {
		new MiniGame2();
	}

} // end of class
