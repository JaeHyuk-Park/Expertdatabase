package createidUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.Databases;
import dto.DatabaseObject;
import loginUI.Homepage;

public class Join implements ActionListener{	
	static int a = 0;
	static int b = 0;
	static int c = 0;
	
	Databases database = Databases.getInstance();
	
	String path = "D:\\Jason\\data\\ID";
	File f = new File(path);                 // 파일생성을 위해 경로를 지정하고 객체를생성 
	Vector<String> data = new Vector<String>();
	String [] studentID = f.list();           // StudentID라는 배열변수을 만들어서  파일의 이름들을 저장   / 배열은 필요한 만큼 늘어남.
		
	//////////////////////////////////////////////////////// container
	JFrame membership = new JFrame();
	
	//////////////////////////////////////////////////////// 팝업창
	JOptionPane alert = new JOptionPane();

	//////////////////////////////////////////////////////// 타이틀
	JLabel title = new JLabel("회원가입");
		
	//////////////////////////////////////////////////////// 첫번째 객체생성
	JLabel namelabel = new JLabel("이름", JLabel.RIGHT);
	JTextField nametext = new JTextField();
	JLabel genderlabel = new JLabel("성별", JLabel.RIGHT);
	JLabel namecheck = new JLabel();
    JRadioButton checkbox[] = new JRadioButton[2];
    String checkbox_name[] = {"남", "녀"}; 
	ButtonGroup group = new ButtonGroup();
	
	//////////////////////////////////////////////////////// 두번째 객체생성
	JLabel idlabel = new JLabel("아이디", JLabel.RIGHT);
	JTextField idtext = new JTextField();
	JButton idbutton = new JButton("중복확인");
	JLabel idcheck = new JLabel();
	
	//////////////////////////////////////////////////////// 세번째줄 객체생성
	JLabel pw1label = new JLabel("비밀번호", JLabel.RIGHT);
	JTextField pw1text = new JTextField("");
	JLabel pw1check = new JLabel();
	
	//////////////////////////////////////////////////////// 네번째줄 객체생성
	JLabel pw2label = new JLabel("비밀번호확인", JLabel.RIGHT);
	JTextField pw2text = new JTextField("");
	JLabel pw2check = new JLabel();
	
	//////////////////////////////////////////////////////// 다섯번째줄 객체생성
	JLabel hakbunlabel = new JLabel("학번", JLabel.RIGHT);
	JTextField hakbuntext = new JTextField();
	JLabel hakbuncheck = new JLabel();
	
	//////////////////////////////////////////////////////// 여섯번째줄 객체생성
	JLabel phonelabel = new JLabel("연락처", JLabel.RIGHT);
	JTextField phonetext = new JTextField();
	JLabel phonecheck = new JLabel();
	
	//////////////////////////////////////////////////////// 일곱번째줄 객체생성
	JLabel emaillabel = new JLabel("이메일", JLabel.RIGHT);
	JTextField emailtext = new JTextField("");
	JLabel emailcheck = new JLabel();
	JComboBox<String> combo = new JComboBox<String>();
	
	//////////////////////////////////////////////////////// 여덜번째줄 객체생성 (경고창)
	JLabel war = new JLabel();
	
	//////////////////////////////////////////////////////// 아홉번째줄 객체생성 (회원가입 돌아가기 버튼)
	JButton okbutton = new JButton("가입하기");
	JButton returnbutton = new JButton("돌아가기");
		
