package ClientUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dto.DatabaseObject;
import loginUI.Homepage;

public class ClientInfo{
	// 객체 생성
	JFrame f = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("회원정보", JLabel.CENTER);
	JLabel label1 = new JLabel("이름 :", JLabel.RIGHT);
	JLabel label2 = new JLabel("성별 :", JLabel.RIGHT);
	JLabel label3 = new JLabel("아이디 :", JLabel.RIGHT);
	JLabel label4 = new JLabel("비밀번호 :", JLabel.RIGHT);
	JLabel label5 = new JLabel("학번 :", JLabel.RIGHT);
	JLabel label6 = new JLabel("연락처 :", JLabel.RIGHT);
	JLabel label7 = new JLabel("이메일 :", JLabel.RIGHT);
	JButton button = new JButton("메인화면으로");
	JLabel checkbox1 = new JLabel("", JLabel.LEFT);

	//------------------------------------------------------------
	
	public void clientIn(DatabaseObject item)	{
		// 객체 생성 2(파라미터 받아서 생성된 값 추가)
		JLabel field1 = new JLabel(item.getName(), JLabel.LEFT);
		JLabel field2 = new JLabel(item.getGender(), JLabel.LEFT);
		JLabel field3 = new JLabel(item.getId(), JLabel.LEFT);
		JLabel field4 = new JLabel(item.getPassword(), JLabel.LEFT);
		JLabel field5 = new JLabel(item.getHakbun(), JLabel.LEFT);
		JLabel field6 = new JLabel(item.getPhone(), JLabel.LEFT);
		JLabel field7 = new JLabel(item.getEmail(), JLabel.LEFT);
		//---------------------------------------------------------
		
		// 레이아웃 지정
		panel.setLayout(null);
		f.setLayout(null);
		//--------------------------------------------------------
		
		// 레이아웃 설정
		label.setBounds(10,15,750,55);
		panel.add(label);
		label1.setBounds(275,90,100,30);
		panel.add(label1);
		label2.setBounds(275,145,100,30);
		panel.add(label2);
		label3.setBounds(275,200,100,30);
		panel.add(label3);
		label4.setBounds(225,255,150,30);
		panel.add(label4);
		label5.setBounds(275,310,100,30);
		panel.add(label5);
		label6.setBounds(275,365,100,30);
		panel.add(label6);
		label7.setBounds(275,420,100,30);
		panel.add(label7);
		checkbox1.setBounds(490,85,50,30);
		panel.add(checkbox1);
		field1.setBounds(385, 90, 250, 30);
		panel.add(field1);
		field2.setBounds(385, 145, 250, 30);
		panel.add(field2);
		field3.setBounds(385, 200, 250, 30);
		panel.add(field3);
		field4.setBounds(385, 255, 250, 30);
		panel.add(field4);
		button.setBounds(475, 475, 250, 50);
		field5.setBounds(385, 310, 250, 30);
		panel.add(field5);
		field6.setBounds(385, 365, 250, 30);
		panel.add(field6);
		field7.setBounds(385, 420, 300, 30);
		panel.add(field7);
		panel.add(button);
		//------------------------------------------------------
		
		// 객체 꾸미기
		Font font = new Font("Cooper 검정", Font.BOLD, 40);
		Font font1 = new Font("Cooper 검정", Font.BOLD, 25);
		label.setFont(font);
		label1.setFont(font1);
		label2.setFont(font1);
		label3.setFont(font1);
		label4.setFont(font1);
		label5.setFont(font1);
		label6.setFont(font1);
		label7.setFont(font1);
		field1.setFont(font1);
		field2.setFont(font1);
		field3.setFont(font1);
		field4.setFont(font1);
		field5.setFont(font1);
		field6.setFont(font1);
		field7.setFont(font1);
		checkbox1.setFont(font1);
		button.setFont(font1);

		//---------------------------------------------------------------
		
		//Container 세팅	
		panel.setVisible(true);
		panel.setSize(800,600);
		f.add(panel);
		f.setTitle("회원 정보 조회");
		f.setSize(800,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); // 중간에 띄우기
		
		// 마우스 이벤트, 수정 버튼 눌렀을 때
		button.addActionListener(new ActionListener() { 
			
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