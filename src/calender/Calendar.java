package calender;

import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int maxDaysOfMonth(int month) {
		return MAX_DAYS[month-1];
	}

	public void printCalendar() {
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

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Calendar cal = new Calendar();
		String PROMPT = "> ";

		while(true) {
			System.out.println("월을 입력하세요");
			System.out.print(PROMPT);
			int n = input.nextInt();
			if(n == -1) {
				System.out.println("Have a nice day!");
				break;
			}
			if(n > 12)
				continue;
			System.out.println(n + "월은 " + cal.maxDaysOfMonth(n) + "일까지 있습니다.");
		}

	}

}
