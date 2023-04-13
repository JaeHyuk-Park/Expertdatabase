package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//���� ����, ��ü���, �������, ��������(delete) ���
class FullOutput {
	Scanner enter = new Scanner(System.in);
	Overlap student;
	
	void input(Overlap item){
		Connection ioner = null;
		Statement exe = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ������ �߸� ������Ʈ �Ǵ� ��Ű���� ���̺귯�� �����������.
			ioner = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1324");
			System.out.println("-----------Databases(insert) Ŭ���� ����-----------");
			// jdbc : java database connection
			// �� ��ǻ�Ϳ� ������ ������ localhost�� ���� ��.
			// database�� �ƹ��� ����. ������ ���� ����� �ƴ϶�� root�ۿ� ����.
				
			exe = ioner.createStatement();
			String recordadd = "insert into studentinfo(hakbun, id, score1, score2) values('" + item.st1 +"', '" + item.st2 +"',"+ item.score1 + ","+ item.score2 +")";
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
	//��ü��� �޼ҵ�
	ArrayList<Overlap> full(){
		System.out.println("���� ��ü����� �����Ͽ����ϴ�.");
		Connection connect = null;
		Statement save = null;
		ResultSet iot = null;
		ArrayList<Overlap> over = new ArrayList<Overlap>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1324");
			// �ϳ��� Ŀ��Ʈ�� �۾��� �ϳ��� �ؾ��Ѵ�.
			save = connect.createStatement();

			String data = "select * from studentinfo"; 
			iot = save.executeQuery(data);
			// ������ �����͸� ���� ���°�.
			
			while(iot.next()){ // iot.next()�� iot�� ������ �ֳİ� ����°�.
				//if�� ���� 1�ٸ� ������, while�� ���� ��ü �����ͺ��̽� ���� ����
//				System.out.println("�й� : "+iot.getString("hakbun") +" / id : "+ iot.getString("id") + " / ���� 1 : "+iot.getInt("score1") + " / ���� 2 : "+iot.getInt("score2"));
				student = new Overlap();
				student.st1 = iot.getString("hakbun");
				student.st2 = iot.getString("id");	
				student.score1 = iot.getInt("score1");	
				student.score2 = iot.getInt("score2");
				over.add(student);
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
		return over;
	}
	//���� ��� �޼ҵ�
	void individual() {
		System.out.println("���� ��������� �����Ͽ����ϴ�.");
		Connection connect = null;
		Statement save = null;
		ResultSet iot = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1324");
			// �ϳ��� Ŀ��Ʈ�� �۾��� �ϳ��� �ؾ��Ѵ�.
			save = connect.createStatement();
			System.out.println("Ȯ���Ͻ� �й��� �Է����ּ���");
			
			String data = "select * from studentinfo where hakbun = '"+enter.next()+"'"; 
			iot = save.executeQuery(data);
			// ������ �����͸� ���� ���°�.
			if(iot.next()){ // iot.next()�� iot�� ������ �ֳİ� ����°�.
				//if�� ���� 1�ٸ� ������, while�� ���� ��ü ���� ����
				System.out.println("�й� : "+iot.getString("hakbun") +" / id : "+ iot.getString("id") + " / ���� 1 : "+iot.getInt("score1") + " / ���� 2 : "+iot.getInt("score2"));
				System.out.println("----------------------------------------------------------------------");
				// �ʵ��� �ڷ�Ÿ���� ������ ���� getInt, getString���� ���
			}else {
				System.out.println("���� �����Դϴ�. ó������ ���ư��ϴ�.");
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
	//�ʵ� ���� �޼ҵ�
	void delete() {
		System.out.println("���������� �����Ͽ����ϴ�.");
		Connection connect = null;
		Statement save = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1324");
			// �ϳ��� Ŀ��Ʈ�� �۾��� �ϳ��� �ؾ��Ѵ�.
			save = connect.createStatement();
			System.out.println("-----------������ �й��� �Է����ּ���-----------");

			String data = "delete from studentinfo where hakbun = '"+enter.next()+"'";
			System.out.println("�Է��Ͻ� �й��� ������ �����Ǿ����ϴ�.");
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
}
