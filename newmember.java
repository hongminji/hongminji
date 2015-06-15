

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class newmember
{
	//컴포넌트 생성
	protected static Object memberinfo;
	protected static Object membermanagememnt;
	modifify_member c = new modifify_member(); 
	JFrame jFrame = new JFrame("회원가입");
	JButton btn1 = new JButton("확인");
	studyroomseat a = new studyroomseat();
    ArrayList<Member> membermanagement = a.membermanagement; 
	
	public newmember(){
		
		 
		ArrayList<Member> membermanagement = a.membermanagement; 
		ArrayList<Membership>memberinfo = a.memberinfo;
		Container container = jFrame.getContentPane();
		container.setLayout(new GridLayout(5,2));
		 container.add(new JLabel("이름"));
		  final JTextField name1 = new JTextField(7);
		  container.add(name1);

		  container.add(new JLabel("id"));
		  final JTextField id2 = new JTextField(7);
		  container.add(id2);
		  

		  container.add(new JLabel("주소"));
		  final JTextField address3 = new JTextField(7);
		  container.add(address3);
		 

		  container.add(new JLabel("생년월일"));
		  final JTextField brithday4 = new JTextField(7);
		  container.add(brithday4);


		  JButton check = new JButton("확인");
		  container.add(check);
		
		
		
		
		
		jFrame.setSize(500, 300);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		
		//종료 버튼 설정
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		check.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
					FileWriter fw;
					try {
						int count=0;
						String name = name1.getText();
						 String id = id2.getText();
						 String address = address3.getText();
						 String brithday= brithday4.getText();
						 studyroomseat a = new studyroomseat(); 
							ArrayList<Member> membermanagement = a.membermanagement; 
							ArrayList<Membership> memberinfo = a.memberinfo; 
							for(int i=0;i<membermanagement.size();i++){
								Member temp = membermanagement.get(i);
								if(id.equals(temp.getid())){
									count+=1;
								}
								
							}if(count==0){
											membermanagement.add(new Member(name,id,address,brithday));
											System.out.println("회원가입이 되었습니다!");
										
											fw = new FileWriter("membermanagement.txt");
											for(int i=0;i<membermanagement.size();i++)
										       { 
										    	   	Member temp = membermanagement.get(i);
										    	   	fw.write(temp.getname()+",");
										    		fw.write(temp.getid()+",");
										    		fw.write(temp.getaddress()+",");
										    		fw.write(temp.getbrithday());
										    		fw.write("\n");
										    	   	
									    	   
									       } 
				
									       fw.close(); 
									       
									       
									       
									       jFrame.dispose();
									       new welcomnewmember();
							}else{
								 jFrame.dispose();
								new overlapid();	
								
							}
						}catch (Exception e1) {
								System.out.println(e1.getMessage());
							}
							}
					
	 		});
			
			 }
		
	  public static void main(String[] args)
	{
		//실행
		new newmember();
	}

}



