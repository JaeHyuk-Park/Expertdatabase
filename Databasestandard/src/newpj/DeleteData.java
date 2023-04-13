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
			// 하나의 커넥트당 작업은 하나씩 해야한다.
			save = connect.createStatement();
			System.out.println("-----------DeleteData 클래스 실행-----------");

			String data = "delete from wave where age = 25"; 
			save.executeUpdate(data);
			// 쿼리는 데이터를 끌고 오는것.
		}catch(Exception e) {
			System.out.println(e+"오류입니다.");
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
		// 전체출력 클래스 불러옴.
	}
}
