package ClientUI;
//�ʱ�ȭ ���� �Ϸ�
//�����Է� ������ : �ƿ�ǲ ����
//�� �Է� �Ǹ� ����Ǵ� �͸� �����ϸ� ��.

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
	// ��ü ����
	Databases in = new Databases();
	
	JFrame f = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("������ȸ", JLabel.CENTER);
	JLabel label1 = new JLabel("���� 1 : ", JLabel.RIGHT);
	JLabel label2 = new JLabel("���� 2 : ", JLabel.RIGHT);
	JLabel label3 = new JLabel("���� 3 : ", JLabel.RIGHT);
	JLabel label4 = new JLabel("�հ� : ", JLabel.RIGHT);
	JLabel label5 = new JLabel("��� : ", JLabel.RIGHT);
	JButton button = new JButton("����ȭ������");
	
	//-----------------------------------------------------------
	
	public void ClientLook(DatabaseObject item){
		// ��ü ���� 2(�Ķ���� ���� ������ �߰�)
		JLabel label6 = new JLabel(Integer.toString(item.getScore1())+"��", JLabel.LEFT);
		JLabel label7 = new JLabel(Integer.toString(item.getScore2())+"��", JLabel.LEFT);
		JLabel label8 = new JLabel(Integer.toString(item.getScore3())+"��", JLabel.LEFT);
		JLabel label9 = new JLabel(Integer.toString(item.getSum())+"��", JLabel.LEFT);
		JLabel label10 = new JLabel(Integer.toString(item.getAvg())+"��", JLabel.LEFT);
		//--------------------------------------------------------------
		
		// ���̾ƿ� ����
		panel.setLayout(null);
		f.setLayout(null);
		//--------------------------------------------------------------
	
		// ���̾ƿ� ��ġ
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
		
		// ��ü �ٹ̱�
		Font font = new Font("Cooper ����", Font.BOLD, 60); 
		Font font1 = new Font("Cooper ����", Font.BOLD, 30);
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
		
		// Container ����
		panel.setSize(800,600);
		panel.setVisible(true);
		f.add(panel);
		f.setTitle("������ȸ");
		f.setSize(800,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		//----------------------------------------------------------
		
		button.addActionListener(new ActionListener() { 
			// �ʱ�ȭ��ư Ŭ������ ��, �ؽ�Ʈ�ʵ� 1, 2, 3 ���� �������� ��հ��� �������� ���
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
