package database;

import java.util.ArrayList;
import java.util.Scanner;

//�ʵ�(��ȣ,���̵�,����2��)
//�����Է�, �������(��ü���), �������, ��������(delete), ���Ḧ ������ ���â
class DataWorkSpace {
	Scanner in = null;
	private int input;
	DataWorkSpace() {
		in = new Scanner(System.in);
		FullOutput out = new FullOutput();
		Input ice = new Input();
		
		while(true) {
			System.out.println("1.�����Է� 2.���� ��ü��� 3.���� ������� 4.�������� 5.����");
			input = in.nextInt();
			if(input == 1){
				Overlap nite = ice.intern(); // InputŬ������ intern �޼ҵ忡 Overlap ���� �� ���� 
				out.input(nite); // FullOutput Ŭ������ input �޼ҵ忡 Overlap���� ��ü�� �Ѱ���.
			}else if(input == 2){
				ArrayList<Overlap> item = out.full();
				ice.print(item);
			}else if(input == 3){
				out.individual();
			}else if(input == 4){
				out.delete();
			}else if(input == 5){
				System.out.println("�ý����� ����Ǿ����ϴ�."); break;
			}else{
				System.out.println("�ٽ� �������ּ���.");
			}
		}	
	}
}
