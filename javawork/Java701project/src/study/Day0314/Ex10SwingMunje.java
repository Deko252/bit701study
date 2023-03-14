package study.Day0314;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex10SwingMunje extends JFrame{
	MyCanvas myCanvas=new MyCanvas();
	JComboBox<String> comboShape;
	JComboBox<String> comboColor;
	
	int shape=2;//0,1,2,3
	Color selectColor=Color.orange;
	Image image;
	String imageName="D:\\bit701naver\\webwork\\image\\moviestar\\18.jpg";
	
	
	public Ex10SwingMunje(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
		//단순히 윈도우만 종료하고 싶을때는 메서드를 통해서 종료하면 된다
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//컴포넌트 생성및 이벤트 설정하기 위한 메서드
		this.initDesign();
		
		//this.getContentPane().setBackground(new Color(200, 200, 200));
		this.setBounds(900, 100, 300, 350);//x,y,w,h
		this.setVisible(true);
	}
	class MyCanvas extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			g.setColor(selectColor);
			
			switch (shape) {
			case 0:
				g.fillOval(100, 100, 130, 130);
				break;
			case 1:
				g.fillRect(100, 100, 130, 130);
				break;
			case 2:
				image=new ImageIcon(imageName).getImage();
				g.drawImage(image, 0, 0, 300, 320, this);
				break;
			case 3:
				g.setFont(new Font("Arial", Font.BOLD, 30));
				g.drawString("Bitcamp 701", 50, 100);
				break;
			default:
				break;
			}
		}
	}
	
	
	private void initDesign() {
		// TODO Auto-generated method stub
		String []shapeArray= {"원","사각형","이미지","문자열"};
		Vector<String> colorList=new Vector<>();
		colorList.add("빨강");
		colorList.add("오렌지");
		colorList.add("핑크");
		colorList.add("초록");
		colorList.add("회색");
		colorList.add("노랑");		
		
		comboShape=new JComboBox<>(shapeArray);
		comboColor=new JComboBox<>(colorList);
		//초기값 지정
		comboShape.setSelectedIndex(2);//이미지로 초기값 지정
		comboColor.setSelectedIndex(1);//오렌지색으로 초기값 지정
		
		JPanel p=new JPanel();
		p.add(comboShape);
		p.add(comboColor);
		
		this.add("North",p);
		this.add("Center",myCanvas);
		
		//combobox 이벤트
		comboShape.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				shape=comboShape.getSelectedIndex();
				myCanvas.repaint();
			}
		});
		
		comboColor.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				switch (comboColor.getSelectedIndex()) {
				case 0:
					selectColor=Color.red;
					break;
				case 1:
					selectColor=Color.orange;
					break;
				case 2:
					selectColor=Color.pink;
					break;
				case 3:
					selectColor=Color.green;
					break;
				case 4:
					selectColor=Color.gray;
					break;
				case 5:
					selectColor=Color.yellow;
					break;
				}
				myCanvas.repaint();
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex10SwingMunje("스윙숙제");
	}
}

