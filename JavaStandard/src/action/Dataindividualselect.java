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
		System.out.println("Ȯ���Ͻ� �������� �й��� �Է����ּ���.");
		data.hakbun = enter.next();
		CommonDataType field = db.dataindividualselect(data);
		
		System.out.println("�й� : "+field.getHakbun() +", ���̵� : " +field.getIdentify() + ", ���� 1 : "+field.getScore1() + ", ���� 2 : "+field.getScore2());
	}
}
