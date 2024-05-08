package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Box extends JLabel {
	private int x;
	private int y;

	private ImageIcon box1;
	private ImageIcon box2;

	private MainFrame mContext;

	public Box(MainFrame mContext, int i, int j) {
		this.mContext = mContext;
		this.x = j * 100;
		this.y = i * 100;
		initData();
		setInitLayout();

	}

	public void initData() {
		x = 0;
		y = 0;

		box1 = new ImageIcon("IMG/box_unbreak.png");
		setIcon(box1);
		setSize(100, 100);
		setLocation(x, y);
		setVisible(true);
	}

	public void setInitLayout() {

	}

}
