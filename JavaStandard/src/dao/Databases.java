package dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.CommonDataType;

public class Databases {
	Reader read = null;
	SqlSessionFactory factory = null;
	static Databases db;
	Databases(){
		try{
			read = Resources.getResourceAsReader("process.xml");
			// 다른 파일이기 때문에 예외처리를 해줘야함.
			// 그리고 xml파일은 src 안에 들어와야함.
			factory = new SqlSessionFactoryBuilder().build(read);
		}catch(Exception e) {
			System.out.println(e+"오류입니다.");
		}	
	}
	public static Databases getInstance() {
		if(db == null) {
			synchronized(Databases.class) { // 싱글톤패턴 >> 객체 재사용
				db = new Databases();
			}
		}
		return db;
	}
	
	public void datainsert(CommonDataType data) {	
		SqlSession fact = factory.openSession();
		fact.insert("insert", data);
		fact.commit();
		fact.close();
	}
	
	public List<CommonDataType> datafullselect() {
		SqlSession fact = factory.openSession();
		List<CommonDataType> list = fact.selectList("full");
		// List를 쓰면 Table 한 줄마다 add가 되는것, 뽑을때는 get(i)로 뽑으면 됨.
		// selectList는 전체출력, selectOne은 한개만 출력
		// Select할 때, resultType을 받아주는 값은 List<>로 받아야함.
		fact.close();
		return list;
	}
	
	public CommonDataType dataindividualselect(CommonDataType data) {
		SqlSession fact = factory.openSession();
		CommonDataType field = fact.selectOne("individual", data);
		fact.close();
		return field;
	}
	public void datadelete() {
		SqlSession fact = factory.openSession();
		fact.delete("de");
		fact.commit();
		fact.close();
	}
	public void dataivdelete(CommonDataType data) {
		SqlSession fact = factory.openSession();
		fact.delete("delete", data);
		fact.commit();
		fact.close();
	}
}