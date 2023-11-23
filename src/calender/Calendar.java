package calender;

import java.util.Scanner;

public class Calendar {

	private final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final String[] WEEK_DAYS = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};

	public int parseDay(String weekday) {
		for(int i = 0; i < WEEK_DAYS.length; i++) {
			if(WEEK_DAYS[i].equals(weekday)) {
				return i;
			}
		}
		return -1;
	}
	
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

	public void printCalendar(int year, int month, String weekday) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		
		int n;
		int check = parseDay(weekday);	
		
		if(isLeapYear(year))
			n = LEAP_MAX_DAYS[month-1];
		else
			n = MAX_DAYS[month-1];
		
		for(int i = 0; i < check; i++) {
			System.out.print("   ");
		}
			
		for(int i = 1; i <= n; i++) {
			System.out.printf("%3d", i);
			if((i+check) % 7 == 0)
				System.out.println();
		}
	}
	
	public void runPrompt() {
		Scanner input = new Scanner(System.in);
		Calendar cal = new Calendar();
		String PROMPT = "> ";
		
		int year = 0;
		int month = 0;
		String weekday = "";

		while(true) {
			System.out.println("년도을 입력하세요. (EXIT : -1)");
			System.out.print("YEAR" + PROMPT);
			year = input.nextInt();
			if(year == -1) {
				System.out.println("Bye~");
				break;
			}
			
			System.out.println("월을 입력하세요");
			System.out.print("MONTH" + PROMPT);
			month = input.nextInt();
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
			System.out.print("WEEKDAY" + PROMPT);
			weekday = input.next();
			
			if(month == -1) {
				System.out.println("Bye~");
				break;
			}
			if(month > 12 || month < 0)
				continue;
			cal.printCalendar(year, month, weekday);
			System.out.println();
		}
		
		input.close();
	}

	public static void main(String[] args) {
		Calendar cal = new Calendar();
		cal.runPrompt();
	}

}
