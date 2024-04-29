package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ColorChangeFrame2 extends JFrame implements ActionListener {

	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;

	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("나다");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // BorderLayout
		panel = new JPanel();
		panel.setBackground(Color.yellow);
		button1 = new JButton("click1");
		button2 = new JButton("click2");
		button2 = new JButton("click3");
		button2 = new JButton("click4");
		setVisible(true);
	}

	private void setInitLayout() {
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
	}

	// 이 메서드의 책임은 이벤트 리스너만 등록
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	// 코드 테스트
	public static void main(String[] args) {
		new ColorChangeFrame2();
	}

	// 오버라이드 메서드는 이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		// 주소값으로 비교도 가능
		// 문자열 값으로 비교 가능
		JButton selectedButton = (JButton) e.getSource();
		if (selectedButton == this.button1) {
			panel.setBackground(Color.yellow);
		} else if (selectedButton == this.button2) {
			panel.setBackground(Color.pink);
		} else {
			panel.setBackground(Color.black);
		}

		System.out.println(e.getSource().toString());
		// panel.setBackground(Color.black);
	}
}
