import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class   check_extension
{
	//컴포넌트 생성
	protected static Object memberinfo;
	protected static Object membermanagememnt;
	JFrame jFrame = new JFrame("연장");
	JLabel check = new JLabel("연장이 되었습니다.");
	JButton btn1 = new JButton("확인");
	
	
	
	public  check_extension()
	{
		//컴포넌트를 넣을 컨테이너 구하기
		Container container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
		//컴포넌트를 컨테이너에 추가
		container.add(check);
		container.add(btn1);
		

		
		jFrame.setSize(500, 300);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn1.addActionListener(new ActionListener() {//반납
			
			 public void actionPerformed(ActionEvent e) {
				 jFrame.dispose();
					new loginandnewmember();
					
			 } 
	         
			});
		 
		//종료 버튼 설정
		
		}public static void main(String[] args)
	{
		//실행
		new check_extension();
	}

}

