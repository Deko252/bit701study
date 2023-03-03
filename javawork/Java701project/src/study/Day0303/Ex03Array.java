package study.Day0303;

import java.util.Iterator;

public class Ex03Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = {34, 56, 78, 100, 39};
		double [] arr2 = {1.2, 5.6 ,7.8, 12.89, 10.9};
		System.out.println(arr1.length);
		System.out.println(arr2.length);
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.printf("%5d",arr1[i]);
		}
		System.out.println("");
		for(int a:arr1) {
			System.out.printf("%5d",a);
		}
		System.out.println("");
		System.out.println("=".repeat(30));
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.printf("%4.1f",arr2[i]);
		}
		System.out.println("");
		for(double a:arr2) {
			System.out.printf("%4.1f",a);
		}
		System.out.println("");
		System.out.println("=".repeat(30));
	}

}
