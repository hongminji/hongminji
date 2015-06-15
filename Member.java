import java.io.Serializable;

public class Member implements Serializable{
	private String id;
	private String brithday;
	private String address;
	private  String name;
	public Member(String name,String id,  String address, String brithday){
		this.id = id;
		this.name = name;
		this.address = address;
		this.brithday = brithday;
	
	}public String getid(){
		return id;
	}public  String getaddress(){
		return address;
	}public String getname(){
		return name;
	}public String getbrithday(){
		return brithday;

	}public void setid(String id){
		this.id=id;
	}public void setaddress( String address){
		this.address=address;
	}public void setname(String name){
		this.name=name;
	}public void setbrithday(String brithday){
		this.brithday=brithday;
	}
   
   
}

