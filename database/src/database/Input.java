package database;

import java.util.ArrayList;
import java.util.Scanner;

class Input{
	Scanner iot = null;
	
	Overlap intern(){
	//����Ÿ���� ���� ������ �ִ� Ŭ��������.
	//������ Ŭ���� ��ü���� ���� ��.
		iot = new Scanner(System.in);
		System.out.println("�����Է��� �����Ͽ����ϴ�.");
		System.out.println("�й��� �Է��ϼ���."); String st1 = iot.next();
		System.out.println("���̵� �Է��ϼ���."); String st2 = iot.next();
		System.out.println("ù��° ������ �Է��ϼ���."); int score1 = iot.nextInt();
		System.out.println("�ι�° ������ �Է��ϼ���."); int score2 = iot.nextInt();
		
		Overlap over = new Overlap();
		over.st1 = st1;
		over.st2 = st2;
		over.score1 = score1;
		over.score2 = score2;
		
		return over;
	}
	void print(ArrayList<Overlap> item) {
		for(int i = 0 ; i <= item.size()-1; i++){
			System.out.println("�й� : " +item.get(i).st1 +" / ���̵� : " + item.get(i).st2 +" / ù��° ���� : " +item.get(i).score1 + " / �ι�° ���� : "+item.get(i).score2);
		}
	}
}
