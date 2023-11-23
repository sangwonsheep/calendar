package calender;

import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int maxDaysOfMonth(int month) {
		return MAX_DAYS[month-1];
	}

	public void printCalendar(int month) {
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		for(int i = 1; i <= MAX_DAYS[month-1]; i++) {
			System.out.printf("%3d", i);
			if(i % 7 == 0)
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
				System.out.println("Bye~");
				break;
			}
			if(n > 12)
				continue;
			cal.printCalendar(n);
			System.out.println();
		}

	}

}
