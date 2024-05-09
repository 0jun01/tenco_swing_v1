package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bush extends JLabel {

	private ImageIcon bush;
	private int x;
	private int y;
	private MainFrame mContext;
	private boolean hide;

	public Bush(MainFrame mContext) {
		this.mContext = mContext;
		x = 500;
		y = 500;
		initData();
		setInitLayout();
	}

	public void initData() {
		bush = new ImageIcon("IMG/vilige_Bush1.png");
		setSize(50, 50);
		setIcon(bush);
		setLocation(x, y);

	}

	public void setInitLayout() {
	}

	// 부쉬 숨기
	public void hideOnBush() {
		hide = true;
		if (x <= (mContext.getPlayer1().getX() + 40) && x >= (mContext.getPlayer1().getX() - 40)) {
			if (y <= (mContext.getPlayer1().getY() + 60) && y >= (mContext.getPlayer1().getY() - 40)) {
				mContext.getPlayer1().setIcon(null);
			}
		}
//		if (mContext.getPlayer1().getX() == x && mContext.getPlayer1().getY() == y) {
//			setIcon(null);
//		}
	}
}