package calender;

import java.util.Scanner;

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
		
		Scanner input = new Scanner(System.in);
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.println("달을 입력하세요");
		int n = input.nextInt();
		System.out.println(n + "월은 " + month[n-1] + "일까지 있습니다.");
		
		input.close();
	}

}
