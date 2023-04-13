package newpj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Databases {
	Databases()	{
		Connection ioner = null;
		Statement exe = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ioner = DriverManager.getConnection("jdbc:mysql://localhost:3306/youngwave", "root", "1324");
			System.out.println("-----------Databases(insert) Ŭ���� ����-----------");
			// jdbc : java database connection
			// �� ��ǻ�Ϳ� ������ ������ localhost�� ���� ��.
			// database�� �ƹ��� ����. ������ ���� ����� �ƴ϶�� root�ۿ� ����.
			
			exe = ioner.createStatement();
			String recordadd = "insert into wave(age, name) values(25, 'bae')";
			// Statement�� import�� java.sql.Statement;�� �ؾ���.
			exe.executeUpdate(recordadd);
			// sql ������ �����ϴ� ����.
			// ������ ������ �굵 ���������.
		}catch(Exception e){
			System.out.println(e+"�����Դϴ�.");
		}finally {
			try {
				exe.close();
				// Statement�� �����߱� ������ �굵 ���������
				ioner.close();
			}catch(Exception e) {
			}
		}
	}
	public static void main(String[] args) {
		new Databases();
	}
}
