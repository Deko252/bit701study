package study.Day0313;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex05Canvas extends JFrame{
	//내부클래스인 MyDraw를 생성
	MyDraw draw = new MyDraw(); 
	
	//사각형의 초기 색상
	Color initColor = new Color(126,132,247);
	
	public Ex05Canvas(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//단순히 윈도우만 종료하고 싶을때는 메서드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컴포넌트 생성 및 이벤트 설정라기 위한 메서드
		this.initDesign();
		
		//this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 500, 500);// x, y, w, h
		this.setVisible(true);		
	}
	
	//Canvas를 상속받는 내부 클래스
	class MyDraw extends Canvas{
		String imgPath1="C:\\Bit701Naver\\webwork\\image\\animal\\C1.png";
		String imgPath2="C:\\Bit701Naver\\webwork\\image\\animal\\C8.png";
		@Override
		public void paint(Graphics g) {//처음 생성시 자동호출, 강제호출 repaint()
			// TODO Auto-generated method stub
			//System.out.println("paint 호출");
			super.paint(g);
			
			g.setColor(Color.magenta);
			g.drawOval(30, 30, 100, 100);
			
			g.setColor(Color.pink);
			g.fillOval(150, 30, 100, 100);
			
			g.setColor(initColor);
			g.fillRect(270, 180, 120, 150);
			
			g.drawRect(50,180,100,100);
			
			//캔버스에 이미지를 그리는 두가지 방법
			Image img = new ImageIcon(imgPath1).getImage();
			g.drawImage(img, 30, 300, 100, 100, this);
			
			Image img2 = Toolkit.getDefaultToolkit().getImage(imgPath2);
			g.drawImage(img2, 350, 30, 100, 100, this);
			
		}
	}
	
	private void initDesign() {
		// TODO Auto-generated method stub
		//center 에 draw 추가
		this.add("Center",draw);
		
		JPanel p = new JPanel();
		
		
		JRadioButton rb1 = new JRadioButton("시안",true);
		JRadioButton rb2 = new JRadioButton("초록",true);
		JRadioButton rb3 = new JRadioButton("오렌지",true);
		
		//Radio 버튼 3개를 그룹으로 묶는다
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		//패널에 추가
		p.add(rb1);
		p.add(rb2);
		p.add(rb3);
		
		this.add("North", p);
		
		//라디오 버튼 이벤트는 익명 내부 클래스 형태로 만들어보자
		
		rb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//색상변경
				initColor = new Color(22,239,112);
				//캔버스의 paint강제 호출
				draw.repaint();
			}
		});
		
		rb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//색상변경
				initColor = Color.orange;
				//캔버스의 paint강제 호출
				draw.repaint();
			}
		});
		
		rb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//색상변경
				initColor = new Color(126,132,247);
				//캔버스의 paint강제 호출
				draw.repaint();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex05Canvas("Canvas");
	}

}
