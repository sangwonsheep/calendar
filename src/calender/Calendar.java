package calender;

import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		return false;
	}
	
	public int maxDaysOfMonth(int year, int month) {
		if(isLeapYear(year))
			return LEAP_MAX_DAYS[month-1];
		else
			return MAX_DAYS[month-1];
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		
		int n;
		
		if(isLeapYear(year))
			n = LEAP_MAX_DAYS[month-1];
		else
			n = MAX_DAYS[month-1];
			
		for(int i = 1; i <= n; i++) {
			System.out.printf("%3d", i);
			if(i % 7 == 0)
				System.out.println();
		}
	}
	
	public void runPrompt() {
		Scanner input = new Scanner(System.in);
		Calendar cal = new Calendar();
		String PROMPT = "> ";
		
		int year = 0;

		while(true) {
			System.out.println("연을 입력하세요");
			System.out.print(PROMPT);
			year = input.nextInt();
			System.out.println("월을 입력하세요");
			System.out.print(PROMPT);
			int month = input.nextInt();
			if(month == -1) {
				System.out.println("Bye~");
				break;
			}
			if(month > 12)
				continue;
			cal.printCalendar(year, month);
			System.out.println();
		}
		
		input.close();
	}

	public static void main(String[] args) {
		Calendar cal = new Calendar();
		cal.runPrompt();
	}

}
