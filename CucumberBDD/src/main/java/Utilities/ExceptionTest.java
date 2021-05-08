package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest {
	
	
	
	public static void main(String[] args) throws FileNotFoundException  {
		exceeptionMethodLevel();
		
		/*
		 * getSalary(); int a =10, b =0; int c = a/b;
		 * System.out.println("Value of  c  :" + c);
		 */
	}
	
	
	public static void getSalary() {
		
		int a =10, b =0;
		int c =  a/b;
		System.out.println("Value of  c  :"  + c);
		
		
	}
	
	
	public static void exceeptionMethodLevel() throws FileNotFoundException  {
		
		//try{
		File file = new File("config.text");
		FileReader fr = new FileReader(file);
		//System.out.println("Value of  c  :"  + fr);
	
	}}
