package CrazyArcade;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	MainFrame mContext = this;
	private JLabel backgroundMap;
	private Player1 player1;
	private Bush bush;
	private Player1KeyListener player1KeyListener;
	private int[][] Map;
	private JButton[] button;
	Color MapColor;

	private BufferedImage mapImage;
	private String mapAdress = "IMG/background_test4_1010.png";

	private final int PIXEL_COLOR_WHITE = 0;
	private final int PIXEL_COLOR_RED = 1;
	private final int PIXEL_COLOR_BLUE = 2;

	public MainFrame() {
		// TODO Auto-generated constructor stub
		initDat();
		setInitLayout();
		addEventListener();

		// 백그라운드 서비스 시작

		// new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initDat() {
		setSize(1017, 1040);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("IMG/main_background.png");
		// backgroundMap = new JLabel(new ImageIcon("IMG/main_background.png"));
		mapArrayAdd();
		// setContentPane(backgroundMap);
		backgroundMap = new JLabel(icon);
		JPanel jpanel = new JPanel();
		jpanel.add(backgroundMap);
		player1 = new Player1(mContext);

		bush = new Bush(mContext);
		backgroundMap.setSize(1000, 1000);
		backgroundMap.setLocation(0, 0);
	}

	private void setInitLayout() {
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(bush);
		backgroundMap.add(player1);
		// setResizable(false);
		setLocationRelativeTo(null);// jframe 모니터 가운데 자동 배치
		setVisible(true);

	}

	private void addEventListener() {
		new Thread(new Player1KeyListener(mContext, player1)).start();

	}

	private void mapArrayAdd() {
		try {
			mapImage = ImageIO.read(new File(mapAdress));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				// int x = 50 + 100 * j;
				// int y = 50 + 100 * i;

				Map[i][j] = getColor(50 + 100 * j, 50 + 100 * i);
				if (Map[i][j] == 1) {
					add(new Box(mContext, i, j));
				}
				System.out.print("[" + Map[i][j] + "]");
			}
			System.out.println();
		}

	}

	public int getColor(int x, int y) {
		MapColor = new Color(mapImage.getRGB(x, y));
		// MapColor = new Color(backgroundMap.getColorModel());
		if (MapColor.getRed() == 255 && MapColor.getGreen() == 0 && MapColor.getBlue() == 0) {

			return PIXEL_COLOR_RED;// 빨강
		} else if (MapColor.getRed() == 0 && MapColor.getGreen() == 0 && MapColor.getBlue() == 255) {
			return PIXEL_COLOR_BLUE;// 파랑
		} else {
			return PIXEL_COLOR_WHITE;// 흰색
		}
	}

	public Player1 getPlayer1() {
		return player1;
	}

	public Bush getBush() {
		return bush;
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}