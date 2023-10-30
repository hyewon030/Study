package test;

import java.util.UUID;

public class UUIDTest {
	public static void main(String[] args) {
		
		//UUID, Universal Unique IDentifier
		//	범용 고유 식별자
		
		//	32자리의 16진수형태의 문자열을 생성한다
		
		//	8-4-4-4-12 개씩 구분해서 생성해준다
		//---------------------------------------------
		
		//랜덤 UUID값 생성
		UUID uuid = UUID.randomUUID();
		
		System.out.println( uuid.toString() );
		
		System.out.println( uuid.toString().split("-")[4] );
		
	}
}












