package dto;

public class CommonDataType {
	public String hakbun, identify;
	public int score1, score2;

	//Source �޴� �ȿ� Generate Getter and Setter ������ �Ʒ� ���� ���� ��.
	//XML���� Ȱ���� �� ����ϴ� ���.
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	
	
}
