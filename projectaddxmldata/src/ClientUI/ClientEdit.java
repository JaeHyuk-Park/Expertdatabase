package ClientUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Databases;
import dto.DatabaseObject;
import loginUI.Homepage;

public class ClientEdit{
	// 객체생성
	DatabaseObject ob = new DatabaseObject();
	Databases in = new Databases();
	
	JFrame f = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("성적입력", JLabel.CENTER);
	JLabel label1 = new JLabel("과목 1 : ", JLabel.RIGHT);
	JLabel label2 = new JLabel("과목 2 : ", JLabel.RIGHT);
	JLabel label3 = new JLabel("과목 3 : ", JLabel.RIGHT);
	JLabel label4 = new JLabel("합계 : ", JLabel.RIGHT);
	JLabel label5 = new JLabel("평균 : ", JLabel.RIGHT);
	JLabel label6 = new JLabel("", JLabel.LEFT);
	JLabel label7 = new JLabel("", JLabel.LEFT);
	JLabel label8 = new JLabel("", JLabel.LEFT);
	JButton button = new JButton("초기화");
	JButton button1 = new JButton("저장");
	JTextField field1 = new JTextField(3);
	JTextField field2 = new JTextField(3);
	JTextField field3 = new JTextField(3);
	JTextField field4 = new JTextField(3);
	JTextField field5 = new JTextField(3);
	//--------------------------------------------------------------
	
	public void ClientEditor(DatabaseObject data)	{
		// 레이아웃 지정
		panel.setLayout(null);
		f.setLayout(null);
		//--------------------------------------------------------------
	
		// 레이아웃 배치
		label.setBounds(10,40,750,55);
		panel.add(label); 
		label1.setBounds(100,130,200,50);
		panel.add(label1);
		label2.setBounds(100,200,200,50);
		panel.add(label2);
		label3.setBounds(100,270,200,50);
		panel.add(label3);		
		label4.setBounds(100,340,200,50);
		panel.add(label4);
		label5.setBounds(100,410,200,50);
		panel.add(label5);
		label6.setBounds(320, 185, 250, 12);
		panel.add(label6);
		label7.setBounds(320, 255, 250, 12);
		panel.add(label7);
		label8.setBounds(320, 325, 250, 12);
		panel.add(label8);
		field1.setBounds(320, 130, 250, 50);
		panel.add(field1);
		field2.setBounds(320, 200, 250, 50);
		panel.add(field2);
		field3.setBounds(320, 270, 250, 50);
		panel.add(field3);
		field4.setBounds(320, 340, 250, 50);
		panel.add(field4);
		field5.setBounds(320, 410, 250, 50);
		panel.add(field5);
		button.setBounds(120, 490, 250, 50);
		panel.add(button);
		button1.setBounds(400, 490, 250, 50);
		panel.add(button1);
		//---------------------------------------------------------
		
		// 객체 꾸미기
		Font font = new Font("Cooper 검정", Font.BOLD, 60); 
		Font font1 = new Font("Cooper 검정", Font.BOLD, 30);
		Font font2 = new Font("Cooper 검정", Font.BOLD, 20);
		Font font3 = new Font("Cooper 검정", Font.BOLD, 10);
		label.setFont(font); 
		label1.setFont(font1); 
		label2.setFont(font1);
		label3.setFont(font1);
		label4.setFont(font1); 
		label5.setFont(font1); 
		label6.setFont(font3);
		label7.setFont(font3);
		label8.setFont(font3);
		field1.setFont(font2);
		field2.setFont(font2);
		field3.setFont(font2);
		field4.setFont(font2);
		field5.setFont(font2);
		button.setFont(font1);
		button1.setFont(font1);
		field4.setForeground(Color.red);
		field5.setForeground(Color.red);
		field4.setText(" 자동으로 입력됩니다.");
		field5.setText(" 자동으로 입력됩니다.");
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
			// 초기화버튼 클릭했을 때, 입력한 값 초기화
			@Override
			public void actionPerformed(ActionEvent e) {
				field1.setText("");
				field2.setText("");
				field3.setText("");
			}
		});
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(field1.getText().equals("")) {
					label6.setForeground(Color.RED);
					label6.setText("값을 입력하세요.");
				}else {
					label6.setText("");
				}if(field2.getText().equals("")) {
					label7.setForeground(Color.RED);
					label7.setText("값을 입력하세요.");
				}else {
					label7.setText("");
				}if(field3.getText().equals("")) {
					label8.setForeground(Color.RED);
					label8.setText("값을 입력하세요.");
				}else {
					label8.setText("");
					int num1 = Integer.parseInt(field1.getText());
					int num2 = Integer.parseInt(field2.getText());
					int num3 = Integer.parseInt(field3.getText());
					int sum = num1+num2+num3;
					int avg = sum/3;
					String text = Integer.toString(sum);
					String text2 = Integer.toString(avg);
					field4.setText(text);
					field5.setText(text2);
					JOptionPane.showMessageDialog(null, "저장 되었습니다.");
					
					ob.id = data.id;
					ob.score1 = num1;
					ob.score2 = num2;
					ob.score3 = num3;
					ob.sum = Integer.parseInt(field4.getText());
					ob.avg = Integer.parseInt(field5.getText());
					
					ob.setId(ob.id);
					ob.setScore1(ob.score1);
					ob.setScore2(ob.score2);
					ob.setScore3(ob.score3);
					ob.setSum(ob.sum);
					ob.setAvg(ob.avg);
					
					in.databasescore(ob);
					
					f.setVisible(false);
					Homepage home = new Homepage();
					home.panel_2(data);
				}
				
			}
		});
	}
	
}