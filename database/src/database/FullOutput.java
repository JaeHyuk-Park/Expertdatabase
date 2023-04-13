package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//성적 삽입, 전체출력, 개별출력, 정보삭제(delete) 기능
class FullOutput {
	Scanner enter = new Scanner(System.in);
	Overlap student;
	
	void input(Overlap item){
		Connection ioner = null;
		Statement exe = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 오류가 뜨면 프로젝트 또는 패키지에 라이브러리 연결해줘야함.
			ioner = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1324");
			System.out.println("-----------Databases(insert) 클래스 실행-----------");
			// jdbc : java database connection
			// 내 컴퓨터에 서버가 있으면 localhost를 쓰면 됨.
			// database는 아무나 못들어감. 계정은 따로 만든게 아니라면 root밖에 없음.
				
			exe = ioner.createStatement();
			String recordadd = "insert into studentinfo(hakbun, id, score1, score2) values('" + item.st1 +"', '" + item.st2 +"',"+ item.score1 + ","+ item.score2 +")";
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
	//전체출력 메소드
	ArrayList<Overlap> full(){
		System.out.println("성적 전체출력을 선택하였습니다.");
		Connection connect = null;
		Statement save = null;
		ResultSet iot = null;
		ArrayList<Overlap> over = new ArrayList<Overlap>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1324");
			// 하나의 커넥트당 작업은 하나씩 해야한다.
			save = connect.createStatement();

			String data = "select * from studentinfo"; 
			iot = save.executeQuery(data);
			// 쿼리는 데이터를 끌고 오는것.
			
			while(iot.next()){ // iot.next()는 iot에 정보가 있냐고 물어보는것.
				//if를 쓰면 1줄만 나오고, while을 쓰면 전체 데이터베이스 줄이 나옴
//				System.out.println("학번 : "+iot.getString("hakbun") +" / id : "+ iot.getString("id") + " / 점수 1 : "+iot.getInt("score1") + " / 점수 2 : "+iot.getInt("score2"));
				student = new Overlap();
				student.st1 = iot.getString("hakbun");
				student.st2 = iot.getString("id");	
				student.score1 = iot.getInt("score1");	
				student.score2 = iot.getInt("score2");
				over.add(student);
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
		return over;
	}
	//선택 출력 메소드
	void individual() {
		System.out.println("성적 개별출력을 선택하였습니다.");
		Connection connect = null;
		Statement save = null;
		ResultSet iot = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1324");
			// 하나의 커넥트당 작업은 하나씩 해야한다.
			save = connect.createStatement();
			System.out.println("확인하실 학번을 입력해주세요");
			
			String data = "select * from studentinfo where hakbun = '"+enter.next()+"'"; 
			iot = save.executeQuery(data);
			// 쿼리는 데이터를 끌고 오는것.
			if(iot.next()){ // iot.next()는 iot에 정보가 있냐고 물어보는것.
				//if를 쓰면 1줄만 나오고, while을 쓰면 전체 줄이 나옴
				System.out.println("학번 : "+iot.getString("hakbun") +" / id : "+ iot.getString("id") + " / 점수 1 : "+iot.getInt("score1") + " / 점수 2 : "+iot.getInt("score2"));
				System.out.println("----------------------------------------------------------------------");
				// 필드의 자료타입이 뭔지에 따라 getInt, getString으로 사용
			}else {
				System.out.println("없는 정보입니다. 처음으로 돌아갑니다.");
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
	//필드 삭제 메소드
	void delete() {
		System.out.println("정보삭제를 선택하였습니다.");
		Connection connect = null;
		Statement save = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1324");
			// 하나의 커넥트당 작업은 하나씩 해야한다.
			save = connect.createStatement();
			System.out.println("-----------삭제할 학번을 입력해주세요-----------");

			String data = "delete from studentinfo where hakbun = '"+enter.next()+"'";
			System.out.println("입력하신 학번의 정보는 삭제되었습니다.");
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
}
