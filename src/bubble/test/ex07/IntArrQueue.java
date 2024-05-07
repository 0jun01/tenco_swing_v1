package bubble.test.ex07;

public class IntArrQueue {

	private int[] array;
	private int front; // 큐의 시작 지점
	private int rear; // 큐의 끝 지점
	private int capacity; // 큐의 용량
	private int size; // 요소의 개수

	public IntArrQueue(int capacity) {
		this.capacity = capacity;
		array = new int[this.capacity];
		this.front = 0;
		this.rear = -1;
		this.size = 0;
	}

	// 편의 기능 만들어 보기
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	// TODO - 1 데이터 넣기 기능 구현
	public void enqueue(int item) {
		// 방어적 코드
		if (isFull()) {
			System.out.println("큐 메모리 공간이 가득 찼습니다.");
		} else {
			// rear
			rear++;
			// 0 <-- (첫 동작시)
			array[rear] = item; // array[0] = item
			size++;
		}

	}

	// TODO - 2 데이터 꺼내기
	public int dequeue() {
		int item = -99999;
		if (isEmpty()) {
			System.out.println("큐 메모리 공간에 요소가 없음.");
		} else {

			// 잠시 데이터 꺼내 보기
			item = array[front]; // 0번째 요소에 접근
			// 100, 200, 300
			// f - 0 (첫 꺼낼 시)
			for (int i = front; i < rear; i++) { // 0 < 2
				// array[0] = array[1]
				// 200, 200 , 300 -- for : 1번 동작
				// 200, 300, 300 -- for : 2번 동작
				array[i] = array[i + 1];
			}
			// 200, 300 , 0
			// 마지막 요소를 초기화 처리 한다.
			array[rear] = 0;
			// 상태값 처리 확실하게 처리!
			rear--;
			size--;
		}

		return item;
	}

	// TODO - 3 데이터 찾기 (Peek)

	public int peek() {
		if (isEmpty()) {
			System.out.println("큐 메모리 공간의 요소가 없습니다.");
			return -99999;
		} else {
			// peek --> 맨 앞에 데이터를 리턴 시켜주는 기능일 뿐
			return array[front]; // - 수정
		}
	}

	public static void main(String[] args) {

		IntArrQueue queue = new IntArrQueue(3);
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		queue.enqueue(300); // 안들어감
		System.out.println(queue.peek());
		// 데이터 꺼내고 삭제 처리

		// queue.dequeue(); // 맨 처음 들어온 녀석부터 꺼내지고 삭제 처리 된다.
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	} // end of main

} // end of class
