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
			// 하나의 커넥트당 작업은 하나씩 해야한다.
			save = connect.createStatement();
			System.out.println("-----------Databases1(출력) 클래스 실행-----------");

			String data = "select * from wave"; 
			iot = save.executeQuery(data);
			// 쿼리는 데이터를 끌고 오는것.
			while(iot.next()){ // iot.next()는 iot에 정보가 있냐고 물어보는것.
				//if를 쓰면 1줄만 나오고, while을 쓰면 전체 데이터베이스 줄이 나옴
				System.out.println("age 값 : " + iot.getInt("age") + " / "+ "name 값 : "+ iot.getString("name"));
				// 필드의 자료타입이 뭔지에 따라 getInt, getString으로 사용
			}
		}catch(Exception e) {
			System.out.println(e+"오류입니다.");
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
