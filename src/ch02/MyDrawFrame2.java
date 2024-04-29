package ch02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 패널에 그림을 그리는 방법 자바 문법 - 중첩 클래스 ( 클래스안에 클래스를 만든 것) 외부 클래스, 내부 클래스, outer class,
 * inner class
 */
public class MyDrawFrame2 extends JFrame {

	// 내부 클래스를 외부 클래스에 사용하려면
	// 멤버로 가지고 있어야 한다.
	MyDrawPanel myDrawPanel;

	public MyDrawFrame2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("내부클래스를 활용한 그림 그리는 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawPanel = new MyDrawPanel();
	}

	private void setInitLayout() {

		add(myDrawPanel);
		setVisible(true);
	}

	// 내부 클래스 만들어 보기
	//
	// paint --> 좌표값으로 x = 0 , y = 0
	// JPanel에 있는 기능을 확장해 보자.

	class MyDrawPanel extends JPanel {

		// paints ---> x
		// print ---> x
		// paint ---> o
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			int[] arr1 = new int[50];
			for (int i = 0; i < (50 * arr1.length); i += 50) {
				g.drawLine(i, 0, i, 2000);
			}
			for (int j = 0; j < (50 * arr1.length); j += 50) {
				g.drawLine(0, j, 4000, j);
			}
			g.drawRoundRect(475, 475, 50, 50, 200, 200);
			g.fillRoundRect(525, 475, 50, 50, 200, 200);
		}
	} // end of inner class
}
