import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class studyroom_1{
	JFrame jFrame = new JFrame("1층 여성전용열람실");
	JButton[] btn1 = null;
	  static studyroomseat a = new studyroomseat(); 
			static int studyroom_1 = a.studyroom_1;
			static int studyroom_2 = a.studyroom_2;
			static int studyroom_3 = a.studyroom_3;
			static int studyroom_4 = a.studyroom_4;
			public Calendar now =  Calendar.getInstance();
			public int ss = now.get(Calendar.HOUR_OF_DAY);
			public int tt = now.get(Calendar.MINUTE);
			public int aa = now.get(Calendar.SECOND);
			static int index =0;
			
			
	 
	  
	public studyroom_1(){
		 ArrayList<studyroomlist> st = a.st;
		 studyroomlist temp1 = st.get(0);
		Container container = jFrame.getContentPane();
		container.setLayout(new GridLayout(10,6,5,5));
		JLabel notice = new JLabel("*노란색 좌석은 이미 배정된 좌석입니다.");
		JLabel leftseat_1 = new JLabel("1층 여성전용 열람실 잔여좌석");
		JLabel all_leftseat = new JLabel("총 잔여좌석");
		String u = Integer.toString((temp1.getstudyroom_1()+temp1.getstudyroom_2()+temp1.getstudyroom_3()+temp1.getstudyroom_4()));
		JLabel leftseat_all = new JLabel(u);  
		String j = Integer.toString((temp1.getstudyroom_1()));
		JLabel leftseat_F = new JLabel(j);
		btn1 = new JButton[31]; // jbButton 버튼 배열 초기화
		container.add(notice);
		container.add(all_leftseat);
		container.add(leftseat_all);
		container.add(leftseat_1);
		container.add(leftseat_F);
		
		// jbButton에 표기할 값들 적용
		for(int i=1; i<=40; i++) {
			String num = String.valueOf(i);
			btn1[i] = new JButton(num);
			btn1[i].setFont(new Font("굴림", Font.BOLD, 20));
			container.add(btn1[i]);
			MyActionListener listener = new MyActionListener ();
			btn1[i].addActionListener(listener);    
			container.add(btn1[i]);
		}
		
		jFrame.setSize(800, 800);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}class MyActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("들어옴");
				for(int i=1;i<=30;i++){
					if(e.getSource()== btn1[i]){
						ArrayList<Member> membermanagement = a.membermanagement; 
						ArrayList<Membership> memberinfo = a.memberinfo; 
						int num=memberinfo.size()-1;
						Membership temp = memberinfo.get(num);
						String time = ((ss)+":"+(tt)+":"+(aa));
						temp.setstudyroom("여성전용열람실");
						String index1 = Integer.toString(i);
						temp.setseatnumber(index1);
						temp.settime(time);
						ArrayList<studyroomlist> st = a.st;
						 studyroomlist temp1 = st.get(0);
						 int k = (temp1.getstudyroom_2()-1);
						temp1.setstudyroom_2(k);
						btn1[i].setBackground(Color.YELLOW);
						
						System.out.println("좌석 배정이 되었습니다.");
						FileWriter fw;
						try{
							fw = new FileWriter("member.txt");
							for(int j=0;j<memberinfo.size();j++){
						    	   	Membership temp2 = memberinfo.get(j);
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
						 jFrame.dispose();
						new loginandnewmember();
						
					}
					
				}
			
			}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new studyroom_1();
	}
}
