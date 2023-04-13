package action;

import java.util.List;

import dao.Databases;
import dto.CommonDataType;

// DB처리 객체
public class Datafullselect implements CommonInter {
	List<CommonDataType> list;
	
	@Override
	public void over() {
		System.out.println("성적 전체출력을 선택하였습니다.");
		Databases db = Databases.getInstance(); // Databases xml = new Databases(); xml.datafullselect();이랑 같은 것이다. 
		list = db.datafullselect();
		
		for(int i=0; i<=list.size()-1; i++) {
			System.out.println("학번 : "+ list.get(i).getHakbun() + ", 아이디 : "+ list.get(i).getIdentify() +", 점수 1 : "+ list.get(i).getScore1() +", 점수 2 : "+ list.get(i).getScore2());
			//이제 출력할때 메소드를 불러오기로 함. get~()
			//select로 출력할 때 변수타입 객체명과 이름이 다르면 null값으로 출력됨.
		}
	}
}
