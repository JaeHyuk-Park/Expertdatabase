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
			System.out.println("1.성적입력 2.성적 전체출력 3.성적 개별출력 4.정보 전체삭제 5.정보 개별삭제 6.종료");
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
				System.out.println("시스템이 종료되었습니다."); break;
			}else{
				System.out.println("다시 선택해주세요.");
			}
		}	
	}
}
