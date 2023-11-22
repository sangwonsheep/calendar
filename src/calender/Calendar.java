package calender;

public class Calendar {

	public static void main(String[] args) {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("----------------");
		int count = 1;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 7; j++) {
				if(count < 10)
					System.out.print(" ");
				System.out.print(count + " ");
				count++;
			}
			System.out.println();
		}
	}

}
