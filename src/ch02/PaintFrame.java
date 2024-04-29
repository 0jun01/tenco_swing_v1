package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 내부 클래스를 활용해서 코드를 완성해주세요
public class PaintFrame extends JFrame {

	MyDrawPanel myDrawPanel;
	
	public PaintFrame() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("내 그림");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myDrawPanel = new MyDrawPanel();
	}
	private void setInitLayout() {
		add(myDrawPanel);
		setVisible(true);
	} 
	
	class MyDrawPanel extends JPanel{
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(150, 250, 300, 300);
			g.drawRect(250, 400, 100, 150);
			g.drawRect(180, 280, 100, 100);
			g.drawLine(300, 100, 450, 250);
			g.drawLine(300, 100, 150, 250);
			g.drawString("/)__/)", 220, 369);
			g.drawString("(ㅇㅇ)", 218, 379);
			g.drawString("O", 330, 500);
			g.drawOval(10, 0, 200, 200);
		}
	}
}
