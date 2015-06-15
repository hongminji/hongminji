import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.SwingWorker;




public class studyroomseat {
	public static ArrayList<Membership> memberinfo = new ArrayList<>();
	public static  ArrayList<Member> membermanagement = new ArrayList<>();
	public static  ArrayList<studyroomlist> st = new ArrayList<>();
	public Scanner s = new Scanner(System.in);
	public String studyroomname[] = {"여성전용열람실","남성전용열람실","성인전용열람실","노트북전용열람실"};
	public static int studyroom_1=30;
	public static int studyroom_2=40;
	public static int studyroom_3=50;
	public static int studyroom_4=40;
	
	
	public static Calendar now =  Calendar.getInstance();
	public static int ss = now.get(Calendar.HOUR_OF_DAY);
	public static int tt = now.get(Calendar.MINUTE);
	public static int aa = now.get(Calendar.SECOND);

	
	public  static void main(String[] args) throws IOException {
		
		
			st.add(new studyroomlist(30,40,50,40));

		
			try{
				BufferedReader br = new BufferedReader(new FileReader("membermanagement.txt"));
				String str;
				
				int k=0;
				while((str = br.readLine())!=null){
					String list[] = str.split(",");
					membermanagement.add(new Member(list[0],list[1],list[2],list[3]));
				}
			}catch(Exception ex){
			}
			for(int i=0;i<membermanagement.size();i++){
				Member temp = membermanagement.get(i);
				System.out.println(temp.getid());
				}
			
		
			
			
			try{
				BufferedReader br = new BufferedReader(new FileReader("member.txt"));
				String str;
				
				int k=0;
				while((str = br.readLine())!=null){
					String list[] = str.split(",");
					
					memberinfo.add(new Membership(list[0],list[1],list[2],list[3]));
				}
			}catch(Exception ex){
			}
			
			for(int i=0;i<memberinfo.size();i++){
				Membership temp = memberinfo.get(i);
				System.out.println(temp.getid());
		
			}
			for(int i=0;i<memberinfo.size();i++){
				
				Membership temp  = memberinfo.get(i);
				System.out.println(temp.getstudyroom());
				studyroomlist temp1 = st.get(0);
				if(temp.getstudyroom().equals("여성전용열람실")){
					
					int k=(temp1.getstudyroom_1()-1);
					temp1.setstudyroom_1(k);
				}else if(temp.getstudyroom().equals("남성전용열람실")){
					int k=(temp1.getstudyroom_2()-1);
					temp1.setstudyroom_2(k);
					
				}else if(temp.getstudyroom().equals("성인전용열람실")){
					
					int k=(temp1.getstudyroom_3()-1);
					temp1.setstudyroom_3(k);
				}else if(temp.getstudyroom().equals("노트북전용열람실")){
					int k=(temp1.getstudyroom_4()-1);
					temp1.setstudyroom_4(k);
				}else{
					System.out.print("");
				}
			}
			
				for(int i=0;i<memberinfo.size();i++){
					Membership temp = memberinfo.get(i);
					String list[]=temp.gettime().split(":");
					int hour = Integer.valueOf(list[0]);
					int minute = Integer.valueOf(list[1]);
					int second = Integer.valueOf(list[2]);
					int time = (hour*60)+minute+second;
					int now_time= ss*60+tt+aa;
					int length =(now_time-time);
					if(length>=180){
						studyroomlist temp1 = st.get(0);
						if(temp.getstudyroom().equals("여성전용열람실")){
							memberinfo.remove(i);
							int k=(temp1.getstudyroom_1()+1);
							temp1.setstudyroom_1(k);
						}else if(temp.getstudyroom().equals("남성전용열람실")){
							memberinfo.remove(i);
							int k=(temp1.getstudyroom_2()+1);
							temp1.setstudyroom_2(k);
						}else if(temp.getstudyroom().equals("성인전용열람실")){
							memberinfo.remove(i);
							int k=(temp1.getstudyroom_3()+1);
							temp1.setstudyroom_3(k);
						}else{
							memberinfo.remove(i);
							int k=(temp1.getstudyroom_4()+1);
							temp1.setstudyroom_4(k);
						}		
						
						
					}	
				}


			
				
				
				
			new loginandnewmember();
		
	}	
		
	
}