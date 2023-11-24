package calender;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("두 수를 입력하세요.");
		int a = input.nextInt();
		int b = input.nextInt();
		System.out.println("두 수의 합은 " + (a+b) + "입니다.");
		
		input.close();
	}

}
