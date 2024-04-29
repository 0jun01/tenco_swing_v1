package ch04;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * JLabel 이용해서 이미지를 다룰 수 있다. Jlabel.add(); 메서드를 통해서 이미지를 겹칠 수 있다 좌표 기준으로 이미지를
 * 셋팅을 하려면 배치관리자를 null 값으로 셋팅 해야한다.
 */

public class MyFrame extends JFrame {

	private JLabel backgroundMap;
	private JLabel player;

	public MyFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("JLable을 활용한 이미지 사용 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("Images/background2.jpg"); // 인터페이스는 new를 쓸 수 없는데 업 캐스팅 상태
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(500, 500);
		backgroundMap.setLocation(0, 0);

		player = new JLabel(new ImageIcon("Images/images3.png"));
		player.setSize(103, 100);
		player.setLocation(200, 100);
	}

	private void setInitLayout() {
		// 좌표값을 셋팅하기 위해서는 배치관리자를 null 값으로 만들어 주어야 한다.
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player);
		setVisible(true);
	}

}
