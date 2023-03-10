package study.Day0310;
/*
 * [문제]-파일입출력,컬렉션 
EmpDto
    이름,부서,나이,핸드폰

 **  메뉴 **
사원추가
사원검색 - 이름,부서,나이,핸드폰 모두 출력
사원삭제
부서명 검색 - 부서별로 출력
전체출력
종료

 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Emp {

	static final String FILENAME = "c:/Bit701naver/EmpDto.txt";
	Scanner sc = new Scanner(System.in);
	List<EmpDto> list = new Vector<>();

	private Emp() {
		// TODO Auto-generated method stub
		EmpDtoFileRead(); // 처음 시작시 실행
	}

	// 처음 시작시 읽어옴
	private void EmpDtoFileRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);//
			while (true) {
				String line = br.readLine(); // 한줄씩 검사
				if (line == null) { // 한줄씩 검사 할때 null이면 == 파일 내용이 끝나면
					break;
				}
				String[] data = line.split(","); // , 를 구분자로 사용하여 배열 구분 후 data에 담기
				// dto에 각각 분리해서 넣은후 다시 list에 담기
				EmpDto dto = new EmpDto(); // 새로운 DTO 생성후 담기
				dto.setName(data[0]);// EmpDto 에게 해당 값 저장시키기
				dto.setBu(data[1]);
				dto.setAge(Integer.parseInt(data[2].trim()));// , 분리후 숫자양쪽의 공백이 있을경우 제거후 숫자로 변환하기
				dto.setNum(Integer.parseInt(data[3].trim()));

				list.add(dto);// dto값 리스트에 담기
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		System.out.println("총" + list.size() + "개 가져옴");

	}

	private void EmpDtoFileSave() {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			for (EmpDto dto : list) {
				String s = dto.getName() + "\t" + dto.getBu() + "\t" + dto.getAge() + "\t" +  dto.getNum() + "\n";
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

	private void EmpDtoFileAdd() {
		// TODO Auto-generated method stub
		System.out.println("추가할 사원 이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("사원의 부서명을 입력해주세요");
		String bu = sc.nextLine();
		int age = 0, num = 0;

		Age: while (true) {
			try {
				System.out.println("사원의 나이를 입력해주세요");
				age = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("똑바로 입력하세요");
				continue Age;
			}
			break;
		}
		Num: while (true) {
			try {
				System.out.println("사원의 휴대폰 번호를 입력해 주세요(-뺴고 입력하세요)");
				num = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("똑바로 입력하세요");
				continue Num;
			}
			break;
		}
		// dto에 값넣기
		EmpDto dto = new EmpDto(name, bu, age, num);
		// list에 dto넣기
		list.add(dto);
	}

	private void EmpDtoList() {
		// TODO Auto-generated method stub
		System.out.println("번호\t이름\t부서\t나이\t핸드폰");
		System.out.println("=".repeat(50));
		for (int i = 0; i < list.size(); i++) {
			EmpDto dto = list.get(i);
			System.out.println(i+1 + "\t" + dto.getName() + "\t" + dto.getBu() + "\t" + dto.getAge() + "\t 0" +  dto.getNum());
		}
	}

	private void EmpDtoSearch() {
		// TODO Auto-generated method stub
		System.out.println("검색할 사원명을 입력해 주세요.");
		String name = sc.nextLine();
		int n = 0;
		for (int i = 0; i < list.size(); i++) {
			EmpDto dto = list.get(i);
			if(dto.getName().contains(name)) {
				n = 1;
				System.out.println(i+1 + "\t" + dto.getName() + "\t" + dto.getBu() + "\t" + dto.getAge() + "\t 0" +  dto.getNum());
			}
		}
		if(n == 0) {
			System.out.println("해당 이름을 가진 사원은 없습니다.");
		}
	}

	private void EmpDtoBuSearch() {
		// TODO Auto-generated method stub
		System.out.println("검색할 부서명을 입력해 주세요.");
		String bu = sc.nextLine();
		int n = 0;
		for (int i = 0; i < list.size(); i++) {
			EmpDto dto = list.get(i);
			if(dto.getBu().contains(bu)) {
				n = 1;
				System.out.println(i+1 + "\t" + dto.getName() + "\t" + dto.getBu() + "\t" + dto.getAge() + "\t 0" +  dto.getNum());
			}
		}
		if(n == 0) {
			System.out.println("해당 부서는 없습니다.");
		}
	}

	private void EmpDtoFileDelet() {
		// TODO Auto-generated method stub
		System.out.println("해고할 사원명을 정확히 입력해주세요.");
		String name = sc.nextLine();
		int n = 0;
		for (int i = 0; i < list.size(); i++) {
			EmpDto dto = list.get(i);
			if (name.equals(dto.getName())) {
				n = 1;
				list.remove(i);
			}
		}
		if(n == 1) {
			System.out.println(name + " 사원이 해고 당하였습니다.");
		}else {
			System.out.println("해고할 사원이 없습니다.");
		}

	}

	private int getMenu() {
		int menu;
		System.out.println("++ 메뉴 선택 ++");
		System.out.println("1. 사원 추가 2.사원 검색 3.사원 해고 4.부서명 검색 5.전체출력 6.종료");
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			menu = 5; // 문자로 잘못 입력시 무조건 전체출력
		}
		return menu;
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp q1 = new Emp();
		while (true) {
			switch (q1.getMenu()) {
			case 1:
				q1.EmpDtoFileAdd();
				break;
			case 5:
				q1.EmpDtoList();
				break;
			case 2:
				q1.EmpDtoSearch();
				break;
			case 3:
				q1.EmpDtoFileDelet();
				break;
			case 4:
				q1.EmpDtoBuSearch();
				break;
			default:
				q1.EmpDtoFileSave();
				System.err.println("데이터 저장후 프로그램 종료");
				System.exit(0);
			}
			System.out.println("=".repeat(50));
		}
	}
}
