package study.Day0309;

import java.io.FileWriter;
import java.io.IOException;

public class Ex09FileWriter {
	static final String FILENAME = "c:/Bit701naver\\memo.txt";
	
	public static void memoWrite() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME, true);//memo.txt가 없을경우 새로 생성, 있을경우 덮어쓰기 , 
			//true는 기존파일에 데이터 추가
			
			fw.write("이름 : 아랄랄\n");
			fw.write("주소 : 서울시 강남구\n");
			fw.write("번호 : 9912-45421-84\n");
			fw.write("========================\n");
			
			System.out.println("파일 탐색기에서 memo.txt를 확인하세요");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		memoWrite();
	}

}
