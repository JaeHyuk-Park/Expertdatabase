package dao;

import java.io.Reader;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.DatabaseObject;

public class Databases {
	DatabaseObject ob = new DatabaseObject();
	Reader read = null;
	SqlSessionFactory factory = null;
	static Databases db;
	public Databases(){
		try{
			read = Resources.getResourceAsReader("process.xml");
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
	
	//ȸ������ insert �޼ҵ�
	public void joinDatabase(DatabaseObject go) {
		getInstance();
		SqlSession fact = factory.openSession();
		fact.insert("insertinfo", go);
		fact.commit();
		fact.close();
	}
	ResultSet rs;
	////////////////////////////////////////////////////////////////////	select �޼���
	public List<DatabaseObject> checkDatabase() {
		getInstance();
		SqlSession fact = factory.openSession();
		List<DatabaseObject> list = fact.selectList("infofullselect");
		fact.close();	
		
		return list;
				
	}
	// ȸ�� ���� score insert�޼ҵ�
	public void databasescore(DatabaseObject object) {
		getInstance();
		SqlSession fact = factory.openSession();
		fact.insert("insertscore", object);
		fact.commit();
		fact.close();
	}

	public List<DatabaseObject> totaloutput () {
		// DB���� ��� ���� ������ ���� �о���� �޼���
		getInstance();
		SqlSession fact = factory.openSession();
		List<DatabaseObject> item = fact.selectList("fullselect");
		fact.close();	
		
		return item;
	} // total output
	
	// �������
	public DatabaseObject Clientinfoselect(DatabaseObject item){
		getInstance();
		SqlSession fact = factory.openSession();
		DatabaseObject ob = fact.selectOne("selectivinfo", item);
		fact.close();
		return ob;
	}
	// �������(�ٽ� Ȯ���غ�����.)
	public DatabaseObject Clientscoreselect(DatabaseObject data) {
		getInstance();
		SqlSession fact = factory.openSession();
		DatabaseObject ob = fact.selectOne("selectivscore", data);
		fact.close();
		return ob;
	}

	public void deleteInfo(DatabaseObject del) {
		getInstance();
		SqlSession fact = factory.openSession();
		fact.insert("ivdelete", del);
		fact.commit();
		fact.close();
	}
}