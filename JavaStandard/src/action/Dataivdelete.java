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
		
		System.out.println("�����Ͻ� �������� �й��� �Է��ϼ���."); 
		data.hakbun = enter.next();
		data.setHakbun(data.hakbun);
		
		db.dataivdelete(data);
	}

}
