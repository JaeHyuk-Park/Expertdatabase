package action;

import dao.Databases;

public class Datadelete implements CommonInter {
	
	public void over(){	
		System.out.println("���� ��ü������ �����Ͽ����ϴ�.");
		Databases db = Databases.getInstance();
		db.datadelete();
	}
}
