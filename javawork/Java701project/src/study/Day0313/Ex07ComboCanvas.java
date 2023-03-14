package study.Day0313;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import study.Day0313.Ex07ComboCanvas.MyPhoto;

public class Ex07ComboCanvas extends JFrame{

	MyPhoto my = new MyPhoto();
	Image image;
	String imgName = "C:\\Bit701Naver\\webwork\\image\\moviestar\\19.jpg";
	JComboBox<String> combo;
	
	public Ex07ComboCanvas(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//단순히 윈도우만 종료하고 싶을때는 메서드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컴포넌트 생성 및 이벤트 설정라기 위한 메서드
		this.initDesign();
		
		this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 300, 400);// x, y, w, h
		this.setVisible(true);		
	}
	
	private void initDesign() {
		// TODO Auto-generated method stub
		
		image = new ImageIcon(imgName).getImage();
		
		this.add("Center",my);//canvas
		
		String []data = {"수지","신세경","박보영","강동원","신민아","유아인"};
		combo = new JComboBox<>(data);
		JPanel p = new JPanel();
		p.add(combo);
		this.add("North",p);
		
		//combo 이벤트
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(combo.getSelectedIndex());
//				System.out.println(combo.getSelectedItem());
				
				switch(combo.getSelectedIndex()) {
				case 0 :
					imgName="C:\\Bit701Naver\\webwork\\image\\moviestar\\19.jpg";
					break;
				case 1 :
					imgName="C:\\Bit701Naver\\webwork\\image\\moviestar\\18.jpg";
					break;
				case 2 :
					imgName="C:\\Bit701Naver\\webwork\\image\\moviestar\\12.jpg";
					break;
				case 3 :
					imgName="C:\\Bit701Naver\\webwork\\image\\moviestar\\9.jpg";
					break;
				case 4 :
					imgName="C:\\Bit701Naver\\webwork\\image\\moviestar\\17.jpg";
					break;
				case 5 :
					imgName="C:\\Bit701Naver\\webwork\\image\\moviestar\\20.jpg";
					break;
					
				}
				
				//image 얻기
				image = new ImageIcon(imgName).getImage();
				//paint 호출
				my.repaint();
			}
		});
	}
	
	class MyPhoto extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);

			//문자열 출력
			g.drawImage(image, 0, 0, 300, 400, this);
			g.setFont(new Font("Impact",Font.ITALIC|Font.BOLD,35));
			g.setColor(Color.yellow);
			
			//이미지 그리기
			g.drawString("BitCamp 701 Class", 50, 200);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex07ComboCanvas("이미지 선택");
		}

}
