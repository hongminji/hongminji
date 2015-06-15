import java.io.Serializable;

public class studyroomlist implements Serializable{
	private int studyroom_1;
	private int studyroom_2;
	private int studyroom_3;
	private int studyroom_4;
	public studyroomlist(int studyroom_1,int studyroom_2,int studyroom_3,int studyroom_4){
		this.studyroom_1 = studyroom_1;
		this.studyroom_2 = studyroom_2;
		this.studyroom_3 = studyroom_3;
		this.studyroom_4 = studyroom_4;
		
	}public  int getstudyroom_1(){
		return studyroom_1;
	}public  int getstudyroom_2(){
		return studyroom_2;
	}public  int getstudyroom_3(){
		return studyroom_3;
	}public  int getstudyroom_4(){
		return studyroom_4;
	}

	public void setstudyroom_1(int studyroom_1){
		this.studyroom_1=studyroom_1;
	}public void setstudyroom_2(int studyroom_2){
		this.studyroom_2=studyroom_2;
	}public void setstudyroom_3(int studyroom_3){
		this.studyroom_3=studyroom_3;
	}public void setstudyroom_4(int studyroom_4){
		this.studyroom_4=studyroom_4;
	}
   
   
}

