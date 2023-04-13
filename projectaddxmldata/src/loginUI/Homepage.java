package loginUI;

// �α��� & Ȩ������
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ClientUI.ClientEdit;
import ClientUI.ClientInfo;
import ClientUI.ClientLookup;
import adminUI.Manager;
import adminUI.ManagerLookup;
import createidUI.Join;
import dao.Databases;
import dto.DatabaseObject;

public class Homepage{
	//// Home : �α���, Ȩ������
	Databases in = new Databases();
	ClientInfo info = new ClientInfo();
	ClientLookup lookup = new ClientLookup();
	ClientEdit edit = new ClientEdit();
	JFrame jf = new JFrame();

	Panel[] pa = new Panel[10];
	Font fo = new Font("�������", Font.BOLD, 30);
	Font fo1 = new Font("����", Font.PLAIN, 15);
	Font fo2 = new Font("�������", Font.BOLD, 15);
	Font fo3 = new Font(null);
	JLabel la = new JLabel("���̵�� ��й�ȣ�� Ȯ�� �� �ּ���");
	JLabel mainname = new JLabel("�������� ���α׷�");
	JPasswordField tepw = new JPasswordField(10);
	JTextField teid = new JTextField();
	DatabaseObject data = new DatabaseObject();

	void Homepage() {
		for (int i = 0; i < 10; i++)
			pa[i] = new Panel();

		for (int i = 0; i < 10; i++)
			jf.add(pa[i]);
//////////////////////////////////////�����̳� â ����
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setSize(800, 600);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
	} // Homepage Home

