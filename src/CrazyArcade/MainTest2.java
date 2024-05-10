package CrazyArcade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;

public class MainTest2 extends JFrame {
//	private JPanel panelSouth;
//	JPanel panelNorth;
	private JButton button;
	int b =0;
	private JPanel panelCenter;
	private ArrayList<JPanel> arrayListJpanels = new ArrayList<JPanel>(100);

	public MainTest2() {
		initData();
		setInitLayout();
		// repaint();
	}

	public void initData() {
		// Boarder Layout
		setSize(1000, 1100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelCenter = new JPanel();
//		setResizable(false);
//		panelNorth = new JPanel(); // Flow Layout 
//		panelNorth.setBackground(Color.YELLOW);
//		panelSouth = new JPanel();
//		panelSouth.setBackground(Color.PINK);
//		button = new JButton("button");

		// setLayout(null);
		// setLocation(0, 0);

	}

	public void setInitLayout() {

		panelCenter.setLayout(null); // 좌표
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(Color.BLUE);
//		add(panelSouth, BorderLayout.SOUTH);
//		panelSouth.add(button, BorderLayout.EAST);
//		panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		addPanel();
		setVisible(true);

	}

	public void addPanel() {
		System.out.println("12");
		// this.setLayout(getLayout());

		// 생성
		for (int i = 0; i < 100; i++) {
			arrayListJpanels.add(new CreatePanel());
		}

//		// 설정 
//		for (int i = 0; i < arrayListJpanels.size(); i++) {
//			
//		}
//		
		int c =0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// System.out.println("i : " + i);
				arrayListJpanels.get(c).setSize(100, 100);
				arrayListJpanels.get(c).setLocation(i*100, j*100);
				panelCenter.add(arrayListJpanels.get(c));
				c++;
			}
		}

		System.out.println(panelCenter.getWidth());
		System.out.println(panelCenter.getHeight());

//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
////				new Thread(new CreatePanel(j, i, this)).start();
//				arrayListJpanels.add(new CreatePanel(j, i, this));
//				panelCenter.add(new CreatePanel(j, i, this));
//			}
//		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					b++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (b == 7) {
					System.out.println("asdf");
					int c = 0;
					for (int i = 0; i < 10; i++) {
						for (int j = 0; j < 10; j++) {
							// System.out.println("i : " + i);
							arrayListJpanels.get(c).setVisible(false);
							c++;
							
						}
					}
				}
				}
				
				
			}
		}).start();

	}

	public static void main(String[] args) {
		new MainTest2();
	}
}