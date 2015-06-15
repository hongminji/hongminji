import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class   modifynewmember
{
	//컴포넌트 생성
	protected static Object memberinfo;
	protected static Object membermanagememnt;
	modifify_member c = new modifify_member(); 
	JFrame jFrame = new JFrame("회원정보수정");
	JButton btn1 = new JButton("확인");
	studyroomseat a = new studyroomseat(); 
	
	public  modifynewmember(){
		 int num =c.num;
		 
		ArrayList<Member> membermanagement = a.membermanagement; 
		ArrayList<Membership>memberinfo = a.memberinfo;
		Container container = jFrame.getContentPane();
		container.setLayout(new GridLayout(5,2));
		Member temp  = membermanagement.get(num);
		
		
		
		
		  container.add(new JLabel("이름"));
		  final JTextField name1 = new JTextField(temp.getname());
		  container.add(name1);

		  container.add(new JLabel("id"));
		  final JTextField id2 = new JTextField(temp.getid());
		  container.add(id2);
		  

		  container.add(new JLabel("주소"));
		  final JTextField address3 = new JTextField(temp.getaddress());
		  container.add(address3);
		 

		  container.add(new JLabel("생년월일"));
		  final JTextField brithday4 = new JTextField(temp.getbrithday());
		  container.add(brithday4);


		  container.add(btn1);

			jFrame.setSize(500, 300);
			
			//프레임 보이기 설정
			jFrame.setVisible(true);
			
			//종료 버튼 설정
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  btn1.addActionListener(new ActionListener() {
				
				 public void actionPerformed(ActionEvent e) {
					 int num =c.num;
					 ArrayList<Member> membermanagement = a.membermanagement; 
					 ArrayList<Membership> memberinfo = a.memberinfo; 
					 Member temp  = membermanagement.get(num);
					 String name = name1.getText();
					 String id = id2.getText();
					 String address = address3.getText();
					 String brithday= brithday4.getText();
					 temp.setname(name);
					 temp.setid(id);
					 temp.setaddress(address);
					 temp.setbrithday(brithday);
					 
					 String s = "membermanagement.txt";
					    File f = new File(s);
					    f.delete(); 
					    try{
					    	FileWriter fw;
							fw = new FileWriter("membermanagement.txt");
							for(int i=0;i<membermanagement.size();i++){
						    	   	Member temp1 = membermanagement.get(i);
						    	   	fw.write(temp1.getname()+",");
						    		fw.write(temp1.getid()+",");
						    		fw.write(temp1.getaddress()+",");
						    		fw.write(temp1.getbrithday());
						    		fw.write("\n");
							}   	
						    		 fw.close(); 
					       } catch (Exception e1) {
								System.out.println(e1.getMessage());
							}
	


						
						
						
						System.out.println("수정되었습니다!");
						
						 jFrame.dispose();
						new modifyok();
					
							
						}
				 
		 		});
				
			
			
		

		
	
			
			
	}public static void main(String[] args)
	{
		//실행
		new modifynewmember();
	}

}