	public Join(){
		////////////////////////////////////////////////////  타이틀
		membership.setLayout(null);
	    title.setBounds(340, 15, 930, 55);
	    title.setFont(new Font("맑은고딕", Font.BOLD, 20));
	  	membership.add(title);
		
		////////////////////////////////////////////////////  첫번째줄 : 이름, 성별
		namelabel.setBounds(100, 100, 80, 30);
		nametext.setBounds(185, 100, 250, 30);
		namecheck.setBounds(185, 130, 250, 20);
		genderlabel.setBounds(450, 100, 80, 30);
				
		for(int i=0; i<checkbox.length; i++){
            checkbox[i] = new JRadioButton(checkbox_name[i]);
            group.add(checkbox[i]);
        }
		
		checkbox[0].setBounds(540, 90, 50, 50);
		checkbox[1].setBounds(590, 90, 50, 50);
		membership.add(namelabel);
		membership.add(nametext);
		membership.add(namecheck);
		membership.add(genderlabel);
		membership.add(checkbox[0]);
		membership.add(checkbox[1]);
		
		//////////////////////////////////////////////////// 두번째줄 : 아이디
		idlabel.setBounds(100, 150, 80, 30);
		idtext.setBounds(185, 150, 320, 30);
		idcheck.setBounds(185, 180, 250, 20);
		idbutton.setBounds(530, 150, 95, 30);
		membership.add(idcheck);
		membership.add(idlabel);
		membership.add(idtext);
		membership.add(idbutton);
		
		//////////////////////////////////////////////////// 세번째줄 : 비밀번호
		pw1label.setBounds(100, 200, 80, 30);
		pw1text.setBounds(185, 200, 440, 30);
		pw1check.setBounds(185, 230, 250, 20);
		membership.add(pw1check);
		membership.add(pw1label);
		membership.add(pw1text);
		
		///////////////////////////////////////////////////////////////// 네번째줄 : 비밀번호확인
		pw2label.setBounds(100, 250, 80, 30);
		pw2text.setBounds(185, 250, 440, 30);
		pw2check.setBounds(185, 280, 250, 20);
		membership.add(pw2label);
		membership.add(pw2text);
		membership.add(pw2check);
		
		/////////////////////////////////////////////////////////////////////////// 다섯번째줄 : 학번
		hakbunlabel.setBounds(100, 300, 80, 30);
		hakbuntext.setBounds(185, 300, 440, 30);
		hakbuncheck.setBounds(185, 330, 250, 20);
		membership.add(hakbunlabel);
		membership.add(hakbuntext);
		membership.add(hakbuncheck);
		
		//////////////////////////////////////////////////////////////////////////// 여섯번째줄 : 연락처
		phonelabel.setBounds(100, 350, 80, 30);
		phonetext.setBounds(185, 350, 440, 30);
		phonecheck.setBounds(185,380, 250, 20);
		membership.add(phonelabel);
		membership.add(phonetext);
		membership.add(phonecheck);
		
		//////////////////////////////////////////////////////////////////////////// 일곱번째줄 : 이메일
		emaillabel.setBounds(100, 400, 80, 30);
		emailtext.setBounds(185, 400, 250, 30);
		emailcheck.setBounds(185, 430, 250, 20);
		combo.setBounds(455, 400, 170, 30);
		combo.addItem("---------직접입력--------");
		combo.addItem("@naver.com");
		combo.addItem("@gmail.com");
		combo.addItem("@nate.com");
		combo.addItem("@hanmail.net");
		combo.addItem("@daum.net");
		
		membership.add(emaillabel);
		membership.add(emailtext);
		membership.add(emailcheck);
		membership.add(combo);
						
		/////////////////////////////////////////////////////////////////////////////// 여덟번째줄 : 경고창
		war.setBounds(100, 450, 550, 40);
		membership.add(war);
		
		//////////////////////////////////////////////////////////////////////////////// 여덟번째줄 : 회원가입버튼
		okbutton.setBounds(100, 500, 250, 30);
		returnbutton.setBounds(400, 500, 250, 30);
		
		membership.add(okbutton);
		membership.add(returnbutton);
						
		//////////////////////////////////////////  화면구현	
		membership.setVisible(true);
		membership.setSize(800, 600);
		membership.setDefaultCloseOperation(membership.EXIT_ON_CLOSE);
		membership.setLocationRelativeTo(null);
		
		////////////////////////////////////////////////////////////////////////////// 회원가입버튼 및 돌아가기버튼 이벤트설정
		okbutton.addActionListener(this);
		returnbutton.addActionListener(this);
		
		//////////////////////////////////////////////////////////////////////////////	중복확인 버튼 이벤트설정
		idbutton.addActionListener(this);
		
		//////////////////////////////////////////////////////////////////////////////	이메일 버튼 이벤트설정
		combo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		String emailt;
		////////////////////////////////////////////////////////////////////////////////// 회원가입 데이터 저장
		if(e.getActionCommand() == "가입하기") {
							
			//////////////////////////////////////////////////////////////////////////// 텍스트 창 상황에 따른 팝업창 설정
			if(nametext.getText().equals("")){
				alert.showMessageDialog(null, "이름을 입력해주세요");
				return;
			}if(!checkbox[0].isSelected() && !checkbox[1].isSelected()){
				alert.showMessageDialog(null, "성별을 선택해주세요");
				return;
			}if(idtext.getText().equals("")){
				alert.showMessageDialog(null, "아이디를 입력해주세요");
				return;
			}if(b == 0){
				alert.showMessageDialog(null, "아이디 중복확인 버튼을 클릭해주세요");
				return;
			}if(a == 1){
				alert.showMessageDialog(null, "아이디가 중복되었습니다");
				return;
			}if(pw1text.getText().equals("")){
				alert.showMessageDialog(null, "비밀번호를 입력해주세요");
				return;
			}if(!pw1text.getText().equals(pw2text.getText())){
				alert.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
				return;
			}if(hakbuntext.getText().equals("")){
				alert.showMessageDialog(null, "학번을 입력해주세요");
				return;
			}if(phonetext.getText().equals("")){
				alert.showMessageDialog(null, "연락처를 입력해주세요");
				return;
			}if(emailtext.getText().equals("")){
				alert.showMessageDialog(null, "이메일을 입력해주세요");
				return;
			}
			
			DatabaseObject go = new DatabaseObject();
			go.name = nametext.getText();
			
			if(checkbox[0].isSelected()) {
				go.gender = checkbox[0].getText();
			}else if(checkbox[1].isSelected()) {
				go.gender = checkbox[1].getText();
			}
				
			go.id = idtext.getText();
			go.password = pw1text.getText();
			go.hakbun = hakbuntext.getText();
			go.phone = phonetext.getText();
			go.email = emailtext.getText() + combo.getSelectedItem();
			
			go.setName(go.name);
			go.setGender(go.gender);
			go.setId(go.id);
			go.setPassword(go.password);
			go.setHakbun(go.hakbun);
			go.setPhone(go.phone);
			go.setEmail(go.email);
								
			database.joinDatabase(go);
					
			alert.showMessageDialog(null, "가입이 완료되었습니다");
			Homepage ho = new Homepage();
			ho.panel_1();
			membership.dispose();            //   다음 화면 연결하면됩니다**************
		}
		
		//////////////////////////////////////////////////////////////////////////////////////// 돌아가기
		else if(e.getActionCommand().equals("돌아가기")) {	// 돌아가기버튼 이벤트설정
			alert.showMessageDialog(null, "메인화면으로 돌아갑니다");
			Homepage ho = new Homepage();
			ho.panel_1();
			membership.dispose();                 //   다음 화면 연결하면됩니다**************
		}
		//////////////////////////////////////////////////////////////////////////////////////// 중복확인버튼 기능
		else if(e.getActionCommand().equals("중복확인")){
			List<DatabaseObject> list = database.checkDatabase();
			
			if(idtext.getText().equals("")){
				idcheck.setForeground(Color.red);
				idcheck.setText("ID를 입력해주세요.");
				a = 1;
				b = 0;
				return;
			}	
			int ErrCode = 0;
			for(int i=0; i < list.size(); i++){											
				if(idtext.getText().equals(list.get(i).id)){			
					ErrCode = 1;
					break;
				}	
			}
			
			if(ErrCode == 0){
				idcheck.setForeground(Color.red);
				idcheck.setText("사용 가능한 ID입니다.");
				a = 0;
				b = 1;
			}else{
				idcheck.setForeground(Color.red);
				idcheck.setText("존재하는 ID입니다.");
				a = 1;
				b = 0;
			}
		}	
	}
}