import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class  noextension_check
{
	//컴포넌트 생성
	protected static Object memberinfo;
	protected static Object membermanagememnt;
	JFrame jFrame = new JFrame("연장");
	JLabel wrong = new JLabel("연장될 시간이 아직 되지 않았습니다. 잠시만 기달려주세요");
	JButton btn1 = new JButton("확인");
	
	
	public noextension_check(){
		//컴포넌트를 넣을 컨테이너 구하기
		Container container = jFrame.getContentPane();
		container.setLayout(new FlowLayout());
		//컴포넌트를 컨테이너에 추가
		container.add(wrong);
		container.add(btn1);
		
		
		

		
		
		jFrame.setSize(500, 300);
		
		//프레임 보이기 설정
		jFrame.setVisible(true);
		
		//종료 버튼 설정
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn1.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 
				
					// TODO
				 jFrame.dispose();
					new loginandnewmember();
					
					
			 }
	         
			});
		
	}public static void main(String[] args)
	{
		//실행
		new noextension_check();
	}

}


