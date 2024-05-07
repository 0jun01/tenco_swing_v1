package bubble.test.ex08;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Enemy extends JLabel {
	private int x;
	private int y;

	private Player player;
	private Bubble bubble;
	private ImageIcon enemyL;
	private ImageIcon enemyR;
	private ImageIcon bubbled;

	public Enemy() {
		initData();
		setInitLayout();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Bubble getBubble() {
		return bubble;
	}

	public void setBubble(Bubble bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getEnemyL() {
		return enemyL;
	}

	public void setEnemyL(ImageIcon enemyL) {
		this.enemyL = enemyL;
	}

	public ImageIcon getEnemyR() {
		return enemyR;
	}

	public void setEnemyR(ImageIcon enemyR) {
		this.enemyR = enemyR;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public void initData() {
		x = 550;
		y = 535;
		enemyR = new ImageIcon("img/enemyL.png");
		enemyL = new ImageIcon("img/enemyR.png");
		bubbled = new ImageIcon("img/bubbled.png");
	}

	public void setInitLayout() {
		setIcon(enemyR);
		setSize(50, 50);
		setLocation(x, y);
	}

}
