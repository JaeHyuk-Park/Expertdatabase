package action;

import java.util.Scanner;

import dao.Databases;
import dto.CommonDataType;

// DBó�� ��ü
public class DataInsert implements CommonInter {
	Scanner iot = new Scanner(System.in);
	CommonDataType data = new CommonDataType();
	
	@Override
	public void over() {
		System.out.println("�����Է��� �����Ͽ����ϴ�.");
		System.out.println("�й��� �Է��ϼ���."); data.hakbun = iot.next();
		System.out.println("���̵� �Է��ϼ���."); data.identify = iot.next();
		System.out.println("ù��° ������ �Է��ϼ���."); data.score1 = iot.nextInt();
		System.out.println("�ι�° ������ �Է��ϼ���."); data.score2 = iot.nextInt();
		
		Databases db = Databases.getInstance();
		
		data.setHakbun(data.hakbun);
		data.setIdentify(data.identify);
		data.setScore1(data.score1);
		data.setScore2(data.score2);
		
		db.datainsert(data);
	}
}