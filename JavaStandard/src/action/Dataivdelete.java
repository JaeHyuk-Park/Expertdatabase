package action;

import java.util.Scanner;

import dao.Databases;
import dto.CommonDataType;

public class Dataivdelete implements CommonInter {
	CommonDataType data;
	Scanner enter = new Scanner(System.in);
	@Override
	public void over() {
		Databases db = Databases.getInstance();
		
		System.out.println("삭제하실 데이터의 학번을 입력하세요."); 
		data.hakbun = enter.next();
		data.setHakbun(data.hakbun);
		
		db.dataivdelete(data);
	}

}
