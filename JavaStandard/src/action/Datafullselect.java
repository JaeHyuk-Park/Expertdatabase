package action;

import java.util.List;

import dao.Databases;
import dto.CommonDataType;

// DBó�� ��ü
public class Datafullselect implements CommonInter {
	List<CommonDataType> list;
	
	@Override
	public void over() {
		System.out.println("���� ��ü����� �����Ͽ����ϴ�.");
		Databases db = Databases.getInstance(); // Databases xml = new Databases(); xml.datafullselect();�̶� ���� ���̴�. 
		list = db.datafullselect();
		
		for(int i=0; i<=list.size()-1; i++) {
			System.out.println("�й� : "+ list.get(i).getHakbun() + ", ���̵� : "+ list.get(i).getIdentify() +", ���� 1 : "+ list.get(i).getScore1() +", ���� 2 : "+ list.get(i).getScore2());
			//���� ����Ҷ� �޼ҵ带 �ҷ������ ��. get~()
			//select�� ����� �� ����Ÿ�� ��ü��� �̸��� �ٸ��� null������ ��µ�.
		}
	}
}
