package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing -> 배치 관리자 : FlowLayout
// 컴포넌트들을 (버튼 , 라벨) 등을 수평, 수직으로 배치를 해주는 클래스
public class FlowLayoutEx extends JFrame {

	// 배열 활용 - 하나의 변수로 여러개 통으로 관리하고 싶다면 배열을 써보자.
	private JButton[] button = new JButton[10];
	
	// 생성자
	public FlowLayoutEx() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출 가능하다.
		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화 하는 기능(값 넣다)
	public void initData() {
		// 반복문 활용
		int a = 1;
		for (int i = 0; i < button.length; i++) {
			if(button[i] == null) {
				button[i] = new JButton("button"+ a);
			} a++;
		}
	}
	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		// 배치 관리자 --> borderLayout 이라는 배치괸라자가 기본으로 활용 된다.
		// FlowLayout flowLayout = new FlowLayout();
		// super.setLayout(FlowLayout()); // 배치관리자 --> FlowLayout이 장착됨 밑에 꺼랑 같은데 줄여서 코드를
		// 씀

		// 배치관리자 생성 및 JFrame 셋팅
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50));

		// (버튼)컴포넌트들을 붙이다.
		// 반복문 활용
		for (int i = 0; i < button.length; i++) {
			if (button[i] != null) {
				super.add(button[i]);
			}
		}
	}

	// 코드 테스트
	public static void main(String[] args) {
		// FlowLayoutEx f1 = new FlowLayoutEx(); // <---- 부를 수 있는 이름이 있는 상태
		new FlowLayoutEx(); // <----- 주소값이 없음 익명 클래스
		// 다시 접근해서 사용할 일 없으면 선언만 해도됨
	} // end of main
}
