package controler;

import java.util.Scanner;

import action.CommonInter;
import action.DataInsert;
import action.Datadelete;
import action.Datafullselect;
import action.Dataindividualselect;
import action.Dataivdelete;

public class Menupan {
	Scanner in = null;
	private int input;
	public void menu() {
		in = new Scanner(System.in);
		CommonInter inter = null;
		
		while(true) {
			System.out.println("1.�����Է� 2.���� ��ü��� 3.���� ������� 4.���� ��ü���� 5.���� �������� 6.����");
			input = in.nextInt();
			
			if(input == 1){
				inter = new DataInsert();
				inter.over();
			}else if(input == 2){
				inter = new Datafullselect();
				inter.over();
			}else if(input == 3){
				inter = new Dataindividualselect();
				inter.over();
			}else if(input == 4){
				inter = new Datadelete();
				inter.over();
			}else if(input == 5) {
				inter = new Dataivdelete();
				inter.over();
			}else if(input == 6){
				System.out.println("�ý����� ����Ǿ����ϴ�."); break;
			}else{
				System.out.println("�ٽ� �������ּ���.");
			}
		}	
	}
}
