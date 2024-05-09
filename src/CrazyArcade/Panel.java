package CrazyArcade;

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
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		panel.paint(g);
		g.dispose();
		return bi;
	}

	public void setInitLayout() {
		panel.setBackground(Color.WHITE);
		imagetest = creatImage(panel);

		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//imagetest = creatImage(panel);
				Graphics g = panel.getGraphics();
				
				System.out.println("x : " + e.getX() + " y :" + e.getY());
				int[] result = demonThread(e);
				int i = result[0];
				int j = result[1];
				//color = new Color(imagetest.getRGB(e.getX(), e.getY()));
				color = new Color(creatImage(panel).getRGB(e.getX(), e.getY()));
				
				System.out.println(color);
				if (color.getRed() == 255 && color.getBlue() == 255 && color.getGreen() == 255) {
					System.out.println("SDAF");
					g.setColor(Color.red);
					g.fillRect(j * 100, i * 100, 100, 100);
					
				}
				if (color.getRed() == 255 && color.getBlue() == 0 && color.getGreen() == 0) {
					System.out.println("Afsd");
					g.setColor(Color.blue);
					g.fillRect(j * 100, i * 100, 100, 100);
					
				} 
				if (color.getRed() == 0 && color.getBlue() == 255 && color.getGreen() == 0){
					g.setColor(Color.WHITE);
					g.fillRect(j * 100, i * 100, 100, 100);
					

				}
				
			}
		});
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
