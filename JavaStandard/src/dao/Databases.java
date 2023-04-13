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
			// �ٸ� �����̱� ������ ����ó���� �������.
			// �׸��� xml������ src �ȿ� ���;���.
			factory = new SqlSessionFactoryBuilder().build(read);
		}catch(Exception e) {
			System.out.println(e+"�����Դϴ�.");
		}	
	}
	public static Databases getInstance() {
		if(db == null) {
			synchronized(Databases.class) { // �̱������� >> ��ü ����
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
		// List�� ���� Table �� �ٸ��� add�� �Ǵ°�, �������� get(i)�� ������ ��.
		// selectList�� ��ü���, selectOne�� �Ѱ��� ���
		// Select�� ��, resultType�� �޾��ִ� ���� List<>�� �޾ƾ���.
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