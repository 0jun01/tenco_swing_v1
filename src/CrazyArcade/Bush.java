package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bush extends JLabel {

	private ImageIcon bush;
	private int x;
	private int y;
	private MainFrame mContext;

	public Bush(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		x = 500;
		y = 500;
	}

	public void initData() {
		bush = new ImageIcon("IMG/vilige_Bush1.png");

	}

	public void setInitLayout() {
		setSize(50, 50);
		setIcon(bush);
		setLocation(x, y);
	}
}
