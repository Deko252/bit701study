package study.Day0313;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex03SwingButton extends JFrame{

	JButton btn1 = new JButton("버튼1");
	JButton btn2;
	JLabel lblMessage;
	
	public Ex03SwingButton(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//단순히 윈도우만 종료하고 싶을때는 메서드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컴포넌트 생성 및 이벤트 설정라기 위한 메서드
		this.initDesign();
		
		this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 300, 300);// x, y, w, h
		this.setVisible(true);		
	}
	
	private void initDesign() {
		// TODO Auto-generated method stub
		
		//버튼, 체크박스 등등을 컴포넌트라 부른다
		//버튼을 추가할 프레임이나 다이얼로그 등을 컨테이너라 부른다
		
		//컴포넌트를 컨테이너에 추가하는 메서드 add를 통해서 부착한다
		//기본 레이아웃이 설정:BorderLayout -상,하,좌,우,센터
		
		//this.add("North",btn1);
		this.add(btn1, BorderLayout.NORTH);
		
		btn2 = new JButton("버튼2");
		//this.add("South",btn2);
		this.add(btn2, BorderLayout.SOUTH);
		
		//center 에는 라벨을 생성해서 넣어보자
		lblMessage = new JLabel("Have a Nice Day", JLabel.CENTER);
		lblMessage.setOpaque(true);//불투명 모드, 기본은 false:투명모드
		lblMessage.setBackground(new Color(240, 240, 0));//라벨 배경색
		lblMessage.setForeground(Color.red);//라벨 글자색
		lblMessage.setFont(new Font("Comic Sans MS", Font.BOLD, 30));//라벨 글꼴
		this.add("Center", lblMessage);
		
		//익명 내부클래스 형태로 버튼 이벤트 주기
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setText("Btn 1 Click!");
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setText("Btn 2 Click!!");
			}
		});
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex03SwingButton("버튼생성");
	}

}
