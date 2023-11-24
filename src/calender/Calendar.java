package calender;

public class Calendar {

	private final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		return false;
	}
	
	public int maxDaysOfMonth(int year, int month) {
		if(isLeapYear(year))
			return LEAP_MAX_DAYS[month];
		else
			return MAX_DAYS[month];
	}
	
	/**
	 *	실제 달력을 출력하기 위해 계산하는 부분
	 *	1년 1월 1일 월요일을 기준으로 하였다.
	 */
	public int checkCalendar(int year, int month) {
		int y = year - 1; // 예를 들어 2023년이면 1년~2022년까지 구하기 위함
		int plusDay = 1; // 1년 1월 1일 월요일 기준으로 설정
		int dayOfLeapYear = (y/4) + (y/400) - (y/100); // 윤년 개수 구하기 
		
		int leap = y + dayOfLeapYear + plusDay; 
		leap += sumMonth(year, month); 
		return leap % 7;
	}
	
	/**
	 * 그레고리력으로 인정된 날부터 실제 달력 출력
	 * 1583년 1월 1일 토요일 기준
	 */
	public int gregorian(int year, int month) {
		int y = 1583; // 1583년
		int plusDay = 6; // 토요일
		
		int count = 0;
		for(int i = y; i < year; i++) {
			int check = isLeapYear(i) ? 366: 365;
			count += check;
		}
		
		count += sumMonth(year, month);
		
		int weekday = (count + plusDay) % 7;
		return weekday;
	}

	/**
	 * 실제 달력의 월을 구하기 위한 함수 
	 */
	public int sumMonth(int year, int month) {
		int sum = 0;
		if(isLeapYear(year)) {
			for(int i = 1; i < month; i++) {
				sum += LEAP_MAX_DAYS[i];
			}
		}
		else {
			for(int i = 1; i < month; i++) {
				sum += MAX_DAYS[i];
			}
		}
		return sum;
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		
		int n;
		int check = gregorian(year, month); 
		
		if(isLeapYear(year))
			n = LEAP_MAX_DAYS[month];
		else
			n = MAX_DAYS[month];
		
		for(int i = 0; i < check; i++) {
			System.out.print("   ");
		}
			
		for(int i = 1; i <= n; i++) {
			System.out.printf("%3d", i);
			if((i+check) % 7 == 0)
				System.out.println();
		}
	}

	public static void main(String[] args) {
		
	}

}
