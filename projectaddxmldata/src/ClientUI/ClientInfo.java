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
	// ��ü ����
	JFrame f = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("ȸ������", JLabel.CENTER);
	JLabel label1 = new JLabel("�̸� :", JLabel.RIGHT);
	JLabel label2 = new JLabel("���� :", JLabel.RIGHT);
	JLabel label3 = new JLabel("���̵� :", JLabel.RIGHT);
	JLabel label4 = new JLabel("��й�ȣ :", JLabel.RIGHT);
	JLabel label5 = new JLabel("�й� :", JLabel.RIGHT);
	JLabel label6 = new JLabel("����ó :", JLabel.RIGHT);
	JLabel label7 = new JLabel("�̸��� :", JLabel.RIGHT);
	JButton button = new JButton("����ȭ������");
	JLabel checkbox1 = new JLabel("", JLabel.LEFT);

	//------------------------------------------------------------
	
	public void clientIn(DatabaseObject item)	{
		// ��ü ���� 2(�Ķ���� �޾Ƽ� ������ �� �߰�)
		JLabel field1 = new JLabel(item.getName(), JLabel.LEFT);
		JLabel field2 = new JLabel(item.getGender(), JLabel.LEFT);
		JLabel field3 = new JLabel(item.getId(), JLabel.LEFT);
		JLabel field4 = new JLabel(item.getPassword(), JLabel.LEFT);
		JLabel field5 = new JLabel(item.getHakbun(), JLabel.LEFT);
		JLabel field6 = new JLabel(item.getPhone(), JLabel.LEFT);
		JLabel field7 = new JLabel(item.getEmail(), JLabel.LEFT);
		//---------------------------------------------------------
		
		// ���̾ƿ� ����
		panel.setLayout(null);
		f.setLayout(null);
		//--------------------------------------------------------
		
		// ���̾ƿ� ����
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
		
		// ��ü �ٹ̱�
		Font font = new Font("Cooper ����", Font.BOLD, 40);
		Font font1 = new Font("Cooper ����", Font.BOLD, 25);
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
		
		//Container ����	
		panel.setVisible(true);
		panel.setSize(800,600);
		f.add(panel);
		f.setTitle("ȸ�� ���� ��ȸ");
		f.setSize(800,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); // �߰��� ����
		
		// ���콺 �̺�Ʈ, ���� ��ư ������ ��
		button.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "����ȭ������ ���ư��ϴ�.");
				
				f.setVisible(false);
				Homepage home = new Homepage();
				home.panel_2(item);
			}
		});	
	}	
}