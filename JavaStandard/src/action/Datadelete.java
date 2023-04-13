package action;

import dao.Databases;

public class Datadelete implements CommonInter {
	
	public void over(){	
		System.out.println("성적 전체삭제를 선택하였습니다.");
		Databases db = Databases.getInstance();
		db.datadelete();
	}
}
