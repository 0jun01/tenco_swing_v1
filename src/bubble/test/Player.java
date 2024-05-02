package bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	private ImageIcon playerR, playerL,enemyL,enemyR;

	public Player() {
		initData();
		setinitLayout();
	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");
		enemyR = new ImageIcon("img/enemyR.png");
		enemyL = new ImageIcon("img/enemyL.png");

		// 처음 실행 시 초기 값 셋팅
		x = 55;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void setinitLayout() {
	}

	@Override
	public void left() {
		// 왼쪽 방향키 이벤트 발생 시
		// 이미지를 왼쪽으로 보는 이미지로 셋팅
		setIcon(playerL);
		x -= 10;
		setLocation(x, y);

	}

	@Override
	public void right() {
		setIcon(playerR);
		x += 10;
		setLocation(x, y);
	}

	@Override
	public void up() {
		y -= 10;
		setLocation(x, y);

	}

	@Override
	public void down() {

	}

}
