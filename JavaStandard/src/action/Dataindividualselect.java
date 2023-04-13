package action;

import java.util.Scanner;

import dao.Databases;
import dto.CommonDataType;

public class Dataindividualselect implements CommonInter{
	CommonDataType data = new CommonDataType();
	Scanner enter = new Scanner(System.in);
	@Override
	public void over() {
		Databases db = Databases.getInstance();
		System.out.println("확인하실 데이터의 학번을 입력해주세요.");
		data.hakbun = enter.next();
		CommonDataType field = db.dataindividualselect(data);
		
		System.out.println("학번 : "+field.getHakbun() +", 아이디 : " +field.getIdentify() + ", 점수 1 : "+field.getScore1() + ", 점수 2 : "+field.getScore2());
	}
}
