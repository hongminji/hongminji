


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class studyroom extends JFrame{
	JFrame jFrame = new JFrame("열람실배정");
	JButton btn1 = new JButton("1층 여성전용열람실");
	JButton btn2 = new JButton("2층 남성전용열람실");
	JButton btn3 = new JButton("3층 성인전용열람실");
	JButton btn4 = new JButton("4층 노트북전용열람실");
	studyroomseat a = new studyroomseat(); 
	int studyroom1 = a.studyroom_1;
	int studyroom2 = a.studyroom_2;
	int studyroom3 = a.studyroom_3;
	int studyroom4 = a.studyroom_4;
	


  
 public studyroom(){
	 ArrayList<studyroomlist> st = a.st;
		
		//컴포넌트를 넣을 컨테이너 구하기
		Container container = jFrame.getContentPane();
		container.setLayout(new GridLayout(2,2,5,5));
		//컴포넌트를 컨테이너에 추가
		 studyroomlist temp1 = st.get(0);
		btn1.setText("1층 여성전용열람실:1층 잔여좌석"+temp1.getstudyroom_1()+"/30");
		container.add(btn1);
		btn2.setText("2층 남성전용열람실:2층 잔여좌석"+temp1.getstudyroom_2()+"/40");
		container.add(btn2);
		btn3.setText("3층 성인전용열람실:3층 잔여좌석"+temp1.getstudyroom_3()+"/50");
		container.add(btn3);
		btn4.setText("4층 노트북전용열람실:4층 잔여좌석"+temp1.getstudyroom_4()+"/40");
		container.add(btn4);
		

		
		jFrame.setSize(600, 600);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn1.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 
				
					// TODO
				 jFrame.dispose();
				 new studyroom_1();
					
					
			 }
	         
			});
		btn2.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 
				
					// TODO
				 jFrame.dispose();
				 new studyroom_2();
					
					
			 }
	         
			});
		btn3.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 
				
					// TODO
				 jFrame.dispose();
				 new studyroom_3();
					
					
			 }
	         
			});
		btn4.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 
				
					// TODO
				 jFrame.dispose();
					new studyroom_4();
					
					
			 }
	         
			});
		
 
 }

 public static void main(String[] ar){
  new studyroom();
 }
}

