package database;

import java.util.ArrayList;
import java.util.Scanner;

class Input{
	Scanner iot = null;
	
	Overlap intern(){
	//리턴타입은 값을 가지고 있는 클래스명임.
	//리턴은 클래스 객체명을 쓰면 됨.
		iot = new Scanner(System.in);
		System.out.println("성적입력을 선택하였습니다.");
		System.out.println("학번을 입력하세요."); String st1 = iot.next();
		System.out.println("아이디를 입력하세요."); String st2 = iot.next();
		System.out.println("첫번째 점수를 입력하세요."); int score1 = iot.nextInt();
		System.out.println("두번째 점수를 입력하세요."); int score2 = iot.nextInt();
		
		Overlap over = new Overlap();
		over.st1 = st1;
		over.st2 = st2;
		over.score1 = score1;
		over.score2 = score2;
		
		return over;
	}
	void print(ArrayList<Overlap> item) {
		for(int i = 0 ; i <= item.size()-1; i++){
			System.out.println("학번 : " +item.get(i).st1 +" / 아이디 : " + item.get(i).st2 +" / 첫번째 점수 : " +item.get(i).score1 + " / 두번째 점수 : "+item.get(i).score2);
		}
	}
}
