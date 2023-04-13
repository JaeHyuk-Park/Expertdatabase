package database;

import java.util.ArrayList;
import java.util.Scanner;

//필드(번호,아이디,점수2개)
//성적입력, 성적출력(전체출력), 개별출력, 정보삭제(delete), 종료를 구현할 기능창
class DataWorkSpace {
	Scanner in = null;
	private int input;
	DataWorkSpace() {
		in = new Scanner(System.in);
		FullOutput out = new FullOutput();
		Input ice = new Input();
		
		while(true) {
			System.out.println("1.성적입력 2.성적 전체출력 3.성적 개별출력 4.정보삭제 5.종료");
			input = in.nextInt();
			if(input == 1){
				Overlap nite = ice.intern(); // Input클래스의 intern 메소드에 Overlap 변수 값 저장 
				out.input(nite); // FullOutput 클래스의 input 메소드에 Overlap변수 객체값 넘겨줌.
			}else if(input == 2){
				ArrayList<Overlap> item = out.full();
				ice.print(item);
			}else if(input == 3){
				out.individual();
			}else if(input == 4){
				out.delete();
			}else if(input == 5){
				System.out.println("시스템이 종료되었습니다."); break;
			}else{
				System.out.println("다시 선택해주세요.");
			}
		}	
	}
}
