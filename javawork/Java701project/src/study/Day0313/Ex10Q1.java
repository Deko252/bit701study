package study.Day0313;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.net.ssl.ExtendedSSLSession;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex10Q1 extends JFrame {
	// MyPhoto my = new MyPhoto();
	Image image;
	String imgName = "C:\\Bit701Naver\\webwork\\image\\moviestar\\19.jpg";
	JComboBox<String> combo1;
	JComboBox<String> combo2;
	Color initColor = new Color(0, 0, 0);
	Draw draw = new Draw();
	int write = 7;

	public Ex10Q1(String title) {
		// TODO Auto-generated constructor stub
		super(title);

		// 단순히 윈도우만 종료하고 싶을때는 메서드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 컴포넌트 생성 및 이벤트 설정라기 위한 메서드
		this.initDesign();

		this.getContentPane().setBackground(new Color(230, 230, 230));
		this.setBounds(900, 100, 500, 500);// x, y, w, h
		this.setVisible(true);
	}

	private void initDesign() {
		// TODO Auto-generated method stub
		String[] data1 = { "원", "사각형", "사진", "문자열" };
		String[] data2 = { "빨강", "파랑", "노랑", "초록" };
		combo1 = new JComboBox<>(data1);
		combo2 = new JComboBox<>(data2);
		JPanel p = new JPanel();
		p.add(combo1);
		p.add(combo2);
		this.add("North", p);
		this.add("Center", draw);

	
	//combo 이벤트
			combo1.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {

					switch(combo1.getSelectedIndex()) {
					case 0 :
						write = 0;
						break;
					case 1 :
						write = 1;
						break;
					case 2 :
						write = 2;
						break;
					case 3 :
						write = 3;
						break;
					}
					
					
					//image 얻기
					image = new ImageIcon(imgName).getImage();
					//paint 호출
					draw.repaint();
				}
			});
			//combo 이벤트
			combo2.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
//					System.out.println(combo.getSelectedIndex());
//					System.out.println(combo.getSelectedItem());
					switch(combo2.getSelectedIndex()) {
					case 0 :
						//색상변경
						initColor = Color.red;
						//캔버스의 paint강제 호출
						draw.repaint();
						break;
					case 1 :
						//색상변경
						initColor = Color.blue;
						//캔버스의 paint강제 호출
						draw.repaint();
						break;
					case 2 :
						//색상변경
						initColor =Color.yellow;
						//캔버스의 paint강제 호출
						draw.repaint();
						break;
					case 3 :
						//색상변경
						initColor =Color.green;
						//캔버스의 paint강제 호출
						draw.repaint();
						break;
					}
					//paint 호출
					draw.repaint();
				}
			});
	}
	
	
	

	class Draw extends Canvas{
		public void paint(Graphics g) {
			switch(write) {
			case 0 :
				g.setColor(initColor);
				g.fillOval(170, 200, 150, 150);
				break;
			case 1 :
				g.setColor(initColor);
				g.fillRect(170, 200, 150, 150);
				break;
			case 2 :
				g.drawImage(image, 170, 200, 150, 150, this);
				break;
			case 3 :
				g.setColor(initColor);
				g.setFont(new Font("Impact",Font.ITALIC|Font.BOLD,35));
				g.drawString("Holly Molly", 150, 300);
				break;
			}	
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex10Q1("Q1");
	}

}
