package newpj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Databases1 {
	public Databases1(){
		Connection connect = null;
		Statement save = null;
		ResultSet iot = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/youngwave", "root", "1324");
			// �ϳ��� Ŀ��Ʈ�� �۾��� �ϳ��� �ؾ��Ѵ�.
			save = connect.createStatement();
			System.out.println("-----------Databases1(���) Ŭ���� ����-----------");

			String data = "select * from wave"; 
			iot = save.executeQuery(data);
			// ������ �����͸� ���� ���°�.
			while(iot.next()){ // iot.next()�� iot�� ������ �ֳİ� ����°�.
				//if�� ���� 1�ٸ� ������, while�� ���� ��ü �����ͺ��̽� ���� ����
				System.out.println("age �� : " + iot.getInt("age") + " / "+ "name �� : "+ iot.getString("name"));
				// �ʵ��� �ڷ�Ÿ���� ������ ���� getInt, getString���� ���
			}
		}catch(Exception e) {
			System.out.println(e+"�����Դϴ�.");
		}finally {
			try {
				iot.close();
				connect.close();
			}catch(Exception e){
			}
		}
	}
	public static void main(String[] args) {
		new Databases1();
	}
}
