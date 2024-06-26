package ch03;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 중첩 클래스 --> 외부,내부 클래스로 내부 클래스로 --> 인스턴스 클래스 , static 클래스
 */
public class MyImageFrame extends JFrame {

	// 내부 클래스로 정의한 데이터 타입 이다.
	private MyImagePanel myImagePanel;

	public MyImageFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("이미지 활용 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            myImagePanel = new MyImagePanel();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
	}

	private void setInitLayout() {
		add(myImagePanel);
		setVisible(true);
	}

	// 내부 클래스 --> static 키워드 활용
	// 정적(static) 내부 클래스라고 한다.
	static class MyImagePanel extends JPanel {
		private Image image1;
		private Image image2;
		private Image image3;
		private Image image4;

		
		
		public MyImagePanel() throws MalformedURLException{
			// ImageIcon 데이터 타입 -> getImage() 메서드를 호출하면
			// image 데이터 타입을 만들어 낼 수 있다.
			image1 = new ImageIcon("image1.png").getImage();
			image2 = new ImageIcon("image2.png").getImage();
			image4 = new ImageIcon("image4.png").getImage();
			image3 = Toolkit.getDefaultToolkit().createImage("image3.gif"); 
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image3, 0, 0, 600, 600, this);
			g.drawImage(image1, 100, 100, 100, 100, null);
			g.drawImage(image2, 200, 200, 100, 100, null);
			g.drawImage(image4, 500, 100, 100, 100, null);
		}
	}

}
