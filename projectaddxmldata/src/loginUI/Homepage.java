package loginUI;

// 로그인 & 홈페이지
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
	//// Home : 로그인, 홈페이지
	Databases in = new Databases();
	ClientInfo info = new ClientInfo();
	ClientLookup lookup = new ClientLookup();
	ClientEdit edit = new ClientEdit();
	JFrame jf = new JFrame();

	Panel[] pa = new Panel[10];
	Font fo = new Font("맑은고딕", Font.BOLD, 30);
	Font fo1 = new Font("바탕", Font.PLAIN, 15);
	Font fo2 = new Font("맑은고딕", Font.BOLD, 15);
	Font fo3 = new Font(null);
	JLabel la = new JLabel("아이디와 비밀번호를 확인 해 주세요");
	JLabel mainname = new JLabel("성적관리 프로그램");
	JPasswordField tepw = new JPasswordField(10);
	JTextField teid = new JTextField();
	DatabaseObject data = new DatabaseObject();

	void Homepage() {
		for (int i = 0; i < 10; i++)
			pa[i] = new Panel();

		for (int i = 0; i < 10; i++)
			jf.add(pa[i]);
//////////////////////////////////////컨테이너 창 설정
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setSize(800, 600);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
	} // Homepage Home

	public void panel_1() {
		Homepage();
//////////////////////////////////// 로그인화면 (메인화면)
			pa[0].setLayout(null);
			pa[0].setSize(800, 600);
//////////////////////////////////// 성적관리 프로그램
			pa[0].add(mainname);
			mainname.setSize(300, 200);
			mainname.setLocation(250, 30);
			mainname.setFont(new Font(null, Font.BOLD, 30));
//////////////////////////////////// 아이디,비밀번호 텍스트창
			teid.setLocation(150, 180);
			pa[0].add(teid);
			teid.setSize(450, 35);
			teid.setText("아이디를 입력해 주세요.");
			tepw.setLocation(150, 250);
			pa[0].add(tepw);
			tepw.setSize(450, 35);
			tepw.setText("비밀번호를 입력해 주세요.");
/////////////////////////////////////// 입력 안했을시 표시
			la.setLocation(150, 280);
			pa[0].add(la);
			la.setSize(580, 50);
			la.setForeground(Color.red);
			la.setFont(fo2);
			la.setVisible(false);
/////////////////////////////////////// 로그인 버튼
			JButton logbt = new JButton("로그인");
			pa[0].add(logbt);
			logbt.setLocation(150, 350);
			logbt.setSize(200, 60);
			logbt.setBackground(Color.WHITE);
			logbt.setForeground(Color.black);
/////////////////////////////////////// 가입 버튼
			JButton accountbt3 = new JButton("회원가입");
			pa[0].add(accountbt3);
			accountbt3.setLocation(400, 350);
			accountbt3.setSize(200, 60);
			accountbt3.setBackground(Color.WHITE);
			accountbt3.setForeground(Color.black);



			accountbt3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("회원가입")) {
						jf.setVisible(false);
						Join jo = new Join();
					}
				}
			});
			teid.selectAll();
			logbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				
				
					if (e.getActionCommand().equals("로그인")) {
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
	}// 패널1

	public void panel_2(DatabaseObject data) {
		Homepage();
////////////////////////////////////////////////// 일반회원 화면
			pa[1].setLayout(null);
			pa[1].setSize(800, 600);
/////////////////////////////////////// 회원등급 표시
			JLabel nomalla = new JLabel("일반회원");
			pa[1].add(nomalla);
			nomalla.setLocation(630, 50);
			nomalla.setSize(580, 50);
			nomalla.setForeground(Color.blue);
			nomalla.setFont(fo2);
/////////////////////////////////////// 성적입력 버튼
			JButton inputbt = new JButton("성적입력");
			pa[1].add(inputbt);
			inputbt.setLocation(70, 350);
			inputbt.setSize(200, 70);
			inputbt.setBackground(Color.WHITE);
			inputbt.setForeground(Color.black);
/////////////////////////////////////// 성적조회 버튼
			JButton accountbt2 = new JButton("성적조회");
			pa[1].add(accountbt2);
			accountbt2.setLocation(280, 350);
			accountbt2.setSize(200, 70);
			accountbt2.setBackground(Color.WHITE);
			accountbt2.setForeground(Color.black);
/////////////////////////////////////// 회원정보조회 버튼
			JButton gradebt = new JButton("회원정보조회");
			pa[1].add(gradebt);
			gradebt.setLocation(490, 350);
			gradebt.setSize(200, 70);
			gradebt.setBackground(Color.WHITE);
			gradebt.setForeground(Color.black);
/////////////////////////////////////// 일반회원 로그아웃 버튼
			JButton logoutbt = new JButton("로그아웃");
			pa[1].add(logoutbt);
			logoutbt.setLocation(560, 250);
			logoutbt.setSize(100, 30);
			logoutbt.setBackground(Color.WHITE);
			logoutbt.setForeground(Color.black);
//////////////////////////////////////환영,아이디 표시
			JLabel idla = new JLabel(data.id +"님 환영합니다.");
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
		
////////////////////////////////////액션리스너
			gradebt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("회원정보조회")) {
						jf.setVisible(false);
						DatabaseObject aie = in.Clientinfoselect(data);
						info.clientIn(aie);
					}
				}
			}); // 회원정보조회 버튼
			accountbt2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("성적조회")) {
						jf.setVisible(false);
						DatabaseObject bce = in.Clientscoreselect(data);
						lookup.ClientLook(bce);
					}
				}
			}); // 성적조회 버튼
			inputbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("성적입력")) {
						jf.setVisible(false);
						in.deleteInfo(data);
						edit.ClientEditor(data);
					}
				}
			}); // 성적입력 버튼
			logoutbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("로그아웃")) {
						pa[1].setVisible(false);
						panel_1();
						la.setVisible(false);
					}
				}
			}); // 일반회원 로그아웃 버튼
		}// 패널2

	public void panel_3() {
		Homepage();
///////////////////////////////////// 관리자 화면
			pa[2].setLayout(null);
			pa[2].setSize(800, 600);
////////////////////////////////////// 환영
			JLabel managerwla = new JLabel("관리자님 환영합니다.");
			pa[2].add(managerwla);
			managerwla.setLocation(100, 125);
			managerwla.setSize(580, 50);
			managerwla.setForeground(Color.black);
			managerwla.setFont(fo);
/////////////////////////////////////// 회원등급 표시
			JLabel managerla = new JLabel("관리자");
			pa[2].add(managerla);
			managerla.setLocation(630, 50);
			managerla.setSize(580, 50);
			managerla.setForeground(Color.blue);
			managerla.setFont(fo2);
/////////////////////////////////////// 관리자 개인성적조회 버튼
			JButton indibt = new JButton("개인성적조회");
			pa[2].add(indibt);
			indibt.setLocation(90, 350);
			indibt.setSize(230, 70);
			indibt.setBackground(Color.WHITE);
			indibt.setForeground(Color.black);
/////////////////////////////////////// 관리자 전체성적조회 버튼
			JButton allbt = new JButton("전체성적조회");
			pa[2].add(allbt);
			allbt.setLocation(430, 350);
			allbt.setSize(230, 70);
			allbt.setBackground(Color.WHITE);
			allbt.setForeground(Color.black);
/////////////////////////////////////// 관리자 로그아웃 버튼
			JButton logoutbt1 = new JButton("로그아웃");
			pa[2].add(logoutbt1);
			logoutbt1.setLocation(560, 250);
			logoutbt1.setSize(100, 30);
			logoutbt1.setBackground(Color.white);
			logoutbt1.setForeground(Color.black);
		
			indibt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("개인성적조회")) {
						jf.setVisible(false);
						ManagerLookup ml = new ManagerLookup();
					}
				}
			}); // 개인성적조회
			allbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("전체성적조회")) {
						jf.setVisible(false);
						Manager mn = new Manager();
					}
				}
			}); // 전체성적조회
			logoutbt1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("로그아웃")) {
						pa[2].setVisible(false);
						panel_1();
						la.setVisible(false);
					}
				}
			}); // 관리자 로그아웃 버튼
		}// 패널 3

} // class end