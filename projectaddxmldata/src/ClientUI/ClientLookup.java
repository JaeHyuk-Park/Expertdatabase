package ClientUI;
//초기화 구현 완료
//성적입력 페이지 : 아웃풋 구현
//값 입력 되면 저장되는 것만 구현하면 됨.

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.Databases;
import dto.DatabaseObject;
import loginUI.Homepage;

public class ClientLookup{
	// 객체 생성
	Databases in = new Databases();
	
	JFrame f = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("성적조회", JLabel.CENTER);
	JLabel label1 = new JLabel("과목 1 : ", JLabel.RIGHT);
	JLabel label2 = new JLabel("과목 2 : ", JLabel.RIGHT);
	JLabel label3 = new JLabel("과목 3 : ", JLabel.RIGHT);
	JLabel label4 = new JLabel("합계 : ", JLabel.RIGHT);
	JLabel label5 = new JLabel("평균 : ", JLabel.RIGHT);
	JButton button = new JButton("메인화면으로");
	
	//-----------------------------------------------------------
	
	public void ClientLook(DatabaseObject item){
		// 객체 생성 2(파라미터 받은 값으로 추가)
		JLabel label6 = new JLabel(Integer.toString(item.getScore1())+"점", JLabel.LEFT);
		JLabel label7 = new JLabel(Integer.toString(item.getScore2())+"점", JLabel.LEFT);
		JLabel label8 = new JLabel(Integer.toString(item.getScore3())+"점", JLabel.LEFT);
		JLabel label9 = new JLabel(Integer.toString(item.getSum())+"점", JLabel.LEFT);
		JLabel label10 = new JLabel(Integer.toString(item.getAvg())+"점", JLabel.LEFT);
		//--------------------------------------------------------------
		
		// 레이아웃 지정
		panel.setLayout(null);
		f.setLayout(null);
		//--------------------------------------------------------------
	
		// 레이아웃 배치
		label.setBounds(10,40,750,55);
		panel.add(label); 
		label1.setBounds(200,130,200,50);
		panel.add(label1);
		label2.setBounds(200,200,200,50);
		panel.add(label2);
		label3.setBounds(200,270,200,50);
		panel.add(label3);		
		label4.setBounds(190,340,200,50);
		panel.add(label4);
		label5.setBounds(190,410,200,50);
		panel.add(label5);
		label6.setBounds(410, 130, 250, 50);
		panel.add(label6);
		label7.setBounds(410, 200, 250, 50);
		panel.add(label7);
		label8.setBounds(410, 270, 250, 50);
		panel.add(label8);
		label9.setBounds(400, 340, 250, 50);
		panel.add(label9);
		label10.setBounds(400, 410, 250, 50);
		panel.add(label10);
		button.setBounds(265, 490, 250, 50);
		panel.add(button);
		//---------------------------------------------------------
		
		// 객체 꾸미기
		Font font = new Font("Cooper 검정", Font.BOLD, 60); 
		Font font1 = new Font("Cooper 검정", Font.BOLD, 30);
		label.setFont(font); 
		label1.setFont(font1); 
		label2.setFont(font1);
		label3.setFont(font1);
		label4.setFont(font1); 
		label5.setFont(font1); 
		label6.setFont(font1);
		label7.setFont(font1);
		label8.setFont(font1);
		label9.setFont(font1);
		label10.setFont(font1);
		button.setFont(font1);
		//---------------------------------------------------------
		
		// Container 세팅
		panel.setSize(800,600);
		panel.setVisible(true);
		f.add(panel);
		f.setTitle("성적조회");
		f.setSize(800,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		//----------------------------------------------------------
		
		button.addActionListener(new ActionListener() { 
			// 초기화버튼 클릭했을 때, 텍스트필드 1, 2, 3 값이 합해지고 평균값이 구해지는 기능
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "메인화면으로 돌아갑니다.");
				f.setVisible(false);
				Homepage home = new Homepage();
				home.panel_2(item);
			}
		});
	}
}
