package study.Day0310;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex08ListShopFile {

	static final String FILENAME = "c:/Bit701naver/shop.txt";
	
	List<ShopDTO> list = new Vector<>();
	Scanner sc = new Scanner(System.in);
	
	public Ex08ListShopFile() {
		// TODO Auto-generated constructor stub
		shopFileRead();
	}
	
	//처음 시작시 파일 읽어서 리스트에 담기
	public void shopFileRead() {
		//프로그램 시작시 파일에서 데이터를 읽어서 리스트에 넣기
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				String [] data = line.split(",");
				//dto에 각각 분리해서 넣은후 다시 list에 담기
				ShopDTO dto = new ShopDTO();
				dto.setSangpum(data[0]);
				dto.setSu(Integer.parseInt(data[1].trim())); // , 분리후 숫자양쪽의 공백이 있을경우 제거후 숫자로 변환하기
				dto.setDan(Integer.parseInt(data[2]));
				
				list.add(dto);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();					
				}
				if(fr != null) {
					fr.close();				
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		System.out.println("총" + list.size() + "개 가져옴");
	}
	
	//종료시 list의 데이터를 파일에 저장
	public void shopFileSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			for (ShopDTO dto : list) {
				String s = dto.getSangpum() + "," + dto.getSu() + "," + dto.getDan() + "\n";
				fw.write(s);				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//데이터 추가하는 메서드
	public void dateAdd() {
			System.out.println("추가할 상품을 적어주세요.");
			String sang = (sc.nextLine());
			int su = 0, dan = 0;
			try {
				System.out.println("수량은 ?");
				su = Integer.parseInt(sc.nextLine());				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("수량을 잘못 입력했습니다");
				su = 1;
			}
			try {
				System.out.println("단가는 ?");
				dan = Integer.parseInt(sc.nextLine());				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("단가를 잘못 입력했습니다");
				dan = 1000;
			}
			
			//dto에 값넣기
			ShopDTO dto = new ShopDTO(sang, su, dan);
			//list에 dto넣기
			list.add(dto);
		}
	
	//전체 출력하는 메서드
	public void shopList() {
		System.out.println("번호\t상품\t수량\t단가\t총금액");
		System.out.println("=".repeat(50));
		for (int i = 0; i < list.size(); i++) {
			ShopDTO dto = list.get(i);
			System.out.println(i+1 + "\t" + dto.getSangpum() + "\t" + dto.getSu() + "\t" + dto.getDan() + "\t" + ((int) dto.getSu()*dto.getDan()));
		}
	}
	
	//상품 검색
	public void shopSearch() {
		System.out.println("검색할 상품명을 정확히 입력해주세요.");
		String sang = sc.nextLine();
		
		boolean find = false;
		for (int i = 0; i < list.size(); i++) {
			ShopDTO dto = list.get(i);
			//입력한 상품명으로 시작하는 상품모두출력 startsWith
			//if(dto.getSangpum().startsWith(sang))
			
			//입력한 상품명을 포함한 경우 모두 출력 contains
			if(dto.getSangpum().contains(sang)) {
				find = true;
				System.out.println(i+1 + ":" + dto.getSangpum() + " " + dto.getDan() + "원");
			}
		}
		if(!find) {
			System.out.println("관련 상품은 없습니다.");
		}
	}
	
	//상품 삭제
	public void shopDelet() {
		System.out.println("삭제할 상품명을 정확히 입력해주세요.");
		String sang = sc.nextLine();
		boolean find = false;
		for (int i = list.size()-1; i >= 0; i--) {
			ShopDTO dto = list.get(i);
			if(sang.equals(dto.getSangpum())) {
				find = true;
				list.remove(i);
			}
			
		}
		if(!find) { //find == false
			System.out.println(sang + "상품 목록에 없습니다.");
		}else {
			System.out.println(sang + "삭제 되었습니다.");
		}
		
	}
	
	//메뉴
	public int getMenu() {
		int menu;
		System.out.println(" ** 메뉴 선택 **");
		System.out.println("1.상품 추가 2.상품전체 출력 3.상품검색 4.상품삭제 5.종료");
		try {
			menu = Integer.parseInt(sc.nextLine());			
		} catch (NumberFormatException e) {
			menu = 2; //문자로 잘못 입력시 무조건 전체출력
		}
		return menu;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex08ListShopFile ex = new Ex08ListShopFile();
		while(true) {
			switch(ex.getMenu()) {
			case 1:
				ex.dateAdd();
				break;
			case 2:
				ex.shopList();
				break;
			case 3:
				ex.shopSearch();
				break;
			case 4:
				ex.shopDelet();
				break;
			default:
				ex.shopFileSave();
				System.err.println("데이터 저장후 프로그램 종료");
				System.exit(0);
			}
			System.out.println("=".repeat(50));
		}
	}

}
