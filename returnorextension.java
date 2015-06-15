import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

 














import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class  returnorextension
{
	//컴포넌트 생성
	protected static Object memberinfo;
	protected static Object membermanagememnt;
	JFrame jFrame = new JFrame("반납/연장");
	JButton btn1 = new JButton("반납");
	JButton btn2 = new JButton("연장");
	studyroomseat a = new studyroomseat(); 
	loginandnewmember b = new loginandnewmember(); 
	int studyroom_1 = a.studyroom_1;
	int studyroom_2 = a.studyroom_2;
	int studyroom_3 = a.studyroom_3;
	int studyroom_4 = a.studyroom_4;
	
	public static Calendar now =  Calendar.getInstance();
	public static int ss = now.get(Calendar.HOUR_OF_DAY);
	public static int tt = now.get(Calendar.MINUTE);
	public static int aa = now.get(Calendar.SECOND);
	
	public  returnorextension()
	{
		//컴포넌트를 넣을 컨테이너 구하기
		Container container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
		//컴포넌트를 컨테이너에 추가
		container.add(btn1);
		container.add(btn2);

		
		jFrame.setSize(500, 300);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn1.addActionListener(new ActionListener() {//반납
			
			 public void actionPerformed(ActionEvent e) {
					ArrayList<Member> membermanagement = a.membermanagement; 
					
					ArrayList<Membership> memberinfo = a.memberinfo; 
				 
					 ArrayList<studyroomlist> st = a.st;
					// TODO
				
				 int index = b.list_number; 
				 System.out.println(index);
				 
				 Membership temp = memberinfo.get(index);
				 studyroomlist temp1 = st.get(0);
				
						if(temp.getstudyroom().equals("여성전용열람실")){
							 memberinfo.remove(index);
							 int k=(temp1.getstudyroom_1()+1);
								temp1.setstudyroom_1(k);
						}else if(temp.getstudyroom().equals("남성전용열람실")){
							 memberinfo.remove(index);
							 int k=(temp1.getstudyroom_2()+1);
								temp1.setstudyroom_2(k);
						}else if(temp.getstudyroom().equals("성인전용열람실")){
							 memberinfo.remove(index);
							 int k=(temp1.getstudyroom_3()+1);
								temp1.setstudyroom_3(k);
						}else{
							memberinfo.remove(index);
							 int k=(temp1.getstudyroom_3()+1);
								temp1.setstudyroom_3(k);
						}	
					for(int i=0;i<memberinfo.size();i++){	
						 Membership temp2= memberinfo.get(i);
						 System.out.println(temp2.getid());
					} 
						 String s = "member.txt";
						    File f = new File(s);
						    f.delete(); 
						    try{
						    	FileWriter fw;
								fw = new FileWriter("member.txt");
								for(int i=0;i<memberinfo.size();i++){
							    	   	Membership temp2 = memberinfo.get(i);
							    	   	fw.write(temp2.getid()+",");
							    		fw.write(temp2.getseatnumber()+",");
							    		fw.write(temp2.getstudyroom()+",");
							    		fw.write(temp2.gettime());
							    		fw.write("\n");
								}   	
							    		 fw.close(); 
						       } catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
		


					new check_return();
					
			 } 
	         
			});
		 
		//종료 버튼 설정
		btn2.addActionListener(new ActionListener() {//반납
			
			 public void actionPerformed(ActionEvent e) {
				 int index = b.list_number; 
				 ArrayList<Member> membermanagement = a.membermanagement; 
					
					ArrayList<Membership> memberinfo = a.memberinfo; 
					 Membership temp = memberinfo.get(index);
				 String list[]=temp.gettime().split(":");
					int hour = Integer.valueOf(list[0]);
					int minute = Integer.valueOf(list[1]);
					int second = Integer.valueOf(list[2]);
					int time = (hour*60)+minute+second;
					int now_time= ss*60+tt+aa;
					int length =(now_time-time);
					if(length>=120&&length<180){
						
						String new_time = ((ss)+":"+(tt)+":"+(aa));
						temp.settime(new_time);
						 String s = "member.txt";
						    File f = new File(s);
						    f.delete(); 
						    try{
						    	FileWriter fw;
								fw = new FileWriter("member.txt");
								for(int i=0;i<memberinfo.size();i++){
							    	   	Membership temp1 = memberinfo.get(i);
							    	   	fw.write(temp1.getid()+",");
							    		fw.write(temp1.getseatnumber()+",");
							    		fw.write(temp1.getstudyroom()+",");
							    		fw.write(temp1.gettime());
							    		fw.write("\n");
								}   	
							    		 fw.close(); 
						       } catch (Exception e1) {
									System.out.println(e1.getMessage());
								}
		

						    jFrame.dispose();
						new check_extension();						
					}else{
						 jFrame.dispose();
					   new noextension_check();	
					}
		
					
			 } 
	         
			});
		 
		//종료 버튼 설정
		
		}public static void main(String[] args)
	{
		//실행
		new returnorextension();
	}

}




