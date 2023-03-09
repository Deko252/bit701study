package study.Day0309;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex05FileReaderException {
	
	static final String FILENAME="c:/Bit701naver\\member8.txt";
	public static void memberRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			System.out.println("파일이 존재합니다.");
			
			//한줄단위로 파일을 읽기 위해서 BufferedReader로 변환
			br = new BufferedReader(fr);
			while(true) {
				String name = br.readLine();
				if(name == null || name.length() == 0) {
					break;
				}
				String addr = br.readLine();
				String hp = br.readLine();
				System.out.println("이름 : " + name + ", 주소 : " + addr + ", 핸드폰 : " + hp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다. : " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//파일이 없을경우 br이 생성되기전에 catch로 가면서br이 NullPointerException이 발생
			//방법1
//			try {
//				System.out.println("자원들 모두 닫힘");
//				br.close();
//				fr.close();
//			} catch (IOException|NullPointerException e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//			}
			
			//방법2
			System.out.println("자원들 모두 닫힘");
			try {
				if(br!=null) {
					br.close();					
				}
				if(fr!=null) {
					fr.close();					
				}
			} catch (IOException e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		memberRead();
		System.out.println("정상 종료");
	}

}
