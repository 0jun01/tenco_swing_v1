package ch02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import ch01.FlowLayoutEx;

public class MyFramePanel extends JFrame {

	private JButton button1;
	private JButton button2;
	// 패널 추가하기
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	public MyFramePanel() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("패널추가 연습");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel1 = new JPanel();
		panel1.setBackground(Color.PINK);
		panel2 = new JPanel();
		panel2.setBackground(Color.black);
		panel3 = new JPanel();
		panel3.setBackground(Color.black);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
	}

	private void setInitLayout() {
		// 루트 패널 --> BorderLayout
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		add(panel3, BorderLayout.NORTH);

		panel1.add(button1);
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(button2);
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));

		setVisible(true);

	}

	public static void main(String[] args) {
		new MyFramePanel();
	}

}
