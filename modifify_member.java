import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  modifify_member
{
	//컴포넌트 생성
	protected static Object memberinfo;
	protected static Object membermanagememnt;
	JFrame jFrame = new JFrame("회원정보 수정");
	JButton btn1 = new JButton("확인");
	JLabel ment = new JLabel("수정 하실 id를 입력해주세요");
	JLabel id = new JLabel("id");
	JTextField tf = new JTextField(7);
	studyroomseat a = new studyroomseat(); 
	public static int num=0;
	public String inputid;
	
	public  modifify_member()
	{
		//컴포넌트를 넣을 컨테이너 구하기
		Container container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
		//컴포넌트를 컨테이너에 추가
		container.add(ment);
		container.add(id);
		container.add(tf);
		
		container.add(btn1);
		
		

		
		jFrame.setSize(500, 300);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn1.addActionListener(new ActionListener() {//반납
			
			 public void actionPerformed(ActionEvent e) {
				 inputid= tf.getText();
					ArrayList<Member> membermanagement = a.membermanagement; 
					ArrayList<Membership>memberinfo = a.memberinfo;
					  int count=0;
						int index=0;
						for(int i=0; i<membermanagement.size();i++){
							Member temp  = membermanagement.get(i);
							System.out.println(temp.getid());
							if(temp.getid().equals(inputid)){
								
								count+=1;
								index=i;
								
							}
						}
						if(count==0){
							
							new Wrong2();
							
						}else{
							count=0;
							System.out.println("들어옴");
							num =index;
							 jFrame.dispose();
							new modifynewmember();
						
					
					}
							 
						
					
				
			 } 
	         
			});
		 
		//종료 버튼 설정
	
		 
		//종료 버튼 설정
		
		}public static void main(String[] args)
	{
		//실행
		new modifify_member();
	}

}




