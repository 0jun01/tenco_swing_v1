package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ColorChangeFrame3 extends JFrame implements ActionListener {

	private JPanel panel;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;

	public ColorChangeFrame3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		setTitle("나야");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		panel = new JPanel();
		panel2 = new JPanel();
		button1 = new JButton("버튼1");
		button2 = new JButton("버튼2");
		button3 = new JButton("버튼3");
		button4 = new JButton("버튼4");
		panel.setBackground(Color.pink);
	}

	public void setInitLayout() {
		add(panel, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		button1.setHorizontalAlignment(SwingConstants.LEADING);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton selectedButton = (JButton) e.getSource();
		
		if (selectedButton == this.button1) {
			panel.setBackground(Color.yellow);
		} else if (selectedButton == this.button2) {
			panel.setBackground(Color.green);
		} else if (selectedButton == this.button3) {
			panel.setBackground(Color.pink);
		}

	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);

	}

	public static void main(String[] args) {
		new ColorChangeFrame3();
	}

}
