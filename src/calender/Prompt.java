package calender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Prompt {
	
	public final String PROMPT = "> ";
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
	}

	public void runPrompt() throws IOException {
		Scanner input = new Scanner(System.in);
		Calendar cal = new Calendar();
		HashMap <String, ArrayList<String>> map = new HashMap<>();
		
		String num = "";
			
		while(true) { 
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print(PROMPT);
			num = input.next();
			input.nextLine();
			if(num.equals("q")) break;
			else if(num.equals("1")) cmdRegister(input, map);
			else if(num.equals("2")) cmdSearch(input, map);
			else if(num.equals("3")) cmdCal(input, cal);
			else if(num.equals("h")) printMenu();  
			else continue;
			System.out.println();
		}
		System.out.println("Bye");
		input.close();
	}
	
	public void cmdRegister(Scanner input, HashMap <String, ArrayList<String>> map) {
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		System.out.print(PROMPT);
		String date = input.nextLine();
		ArrayList<String> list = new ArrayList<>();
		System.out.println("일정을 입력하세요.");
		System.out.print(PROMPT);
		
		String to_do = input.nextLine();
		
		if(map.containsKey(date)) {
			list = map.get(date);
			list.add(to_do);
		}
		else {
			list.add(to_do);
		}
		
		System.out.println("일정이 등록되었습니다.");
		map.put(date, list);
	}
	
	public void cmdSearch(Scanner input, HashMap <String, ArrayList<String>> map) {
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		System.out.print(PROMPT);
		String date = input.nextLine();
	
		ArrayList<String> list = map.get(date);
		System.out.println(list.size() + "개의 일정이 있습니다.");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + ". " + list.get(i));
		}
	}
	
	public void cmdCal(Scanner input, Calendar cal) {
		int year = 0;
		int month = 0;
		
		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR" + PROMPT);
		year = input.nextInt();
		
		System.out.println("월을 입력하세요");
		System.out.print("MONTH" + PROMPT);
		month = input.nextInt();
		
		if(month > 12 || month < 0) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		cal.printCalendar(year, month);
		System.out.println(); System.out.println();
	}
	
	
	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
