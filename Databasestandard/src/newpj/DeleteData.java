package newpj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteData {
	DeleteData(){
		Connection connect = null;
		Statement save = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/youngwave", "root", "1324");
			// �ϳ��� Ŀ��Ʈ�� �۾��� �ϳ��� �ؾ��Ѵ�.
			save = connect.createStatement();
			System.out.println("-----------DeleteData Ŭ���� ����-----------");

			String data = "delete from wave where age = 25"; 
			save.executeUpdate(data);
			// ������ �����͸� ���� ���°�.
		}catch(Exception e) {
			System.out.println(e+"�����Դϴ�.");
		}finally {
			try {
				connect.close();
			}catch(Exception e){
			}
		}
	}
	public static void main(String[] args) {
		new DeleteData();
		new Databases();
		new Databases1();
		// ��ü��� Ŭ���� �ҷ���.
	}
}
