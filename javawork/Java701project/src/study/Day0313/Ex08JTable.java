package study.Day0313;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex08JTable extends JFrame{
	
	JTable table1,table2,table3;

	public Ex08JTable(String title) {
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
		this.setLayout(new GridLayout(3,1));//3행 1열의 그리드 레이아웃으로 변경
		
		//table 1 생성
		String [] title1 = {"이름","주소","나이"};
		String [][] data1= {{"이지영", "서울", "1세"},{"섹시홍", "머구", "98세"},{"김철수", "역삼", "48세"}};
		table1 = new JTable(data1, title1);
		this.add(table1);//제목이 안나온다
		
		table2 = new JTable(data1, title1);
		this.add(new JScrollPane(table2));//제목을 나오게 하려면JScrollPane을 이용해서 추가
		
		//model을 이용하면 나중에라도 데이터 추가나 삭제가 가능하다
		DefaultTableModel model = new DefaultTableModel(data1, title1);
		table3 = new JTable(data1, title1);
		this.add(new JScrollPane(table3));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex08JTable("Table");
	}

}