	public void panel_1() {
		Homepage();
//////////////////////////////////// �α���ȭ�� (����ȭ��)
			pa[0].setLayout(null);
			pa[0].setSize(800, 600);
//////////////////////////////////// �������� ���α׷�
			pa[0].add(mainname);
			mainname.setSize(300, 200);
			mainname.setLocation(250, 30);
			mainname.setFont(new Font(null, Font.BOLD, 30));
//////////////////////////////////// ���̵�,��й�ȣ �ؽ�Ʈâ
			teid.setLocation(150, 180);
			pa[0].add(teid);
			teid.setSize(450, 35);
			teid.setText("���̵� �Է��� �ּ���.");
			tepw.setLocation(150, 250);
			pa[0].add(tepw);
			tepw.setSize(450, 35);
			tepw.setText("��й�ȣ�� �Է��� �ּ���.");
/////////////////////////////////////// �Է� �������� ǥ��
			la.setLocation(150, 280);
			pa[0].add(la);
			la.setSize(580, 50);
			la.setForeground(Color.red);
			la.setFont(fo2);
			la.setVisible(false);
/////////////////////////////////////// �α��� ��ư
			JButton logbt = new JButton("�α���");
			pa[0].add(logbt);
			logbt.setLocation(150, 350);
			logbt.setSize(200, 60);
			logbt.setBackground(Color.WHITE);
			logbt.setForeground(Color.black);
/////////////////////////////////////// ���� ��ư
			JButton accountbt3 = new JButton("ȸ������");
			pa[0].add(accountbt3);
			accountbt3.setLocation(400, 350);
			accountbt3.setSize(200, 60);
			accountbt3.setBackground(Color.WHITE);
			accountbt3.setForeground(Color.black);



			accountbt3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("ȸ������")) {
						jf.setVisible(false);
						Join jo = new Join();
					}
				}
			});
			teid.selectAll();
			logbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				
				
					if (e.getActionCommand().equals("�α���")) {
						List<DatabaseObject> list = in.checkDatabase();
						
						String iddata = teid.getText();
						String pwdata = tepw.getText();
						teid.selectAll();
						
						int ErrCode = 0;
					
						la.setVisible(true);
						for(int i=0; i < list.size(); i++){	
							if(iddata.equals(list.get(i).id)){
								ErrCode = 1;
							
								if(ErrCode == 1){
									String nadata = list.get(i).name;
									for(int g=0;g<list.size();g++) {
										if(pwdata.equals(list.get(g).password)) {
									
											pa[0].setVisible(false);
											data.id = iddata;
											data.setId(data.id);
											panel_2(data);
											break;
										}
									}
								
								}
							}
						}
					
					if (iddata.equals("root") && pwdata.equals("1234")) {
						pa[0].setVisible(false);
						panel_3();
					}
					}
				}
			});
	}// �г�1

	public void panel_2(DatabaseObject data) {
		Homepage();
////////////////////////////////////////////////// �Ϲ�ȸ�� ȭ��
			pa[1].setLayout(null);
			pa[1].setSize(800, 600);
/////////////////////////////////////// ȸ����� ǥ��
			JLabel nomalla = new JLabel("�Ϲ�ȸ��");
			pa[1].add(nomalla);
			nomalla.setLocation(630, 50);
			nomalla.setSize(580, 50);
			nomalla.setForeground(Color.blue);
			nomalla.setFont(fo2);
/////////////////////////////////////// �����Է� ��ư
			JButton inputbt = new JButton("�����Է�");
			pa[1].add(inputbt);
			inputbt.setLocation(70, 350);
			inputbt.setSize(200, 70);
			inputbt.setBackground(Color.WHITE);
			inputbt.setForeground(Color.black);
/////////////////////////////////////// ������ȸ ��ư
			JButton accountbt2 = new JButton("������ȸ");
			pa[1].add(accountbt2);
			accountbt2.setLocation(280, 350);
			accountbt2.setSize(200, 70);
			accountbt2.setBackground(Color.WHITE);
			accountbt2.setForeground(Color.black);
/////////////////////////////////////// ȸ��������ȸ ��ư
			JButton gradebt = new JButton("ȸ��������ȸ");
			pa[1].add(gradebt);
			gradebt.setLocation(490, 350);
			gradebt.setSize(200, 70);
			gradebt.setBackground(Color.WHITE);
			gradebt.setForeground(Color.black);
/////////////////////////////////////// �Ϲ�ȸ�� �α׾ƿ� ��ư
			JButton logoutbt = new JButton("�α׾ƿ�");
			pa[1].add(logoutbt);
			logoutbt.setLocation(560, 250);
			logoutbt.setSize(100, 30);
			logoutbt.setBackground(Color.WHITE);
			logoutbt.setForeground(Color.black);
//////////////////////////////////////ȯ��,���̵� ǥ��
			JLabel idla = new JLabel(data.id +"�� ȯ���մϴ�.");
			pa[1].add(idla);
			idla.setLocation(100, 125);
			idla.setSize(580, 50);
			idla.setForeground(Color.black);
			idla.setFont(fo);
			JLabel wla = new JLabel();
			wla.setLocation(100, 175);
			pa[1].add(wla);
			wla.setSize(580, 50);
			wla.setForeground(Color.gray);
			wla.setFont(fo1);
		
////////////////////////////////////�׼Ǹ�����
			gradebt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("ȸ��������ȸ")) {
						jf.setVisible(false);
						DatabaseObject aie = in.Clientinfoselect(data);
						info.clientIn(aie);
					}
				}
			}); // ȸ��������ȸ ��ư
			accountbt2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("������ȸ")) {
						jf.setVisible(false);
						DatabaseObject bce = in.Clientscoreselect(data);
						lookup.ClientLook(bce);
					}
				}
			}); // ������ȸ ��ư
			inputbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("�����Է�")) {
						jf.setVisible(false);
						in.deleteInfo(data);
						edit.ClientEditor(data);
					}
				}
			}); // �����Է� ��ư
			logoutbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("�α׾ƿ�")) {
						pa[1].setVisible(false);
						panel_1();
						la.setVisible(false);
					}
				}
			}); // �Ϲ�ȸ�� �α׾ƿ� ��ư
		}// �г�2

	public void panel_3() {
		Homepage();
///////////////////////////////////// ������ ȭ��
			pa[2].setLayout(null);
			pa[2].setSize(800, 600);
////////////////////////////////////// ȯ��
			JLabel managerwla = new JLabel("�����ڴ� ȯ���մϴ�.");
			pa[2].add(managerwla);
			managerwla.setLocation(100, 125);
			managerwla.setSize(580, 50);
			managerwla.setForeground(Color.black);
			managerwla.setFont(fo);
/////////////////////////////////////// ȸ����� ǥ��
			JLabel managerla = new JLabel("������");
			pa[2].add(managerla);
			managerla.setLocation(630, 50);
			managerla.setSize(580, 50);
			managerla.setForeground(Color.blue);
			managerla.setFont(fo2);
/////////////////////////////////////// ������ ���μ�����ȸ ��ư
			JButton indibt = new JButton("���μ�����ȸ");
			pa[2].add(indibt);
			indibt.setLocation(90, 350);
			indibt.setSize(230, 70);
			indibt.setBackground(Color.WHITE);
			indibt.setForeground(Color.black);
/////////////////////////////////////// ������ ��ü������ȸ ��ư
			JButton allbt = new JButton("��ü������ȸ");
			pa[2].add(allbt);
			allbt.setLocation(430, 350);
			allbt.setSize(230, 70);
			allbt.setBackground(Color.WHITE);
			allbt.setForeground(Color.black);
/////////////////////////////////////// ������ �α׾ƿ� ��ư
			JButton logoutbt1 = new JButton("�α׾ƿ�");
			pa[2].add(logoutbt1);
			logoutbt1.setLocation(560, 250);
			logoutbt1.setSize(100, 30);
			logoutbt1.setBackground(Color.white);
			logoutbt1.setForeground(Color.black);
		
			indibt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("���μ�����ȸ")) {
						jf.setVisible(false);
						ManagerLookup ml = new ManagerLookup();
					}
				}
			}); // ���μ�����ȸ
			allbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("��ü������ȸ")) {
						jf.setVisible(false);
						Manager mn = new Manager();
					}
				}
			}); // ��ü������ȸ
			logoutbt1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("�α׾ƿ�")) {
						pa[2].setVisible(false);
						panel_1();
						la.setVisible(false);
					}
				}
			}); // ������ �α׾ƿ� ��ư
		}// �г� 3

} // class end