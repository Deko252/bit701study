package study.Day0309;

import java.io.File;
import java.util.Iterator;

public class Ex10File {
	static final String FILE1 = "c:/Bit701naver\\memo.txt";
	static final String FILE2 = "c:/Bit701naver\\score.txt";
	static final String DIR = "c:/Bit701naver";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//File 객체 공부하기
		File file1 = new File(FILE1);
		File file2 = new File(FILE2);
		File file3 = new File(DIR);
		
		System.out.println("file1의 크기 : " + file1.length() + "바이트");
		System.out.println("file2의 크기 : " + file2.length() + "바이트");
		
		System.out.println("file1은 파일인가요 ?" + file1.isFile());//존재하지 않으면 false
		System.out.println("file1은 디렉토리(폴더)인가요 ?" + file1.isDirectory());//존재하지 않으면 false
		
		System.out.println("file3은 파일인가요 ?" + file3.isFile());
		System.out.println("file3은 디렉토리(폴더)인가요 ?" + file3.isDirectory());
		
		if(file3.isDirectory()) {
			String [] list = file3.list();
			for (String a : list) {
				System.out.println(a);
			}
		}
		System.out.println(file1.getAbsolutePath());//파일 경로포함 파일명
		System.out.println(file1.getName());//파일명만
		System.out.println(file1.exists());//file1이 실제 존재하는가
		//파일 삭제
		System.out.println(file1.delete());
	}

}
