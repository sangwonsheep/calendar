package calender;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner input = new Scanner(System.in);
		Calendar cal = new Calendar();
		String PROMPT = "> ";
		
		int year = 0;
		int month = 0;

		while(true) {
			System.out.println("년도를 입력하세요. (EXIT : -1)");
			System.out.print("YEAR" + PROMPT);
			year = input.nextInt();
			if(year == -1) {
				System.out.println("Bye~");
				break;
			}
			
			System.out.println("월을 입력하세요");
			System.out.print("MONTH" + PROMPT);
			month = input.nextInt();
			
			if(month == -1) {
				System.out.println("Bye~");
				break;
			}
			if(month > 12 || month < 0)
				continue;
			cal.printCalendar(year, month);
			System.out.println(); System.out.println();
		}
		
		input.close();
	}
	
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
