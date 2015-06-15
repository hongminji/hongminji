import java.io.Serializable;


public class Membership implements Serializable{
	private String id;
	private String studyroom;
	private String seatnumber;
	private  String time;
	public Membership(String id,String seatnumber,  String studyroom, String time){
		this.id = id;
		this.studyroom= studyroom;
		this.seatnumber = seatnumber;
		this.time =time;
	
	}public String getid(){
		return id;
	}public  String getseatnumber(){
		return seatnumber;
	}public String gettime(){
		return time;
	}public String getstudyroom(){
		return studyroom;

	}public void setid(String id){
		this.id=id;
	}public void setseatnumber( String seatnumber){
		this.seatnumber=seatnumber;
	}public void settime(String time){
		this.time=time;
	}public void setstudyroom(String studyroom){
		this.studyroom=studyroom;
	}
   
   
}
