package CrazyArcade;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CreatePanel extends JPanel implements Runnable {
	MainTest2 mContext;
	// private JPanel panel;
	int positionX;
	int positionY;
	int count;
	
	public CreatePanel() {
		//initData();
		count = 1;
		setInitLayout();
		new Thread(this).start();
	}
	
	public CreatePanel(int x, int y, MainTest2 m) {

		this.positionX = x;
		this.positionY = y;
		this.mContext = m;
		initData();
		setInitLayout();

	}

	public void initData() {
		setLayout(null);
		setSize(100, 100);
		//setLocation(positionX * 100, positionY * 100);
		count = 1;
	}

	@Override
	public void run() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (count % 3 == 1) {
					setBackground(Color.red);
				} else if (count % 3 == 2) {
					setBackground(Color.blue);
				} else if (count % 3 == 0) {
					setBackground(Color.white);
				}
				count++;
			}
		});
	}

	public void setInitLayout() {
		setBackground(Color.white);
		
	}
}
