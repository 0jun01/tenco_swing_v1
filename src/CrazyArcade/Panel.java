package CrazyArcade;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JFrame {

	private JPanel panel;
	private int count;
	Color color;
	BufferedImage imagetest;

	public Panel() {
		initData();
		setInitLayout();
		paintComponents(getGraphics());
	}

	public int[] demonThread(MouseEvent e) {
		int[] result = new int[2];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j * 100 < e.getX() && e.getX() < 100 * (j + 1) && i * 100 < e.getY() && e.getY() < 100 * (i + 1)) {
					result[0] = i;
					result[1] = j;
					return result;

				}

			}
		}
		return null;
	}

	public void initData() {
		panel = new JPanel();

		setSize(1017, 1039);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		panel.setSize(1000, 1000);
		panel.setLocation(0, 0);
		

		setLayout(null);
		setVisible(true);

	}

	public BufferedImage creatImage(JPanel jpanel) {

		int w = jpanel.getWidth();
		int h = jpanel.getHeight();
		System.out.println(jpanel.getWidth()+ "ccc");
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		panel.paint(g);
		g.dispose();
		return bi;
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		panel.setBackground(Color.BLUE);
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// imagetest = creatImage(panel);

				System.out.println("x : " + e.getX() + " y :" + e.getY());
				int[] result = demonThread(e);
				int i = result[0];
				int j = result[1];
				// color = new Color(imagetest.getRGB(e.getX(), e.getY()));
				color = new Color(creatImage(panel).getRGB(e.getX(), e.getY()));
//				if (white == 1) {
//					g.setColor(Color.RED);
//					g.fillRect(j * 100, i * 100, 100, 100);
//					white--;
//					red++;
//					System.out.println(e);
//				} else if (red == 1) {
//					g.setColor(Color.BLUE);
//					g.fillRect(j * 100, i * 100, 100, 100);
//					red--;
//					blue++;
//				} else if (blue == 1) {
//					g.setColor(Color.WHITE);
//					g.fillRect(j * 100, i * 100, 100, 100);
//					blue--;
//					white++;
//				}
				System.out.println("aaa " + color.getRed());
				if (color.getRed() == 255 && color.getBlue() == 255 && color.getGreen() == 255) {
					g.setColor(Color.red);
					System.out.println(g);
					g.fillRect(j * 100, i * 100, 100, 100);
					System.out.println("color" + g.getColor());

				}

				if (color.getRed() == 255 && color.getBlue() == 0 && color.getGreen() == 0) {
					System.out.println("Afsd");
					g.setColor(Color.blue);
					g.fillRect(j * 100, i * 100, 100, 100);

				}
				// 조건식 잘못 된건 아니야??
				if (color.getRed() == 0 && color.getBlue() == 255 && color.getGreen() == 0) {
					System.out.println("11111111111");
					g.setColor(Color.WHITE);
					g.fillRect(j * 100, i * 100, 100, 100);
				}
				// repaint();
			}
		});
	}

	public void setInitLayout() {
		// panel.setBackground(creatImage(panel));
		// imagetest = creatImage(panel);

		// panel.add(panel)
	}

	public static void main(String[] args) {
		new Panel();
//		if (g.d) {
//			g.setColor(color.RED);
//			g.fillRect(j * 100, i * 100, 100, 100);
//			white = 1;
//		} else if (red != 1) {
//			g.setColor(color.BLUE);
//			g.fillRect(j * 100, i * 100, 100, 100);
//			red = 1;
//		} else if (blue != 1) {
//			g.setColor(color.WHITE);
//			g.fillRect(j * 100, i * 100, 100, 100);
//			blue = 1;
//		}
	}

}
