package com.yedam.chap02;

public class variable01 {

	public static void main(String[] args) {
		//변수 선언
		int value = 0; //변수 선언 안댓음 값을 모름
		
		int result = value + 10; //초기값 없어서 더할 수가 없음
		
		System.out.println(result);
		
		
		//변수 사용..
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분");
		
		int totalMinute = (hour*60) + minute;
		System.out.println("총"+totalMinute + "분");
				
		
		//변수 복사
		int x = 3;
		int y;
		
		System.out.println("바꾸기 전 : "+ x );
		
		//y에다 3을 넣어준 것이나 마찬가지...
		y = x;
		
		System.out.println("바꾼 후 : " + x + y);
		
		//swap 
		//x와 y의 값을 바꾼다..
		//x = y -> x의 값과 y의 값이 같아진다
		//대신 담아줄 수 있는 변수 => z
		x = 3;
		y = 5;
		int z = 0;
		
		//1) x -> z (z = 3)
		//2) y -> x (x = 3 ->5)
		//3) y -> z (y = 5 ->3)
		
		z= x;//1) x -> z (z = 3)
		x= y;//2) y -> x (x = 3 ->5)
		y= z;//3) y -> z (y = 5 ->3)
		//swap
		
		
		//변수의 사용 범위
		int v1 = 15;
		if(v1 > 10) {
			int v2;
			v2 = v1 -10;
		}
//		int v3 = v1+v2+5;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
