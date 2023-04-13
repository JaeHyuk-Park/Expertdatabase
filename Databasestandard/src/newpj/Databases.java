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
			System.out.println("-----------Databases(insert) 클래스 실행-----------");
			// jdbc : java database connection
			// 내 컴퓨터에 서버가 있으면 localhost를 쓰면 됨.
			// database는 아무나 못들어감. 계정은 따로 만든게 아니라면 root밖에 없음.
			
			exe = ioner.createStatement();
			String recordadd = "insert into wave(age, name) values(25, 'bae')";
			// Statement의 import는 java.sql.Statement;로 해야함.
			exe.executeUpdate(recordadd);
			// sql 문장을 실행하는 문장.
			// 실행을 했으니 얘도 멈춰줘야함.
		}catch(Exception e){
			System.out.println(e+"오류입니다.");
		}finally {
			try {
				exe.close();
				// Statement로 실행했기 때문에 얘도 멈춰줘야함
				ioner.close();
			}catch(Exception e) {
			}
		}
	}
	public static void main(String[] args) {
		new Databases();
	}
}
