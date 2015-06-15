import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class loginandnewmember
{
	//컴포넌트 생성
	protected static Object memberinfo;
	protected static Object membermanagememnt;
	JFrame jFrame = new JFrame("로그인 첫페이지");
	JButton btn1 = new JButton("로그인");
	JButton btn2 = new JButton("회원가입");
	JButton btn3 = new JButton("회원정보수정");
	JLabel id1 = new JLabel("id");
	JTextField tf = new JTextField(10);
	public String id;
	public static int list_number=0;
	public static int list_number2=0;
	studyroomseat a = new studyroomseat(); 
	public static Calendar now =  Calendar.getInstance();
	public static int ss = now.get(Calendar.HOUR_OF_DAY);
	public static int tt = now.get(Calendar.MINUTE);
	public static int aa = now.get(Calendar.SECOND);

	
	public loginandnewmember()
	{
		
		ArrayList<Member> membermanagement = a.membermanagement; 
		
		ArrayList<Membership> memberinfo = a.memberinfo; 
		
		
		ArrayList<studyroomlist> st = a.st;
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

		//컴포넌트를 넣을 컨테이너 구하기
		Container container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
		//컴포넌트를 컨테이너에 추가
		container.add(id1);
		container.add(tf);
		
		container.add(btn1);
		container.add(btn2);
		container.add(btn3);
		
		//프레임 크기 지정
		jFrame.setSize(500, 300);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		
		//종료 버튼 설정
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn2.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 
				
					// TODO
				 jFrame.dispose();
					new newmember();
					
					
			 }
	         
			});
			btn1.addActionListener(new ActionListener() {
				
				 public void actionPerformed(ActionEvent e) {
					 System.out.println("들어옴");
					 
						ArrayList<Member> membermanagement = a.membermanagement; 
						
						ArrayList<Membership> memberinfo = a.memberinfo; 
						
						
						
					      id = tf.getText();
					     
					     System.out.println(membermanagement.size());
						int memberinfoindex=0;
					    int count=0;
						int index=0;
						for(int i=0; i<membermanagement.size();i++){
							Member temp  = membermanagement.get(i);
							System.out.println(temp.getid());
							if(temp.getid().equals(id)){
								
								count+=1;
								index=i;
								
							}
						}
						if(count==0){
							 jFrame.dispose();
							new Wrong();
							
						}else{
							count=0;
							System.out.println("들어옴");
							for(int i=0; i<memberinfo.size();i++){
								
								Membership temp1  = memberinfo.get(i);
								System.out.println(temp1.getid());
								
								if(temp1.getid().equals(id)){
									
									count+=1;
									memberinfoindex=i;
									
	 							}
							}if(count==0){
								memberinfo.add(new Membership(id,"0","0","0"));
								int list_number2 = (memberinfo.size()-1);
								System.out.println(list_number2);
								 jFrame.dispose();
								new studyroom();
								
							}else{
								list_number=memberinfoindex;
								 jFrame.dispose();
								new returnorextension();
								
							}
						
					
					}
							 
							
						
				 }
				});
				
			btn3.addActionListener(new ActionListener() {
				
				 public void actionPerformed(ActionEvent e) {
					 
					
						// TODO
					 jFrame.dispose();
						new modifify_member();
						
						
				 }
		         
				});
			}
	
	

	public static void main(String[] args)
	{
		//실행
		new loginandnewmember();
	}

}

