package ch07;

import java.util.Arrays;
import java.util.Random;

// 클래스를 설계할때는 단일 책임 원칙을 설정하는 것이 좋다.
// 
public class LottoRandomNumber {

	final int LOTTO_NUMBER_COUNT = 6;

	// 6개의 랜덤 번호를 생성하는 메서드 필요하다.
	public int[] createNumber() {

		int[] lottoWinNum = new int[LOTTO_NUMBER_COUNT];
		Random random = new Random();
		// 10
		// 10 20
		// 10 20 10
		for (int i = 0; i < lottoWinNum.length; i++) {
			lottoWinNum[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {

				if (lottoWinNum[j] == lottoWinNum[i]) {
					// 값이 중복된 상태이다.
					i--;
				}
			}
		}
		// 중복 제거 완ㅇ료

		Arrays.sort(lottoWinNum); // 오름차순으로 자동 정렬

		return lottoWinNum;
	}

	// 코드 테스트
	public static void main(String[] args) {
		LottoRandomNumber randomNumber = new LottoRandomNumber();

		int[] resultArray = randomNumber.createNumber();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);

		}

	}

}
