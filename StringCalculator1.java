import java.util.Scanner;
import java.util.*;
class InvalidInputFormat extends Exception{
	String msg;
	InvalidInputFormat(String msg){
		this.msg = msg;
	}
	public String toString(){
		return this.msg;
	}
}
class NegativeNumberException extends Exception{
	int value;
	NegativeNumberException(int value){
		this.value=value;
	}
	public String toString(){
		return "Number " + this.value +" is less than zero";
	}
}
class StringCalculatorKada{
	public static Scanner sc = new Scanner(System.in);
	
	public int Add(String input){
		int sum=-1;
		if(input.equals(" ")){
			sum = 0;
		}else{
			try{
				String numbers = extractNumbersFromInput(input);
				sum = sumOfNumbers(numbers);
			}catch(InvalidInputFormat msg){
				System.out.println(msg);
			}catch(NegativeNumberException msg){
				System.out.println("NEGATIVES NOT ALLOWED");
			}			
		}
		return sum;
	}
	
	private static String extractNumbersFromInput(String input)throws InvalidInputFormat{
		String delimiter = ",";
		StringBuilder sb = new StringBuilder(input);
		if((input.lastIndexOf("\\n")+2)!=input.length()){
			while(sb.indexOf("\\n") > 0 && sb.indexOf("\\n")+2<=(sb.toString().length())){
				int position = sb.indexOf("\\n");
				sb.replace(position,position+2,delimiter);
			}
		}else{
			throw new InvalidInputFormat("INVALID INPUT");
		}
		return sb.toString();
		
	}
	
	private static int sumOfNumbers(String numbers)throws NegativeNumberException{
		int sum=0;
		StringTokenizer str = new StringTokenizer(numbers,",");
		while(str.hasMoreTokens()){
			int value = Integer.parseInt(str.nextToken());
			if(value < 0){
				throw new NegativeNumberException(value);
			}
			if(value <= 1000){
				sum += value ;
			}
		}
		return sum;
	}
	
	public static void main(String args[]){
		StringCalculatorKada strCalcKada = new StringCalculatorKada();
		System.out.print("\nEnter String: ");
		String input=sc.next();
		int sum = strCalcKada.Add(input);
		if(sum >=0){	
			System.out.println(sum);
		}
	
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
class NegativeNumberException extends Exception{
	int msg;
	NegativeNumberException(int msg){
		this.msg = msg;
	}
	public String toString(){
		return ("\nNEGATIVE VALUES NOT ALLOWED");
	}
}
class InvalidInputFormat extends Exception{
	String msg;
	InvalidInputFormat(String msg){
		this.msg = msg;
	}
	public String toString(){
		return ("\nINVALID INPUT");
	}
}
class StringCalculatorKada{
	public static Scanner sc = new Scanner(System.in);
	
	public int Add(String input){
		int sum=-1;
		if(input.equals(" ")){
			sum = 0;
		}else{
			try{
				String numbers = extractNumbersFromInput(input);
				sum = sumOfNumbers(numbers);
			}catch(InvalidInputFormat msg){
				System.out.println(msg);
			}catch(NegativeNumberException msg){
				System.out.println(msg);
			}			
		}
		return sum;
	}
	
	private static String extractNumbersFromInput(String input)throws NegativeNumberException,InvalidInputFormat{
		String delimiter = ",";
		StringBuilder str1 = new StringBuilder(input);
		if(input.contains("-")){
			int index = input.indexOf("-");
			if(Character.isDigit(input.charAt(index+1))){
				throw new NegativeNumberException(index);
			}
		}if((input.lastIndexOf("\\n")+2)!=input.length()){
			while(str1.indexOf("\\n") > 0 && str1.indexOf("\\n")+2<=(str1.toString().length())){
				int position = str1.indexOf("\\n");
				String str = str1.replace(position,position+2,delimiter).toString();
			}
		}
		else{
			throw new InvalidInputFormat("INVALID INPUT");
		}
		return str1;
	}
	private static int sumOfNumbers(String numbers)throws NegativeNumberException{
		int sum=0;
		StringTokenizer str = new StringTokenizer(numbers,", ");
		while(str.hasMoreTokens()){
			int value = Integer.parseInt(str.nextToken());
			if(value <= 1000){
				sum += value ;
			}
		}
		return sum;
	}
	
	public static void main(String args[]){
		StringCalculatorKada strCalcKada = new StringCalculatorKada();
		System.out.print("\nEnter String: ");
		String input=sc.next();
		int sum = strCalcKada.Add(input.toLowerCase());
		if(sum >=0){	
			System.out.println("\nSUM : " +sum);
		}
	}
}
