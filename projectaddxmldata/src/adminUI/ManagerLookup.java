package adminUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dao.Databases;
import dto.DatabaseObject;

 public class ManagerLookup extends JPanel implements ActionListener {
	
	JFrame ml = new JFrame(); // �����̳� JFrame
	JPanel pa1 = new JPanel();
	JPanel pa2 = new JPanel();
	JPanel pa3 = new JPanel();
	TextField search = new TextField();
	Button searchto = new Button("�˻�");
	Button total = new Button("��ü���� Ȯ��");
	Button adjustment = new Button("���� �����ϱ�");
	DatabaseObject data = new DatabaseObject();
	
	Databases db = new Databases();
	List<DatabaseObject> totalInfo = db.totaloutput();
	
	void StudentInfo (String data) {
		
		  // ������Ʈ ��ü ����
		  JLabel stu1 = new JLabel("I.D : ");
		  JLabel stu2 = new JLabel("����1 : ");
		  JLabel stu3 = new JLabel("����2 : ");
		  JLabel stu4 = new JLabel("����3 : ");
		  JLabel stu5 = new JLabel("�հ� : ");
		  JLabel stu6 = new JLabel("��� : ");
		  
		  JLabel an1 = new JLabel(" ");
		  JLabel an2 = new JLabel(" ");
		  JLabel an3 = new JLabel(" ");
		  JLabel an4 = new JLabel(" ");
		  JLabel an5 = new JLabel(" ");
		  JLabel an6 = new JLabel(" ");
		  
		  for(int i = 0; i < totalInfo.size(); i++) {
			  
			  if(totalInfo.get(i).id.equals(data)) {
				  
				  an1.setText(totalInfo.get(i).id);
				  an2.setText(totalInfo.get(i).score1 + "");
				  an3.setText(totalInfo.get(i).score2 + "");
				  an4.setText(totalInfo.get(i).score3 + "");
				  an5.setText(totalInfo.get(i).sum + "");
				  an6.setText(totalInfo.get(i).avg + "");
				  
			  } // if
			  
		  } // for
		  
		  // ������Ʈ ��ġ
		  stu1.setFont(new Font(null, 1, 20));
		  stu2.setFont(new Font(null, 1, 20));
		  stu3.setFont(new Font(null, 1, 20));
		  stu4.setFont(new Font(null, 1, 20));
		  stu5.setFont(new Font(null, 1, 20));
		  stu6.setFont(new Font(null, 1, 20));
		  
		  an1.setFont(new Font(null, 0, 20));
		  an2.setFont(new Font(null, 0, 20));
		  an3.setFont(new Font(null, 0, 20));
		  an4.setFont(new Font(null, 0, 20));
		  an5.setFont(new Font(null, 0, 20));
		  an6.setFont(new Font(null, 0, 20));
		  
		  stu1.setBounds(300,15,200,60);
		  pa2.add(stu1);
		  stu2.setBounds(200, 100, 200, 60);
		  pa2.add(stu2);
		  stu3.setBounds(200, 160, 200, 60);
		  pa2.add(stu3);
		  stu4.setBounds(200, 220, 200, 60);
		  pa2.add(stu4);
		  stu5.setBounds(400, 100, 200, 60);
		  pa2.add(stu5);
		  stu6.setBounds(400, 160, 200, 60);
		  pa2.add(stu6);
		  
		  an1.setBounds(350, 15, 200, 60);
		  pa2.add(an1);
		  an2.setBounds(280, 100, 200, 60);
		  pa2.add(an2);
		  an3.setBounds(280, 160, 200, 60);
		  pa2.add(an3);
		  an4.setBounds(280, 220, 200, 60);
		  pa2.add(an4);
		  an5.setBounds(480, 100, 200, 60);
		  pa2.add(an5);
		  an6.setBounds(480, 160, 200, 60);
		  pa2.add(an6);
		  
		  // ���� ��ü������ȸ ���������� ���μ�����ȸ �������� �Ѿ�ð�� �˻� �ȳ� ������ ���
		  if(data.equals("guide")) {
			  pa2.removeAll();
			  JLabel guide = new JLabel("ã���ô� ������� ID�� �Է����ּ���.");
			  guide.setBounds(300, 300, 200, 60);
			  pa2.add(guide);
		  }
		  
		  if(data.equals("delete")) {
			  pa2.removeAll();
			  JLabel guide = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
			  guide.setBounds(300, 300, 200, 60);
			  pa2.add(guide);
		  }
		  
	} // StudentInfo();
	
	public ManagerLookup(){

		total.setFont(new Font(null, 0, 15));
		adjustment.setFont(new Font(null, 0, 15));
		
		ml.setLayout(new BorderLayout());
		pa1.setLayout(new BorderLayout());
		pa2.setLayout(new FlowLayout());
		pa3.setLayout(new FlowLayout());
		
		pa1.add(search, "Center");
		pa1.add(searchto, "East");
		pa3.add(total);
		pa3.add(adjustment);

		ml.add(pa1, "North");
		ml.add(pa2, "Center");
		ml.add(pa3, "South");
		
		// ml.setLocationRelativeTo(null);
		ml.setSize(800, 600);
        ml.setVisible(true);
        ml.setLocationRelativeTo(null);
        ml.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        searchto.addActionListener(this); // �˻�
        total.addActionListener(this); // ��ü���� Ȯ��
        adjustment.addActionListener(this); // ���������ϱ�
        
	} // method MLookup
  
  
	@Override
public void actionPerformed(ActionEvent e) {
		String g = e.getActionCommand();
		 
		 if(g.equals("�˻�")) {
			data.id = search.getText();
			// db.search(totalInfo, keyword);
			pa2.removeAll();
			StudentInfo(data.id);
			pa2.repaint();
			 
		 } else if(g.equals("��ü���� Ȯ��")) {
			ml.setVisible(false);
			Manager ml = new Manager();
				
		 } else if(g.equals("���� �����ϱ�")) {
			 data.id = search.getText();
			 data.setId(data.id);
			 db.deleteInfo(data);
			 StudentInfo(data.id);
			 JOptionPane.showMessageDialog(null, "���� �Ǿ����ϴ�.");
			 pa2.repaint();
		 }
		
		} // actionPerformed

} // class end