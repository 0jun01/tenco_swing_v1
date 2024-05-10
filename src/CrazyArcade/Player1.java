package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player1 extends JLabel implements Moveable {

	private int x;
	private int y;
	private int walkCount;
	private ImageIcon playerR, playerL;
	private ImageIcon bazziUp1;
	private ImageIcon bazziUp2;
	private ImageIcon bazziUp3;
	private ImageIcon bazziUp4;
	private ImageIcon bazziUp5;

	private ImageIcon bazziDown1;
	private ImageIcon bazziDown2;
	private ImageIcon bazziDown3;
	private ImageIcon bazziDown4;
	private ImageIcon bazziDown5;

	private ImageIcon bazziR1;
	private ImageIcon bazziR2;
	private ImageIcon bazziR3;
	private ImageIcon bazziR4;

	private ImageIcon bazziL1;
	private ImageIcon bazziL2;
	private ImageIcon bazziL3;
	private ImageIcon bazziL4;
	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean blueWallCrash;

	private boolean lastStandingAreaRed;
	private MainFrame mContext;

	PlayerWay playerWay;

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

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean islastStandingAreaRed() {
		return lastStandingAreaRed;
	}

	public void setlastStandingAreaRed(boolean lastStandingAreaRed) {
		this.lastStandingAreaRed = lastStandingAreaRed;
	}

	public boolean isblueWallCrash() {
		return blueWallCrash;
	}

	public void setbluetWallCrash(boolean blueWallCrash) {
		this.blueWallCrash = blueWallCrash;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isUp() {
		return up;
	}

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
	}

	// setter
	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	// 플레이어 속도 상태
	private final int SPEED = 1;
	private final int JUMPSPEED = 2;
	private final int SLEEPTIME = 3;

	public Player1(MainFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;

	}

	private void initData() {

		playerR = new ImageIcon("IMG/bazzi_front.png");
		playerL = new ImageIcon("IMG/bazziL.png");

		bazziL1 = new ImageIcon("IMG/bazzi_Left1.png");
		bazziL2 = new ImageIcon("IMG/bazzi_Left2.png");
		bazziL3 = new ImageIcon("IMG/bazzi_Left3.png");
		bazziL4 = new ImageIcon("IMG/bazzi_Left4.png");

		bazziR1 = new ImageIcon("IMG/bazzi_Right1.png");
		bazziR2 = new ImageIcon("IMG/bazzi_Right2.png");
		bazziR3 = new ImageIcon("IMG/bazzi_Right3.png");
		bazziR4 = new ImageIcon("IMG/bazzi_Right4.png");

		bazziUp1 = new ImageIcon("IMG/bazzi_Up1.png");
		bazziUp2 = new ImageIcon("IMG/bazzi_Up2.png");
		bazziUp3 = new ImageIcon("IMG/bazzi_Up3.png");
		bazziUp4 = new ImageIcon("IMG/bazzi_Up4.png");
		bazziUp5 = new ImageIcon("IMG/bazzi_Up5.png");

		bazziDown1 = new ImageIcon("IMG/bazzi_Down1.png");
		bazziDown2 = new ImageIcon("IMG/bazzi_Down2.png");
		bazziDown3 = new ImageIcon("IMG/bazzi_Down3.png");
		bazziDown4 = new ImageIcon("IMG/bazzi_Down4.png");
		bazziDown5 = new ImageIcon("IMG/bazzi_Down5.png");
		// 처음 실행시 초기값 셋팅
		x = 355;
		y = 536;
		walkCount = 0;
		// 플레이어 가만히 멈춘 상태
		left = false;
		right = false;
		up = false;
		down = false;

		playerWay = PlayerWay.RIGHT;

		leftWallCrash = false;
		rightWallCrash = false;
		blueWallCrash = false;
		lastStandingAreaRed = true;

		setIcon(playerR);
		setSize(100, 100);
		setLocation(x, y);

	}

	private void setInitLayout() {

	}

	public void hideOnBush() {

	}

	@Override
	public void left() {
		playerWay = PlayerWay.LEFT;
		left = true;
		walkCount = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					System.out.println(walkCount);
					if (walkCount == 0) {
						setIcon(bazziL4);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(bazziL3);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(bazziL2);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(bazziL1);
						walkCount = 0;
					}
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					x -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(SLEEPTIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					mContext.getBush().hideOnBush();
					repaint();
				}

			}
		}).start();
	}

	@Override
	public void right() {
		playerWay = PlayerWay.RIGHT;
		right = true;
		walkCount = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					System.out.println(walkCount);
					if (walkCount == 0) {
						setIcon(bazziR1);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(bazziR2);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(bazziR3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(bazziR4);
						walkCount = 0;
					}
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					x += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(SLEEPTIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					mContext.getBush().hideOnBush();
					repaint();
				}

			}

		}).start();
	}

	@Override
	public void up() {
		playerWay = PlayerWay.UP;
		up = true;
		walkCount = 0;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (up) {
					if (walkCount == 0) {
						setIcon(bazziUp1);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(bazziUp2);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(bazziUp3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(bazziUp4);
						walkCount = 4;
					} else if (walkCount == 4) {
						setIcon(bazziUp5);
						walkCount = 0;
					}
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (up) {

					y -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(SLEEPTIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					mContext.getBush().hideOnBush();
					repaint();
				}
				blueWallCrash = false;
			}
		}).start();

	}

	@Override
	public void down() {
		playerWay = PlayerWay.DOWN;
		down = true;
		walkCount = 0;

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					if (walkCount == 0) {
						setIcon(bazziDown1);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(bazziDown2);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(bazziDown3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(bazziDown4);
						walkCount = 4;
					} else if (walkCount == 4) {
						setIcon(bazziDown5);
						walkCount = 0;
					}
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (down) {
					y += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(SLEEPTIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					mContext.getBush().hideOnBush();
					repaint();
				}
				blueWallCrash = false;

			}
		}).start();

	}
}