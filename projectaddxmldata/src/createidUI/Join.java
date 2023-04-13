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
	File f = new File(path);                 // ���ϻ����� ���� ��θ� �����ϰ� ��ü������ 
	Vector<String> data = new Vector<String>();
	String [] studentID = f.list();           // StudentID��� �迭������ ����  ������ �̸����� ����   / �迭�� �ʿ��� ��ŭ �þ.
		
	//////////////////////////////////////////////////////// container
	JFrame membership = new JFrame();
	
	//////////////////////////////////////////////////////// �˾�â
	JOptionPane alert = new JOptionPane();

	//////////////////////////////////////////////////////// Ÿ��Ʋ
	JLabel title = new JLabel("ȸ������");
		
	//////////////////////////////////////////////////////// ù��° ��ü����
	JLabel namelabel = new JLabel("�̸�", JLabel.RIGHT);
	JTextField nametext = new JTextField();
	JLabel genderlabel = new JLabel("����", JLabel.RIGHT);
	JLabel namecheck = new JLabel();
    JRadioButton checkbox[] = new JRadioButton[2];
    String checkbox_name[] = {"��", "��"}; 
	ButtonGroup group = new ButtonGroup();
	
	//////////////////////////////////////////////////////// �ι�° ��ü����
	JLabel idlabel = new JLabel("���̵�", JLabel.RIGHT);
	JTextField idtext = new JTextField();
	JButton idbutton = new JButton("�ߺ�Ȯ��");
	JLabel idcheck = new JLabel();
	
	//////////////////////////////////////////////////////// ����°�� ��ü����
	JLabel pw1label = new JLabel("��й�ȣ", JLabel.RIGHT);
	JTextField pw1text = new JTextField("");
	JLabel pw1check = new JLabel();
	
	//////////////////////////////////////////////////////// �׹�°�� ��ü����
	JLabel pw2label = new JLabel("��й�ȣȮ��", JLabel.RIGHT);
	JTextField pw2text = new JTextField("");
	JLabel pw2check = new JLabel();
	
	//////////////////////////////////////////////////////// �ټ���°�� ��ü����
	JLabel hakbunlabel = new JLabel("�й�", JLabel.RIGHT);
	JTextField hakbuntext = new JTextField();
	JLabel hakbuncheck = new JLabel();
	
	//////////////////////////////////////////////////////// ������°�� ��ü����
	JLabel phonelabel = new JLabel("����ó", JLabel.RIGHT);
	JTextField phonetext = new JTextField();
	JLabel phonecheck = new JLabel();
	
	//////////////////////////////////////////////////////// �ϰ���°�� ��ü����
	JLabel emaillabel = new JLabel("�̸���", JLabel.RIGHT);
	JTextField emailtext = new JTextField("");
	JLabel emailcheck = new JLabel();
	JComboBox<String> combo = new JComboBox<String>();
	
	//////////////////////////////////////////////////////// ������°�� ��ü���� (���â)
	JLabel war = new JLabel();
	
	//////////////////////////////////////////////////////// ��ȩ��°�� ��ü���� (ȸ������ ���ư��� ��ư)
	JButton okbutton = new JButton("�����ϱ�");
	JButton returnbutton = new JButton("���ư���");
		
	public Join(){
		////////////////////////////////////////////////////  Ÿ��Ʋ
		membership.setLayout(null);
	    title.setBounds(340, 15, 930, 55);
	    title.setFont(new Font("�������", Font.BOLD, 20));
	  	membership.add(title);
		
		////////////////////////////////////////////////////  ù��°�� : �̸�, ����
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
		
		//////////////////////////////////////////////////// �ι�°�� : ���̵�
		idlabel.setBounds(100, 150, 80, 30);
		idtext.setBounds(185, 150, 320, 30);
		idcheck.setBounds(185, 180, 250, 20);
		idbutton.setBounds(530, 150, 95, 30);
		membership.add(idcheck);
		membership.add(idlabel);
		membership.add(idtext);
		membership.add(idbutton);
		
		//////////////////////////////////////////////////// ����°�� : ��й�ȣ
		pw1label.setBounds(100, 200, 80, 30);
		pw1text.setBounds(185, 200, 440, 30);
		pw1check.setBounds(185, 230, 250, 20);
		membership.add(pw1check);
		membership.add(pw1label);
		membership.add(pw1text);
		
		///////////////////////////////////////////////////////////////// �׹�°�� : ��й�ȣȮ��
		pw2label.setBounds(100, 250, 80, 30);
		pw2text.setBounds(185, 250, 440, 30);
		pw2check.setBounds(185, 280, 250, 20);
		membership.add(pw2label);
		membership.add(pw2text);
		membership.add(pw2check);
		
		/////////////////////////////////////////////////////////////////////////// �ټ���°�� : �й�
		hakbunlabel.setBounds(100, 300, 80, 30);
		hakbuntext.setBounds(185, 300, 440, 30);
		hakbuncheck.setBounds(185, 330, 250, 20);
		membership.add(hakbunlabel);
		membership.add(hakbuntext);
		membership.add(hakbuncheck);
		
		//////////////////////////////////////////////////////////////////////////// ������°�� : ����ó
		phonelabel.setBounds(100, 350, 80, 30);
		phonetext.setBounds(185, 350, 440, 30);
		phonecheck.setBounds(185,380, 250, 20);
		membership.add(phonelabel);
		membership.add(phonetext);
		membership.add(phonecheck);
		
		//////////////////////////////////////////////////////////////////////////// �ϰ���°�� : �̸���
		emaillabel.setBounds(100, 400, 80, 30);
		emailtext.setBounds(185, 400, 250, 30);
		emailcheck.setBounds(185, 430, 250, 20);
		combo.setBounds(455, 400, 170, 30);
		combo.addItem("---------�����Է�--------");
		combo.addItem("@naver.com");
		combo.addItem("@gmail.com");
		combo.addItem("@nate.com");
		combo.addItem("@hanmail.net");
		combo.addItem("@daum.net");
		
		membership.add(emaillabel);
		membership.add(emailtext);
		membership.add(emailcheck);
		membership.add(combo);
						
		/////////////////////////////////////////////////////////////////////////////// ������°�� : ���â
		war.setBounds(100, 450, 550, 40);
		membership.add(war);
		
		//////////////////////////////////////////////////////////////////////////////// ������°�� : ȸ�����Թ�ư
		okbutton.setBounds(100, 500, 250, 30);
		returnbutton.setBounds(400, 500, 250, 30);
		
		membership.add(okbutton);
		membership.add(returnbutton);
						
		//////////////////////////////////////////  ȭ�鱸��	
		membership.setVisible(true);
		membership.setSize(800, 600);
		membership.setDefaultCloseOperation(membership.EXIT_ON_CLOSE);
		membership.setLocationRelativeTo(null);
		
		////////////////////////////////////////////////////////////////////////////// ȸ�����Թ�ư �� ���ư����ư �̺�Ʈ����
		okbutton.addActionListener(this);
		returnbutton.addActionListener(this);
		
		//////////////////////////////////////////////////////////////////////////////	�ߺ�Ȯ�� ��ư �̺�Ʈ����
		idbutton.addActionListener(this);
		
		//////////////////////////////////////////////////////////////////////////////	�̸��� ��ư �̺�Ʈ����
		combo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		String emailt;
		////////////////////////////////////////////////////////////////////////////////// ȸ������ ������ ����
		if(e.getActionCommand() == "�����ϱ�") {
							
			//////////////////////////////////////////////////////////////////////////// �ؽ�Ʈ â ��Ȳ�� ���� �˾�â ����
			if(nametext.getText().equals("")){
				alert.showMessageDialog(null, "�̸��� �Է����ּ���");
				return;
			}if(!checkbox[0].isSelected() && !checkbox[1].isSelected()){
				alert.showMessageDialog(null, "������ �������ּ���");
				return;
			}if(idtext.getText().equals("")){
				alert.showMessageDialog(null, "���̵� �Է����ּ���");
				return;
			}if(b == 0){
				alert.showMessageDialog(null, "���̵� �ߺ�Ȯ�� ��ư�� Ŭ�����ּ���");
				return;
			}if(a == 1){
				alert.showMessageDialog(null, "���̵� �ߺ��Ǿ����ϴ�");
				return;
			}if(pw1text.getText().equals("")){
				alert.showMessageDialog(null, "��й�ȣ�� �Է����ּ���");
				return;
			}if(!pw1text.getText().equals(pw2text.getText())){
				alert.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�");
				return;
			}if(hakbuntext.getText().equals("")){
				alert.showMessageDialog(null, "�й��� �Է����ּ���");
				return;
			}if(phonetext.getText().equals("")){
				alert.showMessageDialog(null, "����ó�� �Է����ּ���");
				return;
			}if(emailtext.getText().equals("")){
				alert.showMessageDialog(null, "�̸����� �Է����ּ���");
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
					
			alert.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
			Homepage ho = new Homepage();
			ho.panel_1();
			membership.dispose();            //   ���� ȭ�� �����ϸ�˴ϴ�**************
		}
		
		//////////////////////////////////////////////////////////////////////////////////////// ���ư���
		else if(e.getActionCommand().equals("���ư���")) {	// ���ư����ư �̺�Ʈ����
			alert.showMessageDialog(null, "����ȭ������ ���ư��ϴ�");
			Homepage ho = new Homepage();
			ho.panel_1();
			membership.dispose();                 //   ���� ȭ�� �����ϸ�˴ϴ�**************
		}
		//////////////////////////////////////////////////////////////////////////////////////// �ߺ�Ȯ�ι�ư ���
		else if(e.getActionCommand().equals("�ߺ�Ȯ��")){
			List<DatabaseObject> list = database.checkDatabase();
			
			if(idtext.getText().equals("")){
				idcheck.setForeground(Color.red);
				idcheck.setText("ID�� �Է����ּ���.");
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
				idcheck.setText("��� ������ ID�Դϴ�.");
				a = 0;
				b = 1;
			}else{
				idcheck.setForeground(Color.red);
				idcheck.setText("�����ϴ� ID�Դϴ�.");
				a = 1;
				b = 0;
			}
		}	
	}
}