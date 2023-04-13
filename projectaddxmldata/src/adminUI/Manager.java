package adminUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.Databases;
import dto.DatabaseObject;
import loginUI.Homepage;

public class Manager implements ActionListener {
	
	Databases db = new Databases();
	List<DatabaseObject> total = db.totaloutput();
	// db에서 읽어온 객체들을 담아둔 ArrayList 생성
	
	String[] colName = new String[] { "ID","점수1","점수2","점수3","합계", "평균" };
	
	// GUI를 구성하는 객체 생성
	JFrame fr = new JFrame(); 
	JPanel pa1 = new JPanel();
	JPanel pa2 = new JPanel(); 
	Button b1 = new Button("개인성적 조회하기");
	Button b2 = new Button("메인으로");
	
	public Manager() {
		Object[][] obj = new Object[total.size()][6];
		// db 목록의 숫자를 행의 갯수로 하는 2차원 배열 생성
		
		for(int i = 0; i < total.size(); i++) {
		// db에 있는 내용들을 obj 2차원 배열에 (id, 점수, 합계, 평균)순서대로 저장하는 반복문
			obj[i][0] = total.get(i).id;
			obj[i][1] = total.get(i).score1;
			obj[i][2] = total.get(i).score2;
			obj[i][3] = total.get(i).score3;
			obj[i][4] = total.get(i).sum;
			obj[i][5] = total.get(i).avg;
		}
		
		JTable ta = new JTable(obj ,colName);
		// 전체출력 테이블 생성
			
		fr.setLayout(new BorderLayout());
		pa1.setLayout(new BorderLayout());
		pa2.setLayout(new GridLayout(1,3));
	
		pa1.add(ta, "Center");
		pa1.add(new JScrollPane(ta));
		
		pa2.add(b1);
		pa2.add(b2);

		fr.add(pa1, "Center");
		fr.add(pa2, "South");

		fr.setVisible(true);
		fr.setSize(800, 600);
		fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE); 
		fr.setLocationRelativeTo(null);
		
		b1.addActionListener(this); 
		b2.addActionListener(this); 
		
		} // method_MWindow

	@Override
	public void actionPerformed(ActionEvent e) {
		String g = e.getActionCommand();
		
		if(g.equals("개인성적 조회하기")) {
			fr.setVisible(false);
			ManagerLookup mg = new ManagerLookup();
			mg.StudentInfo("guide");
			
		} else if(g.equals("메인으로")) {
			fr.setVisible(false);
			Homepage home = new Homepage();
			home.panel_3();
		} 
		
	} // actionPerformed

} // class_Manager