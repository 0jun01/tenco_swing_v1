package ch07;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LottoFrame extends JFrame implements ActionListener {

	private JButton button;
	private LottoRandomNumber lottoRandomNumber;
	private boolean isStart = true;
	private final int NUMBER_DISTANCE = 80;

	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		setTitle("Lotto Gmae");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Game start");
		lottoRandomNumber = new LottoRandomNumber();
	}

	private void setInitLayout() {
		add(button, BorderLayout.NORTH);
		setVisible(true);
	}

	private void addEventListener() {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("그림을 그려라!");
		// 이벤트가 일어나면 그림을 다시 그려라
		isStart = false;
		repaint(); // 다시 그림을 그려라 요쳥하는 명령어 // F5와 같은 개념
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Font f = new Font("", Font.BOLD, 20);
		g.setFont(f);
		if (isStart) {
			g.drawString("로또 번호를 클릭하세요", 200, 200);
		} else {
			int[] getNumbers = lottoRandomNumber.createNumber();
			for (int i = 0; i < getNumbers.length; i++) {
				g.drawString(getNumbers[i] + " ", 100 + (i * NUMBER_DISTANCE), 200);

			}
			g.drawOval(83, 170, 50, 50);
			g.drawOval(165, 170, 50, 50);
			g.drawOval(245, 170, 50, 50);
			g.drawOval(325, 170, 50, 50);
			g.drawOval(405, 170, 50, 50);
			g.drawOval(485, 170, 50, 50);

		}
	}

	// 메인 함수
	public static void main(String[] args) {
		new LottoFrame();
	} // end of main

} // end of class
