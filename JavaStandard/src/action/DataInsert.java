package action;

import java.util.Scanner;

import dao.Databases;
import dto.CommonDataType;

// DB처리 객체
public class DataInsert implements CommonInter {
	Scanner iot = new Scanner(System.in);
	CommonDataType data = new CommonDataType();
	
	@Override
	public void over() {
		System.out.println("성적입력을 선택하였습니다.");
		System.out.println("학번을 입력하세요."); data.hakbun = iot.next();
		System.out.println("아이디를 입력하세요."); data.identify = iot.next();
		System.out.println("첫번째 점수를 입력하세요."); data.score1 = iot.nextInt();
		System.out.println("두번째 점수를 입력하세요."); data.score2 = iot.nextInt();
		
		Databases db = Databases.getInstance();
		
		data.setHakbun(data.hakbun);
		data.setIdentify(data.identify);
		data.setScore1(data.score1);
		data.setScore2(data.score2);
		
		db.datainsert(data);
	}
}