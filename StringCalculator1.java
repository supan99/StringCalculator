import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.*;
import java.lang.*;
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
		String str1;
		if(input.contains("-")){
			int index = input.indexOf("-");
			if(Character.isDigit(input.charAt(index+1))){
				throw new NegativeNumberException(index);
			}
		}
		if(Character.isDigit(input.charAt(input.length()-1))){					
			Pattern pattern = Pattern.compile("\\D");
			Matcher matcher = pattern.matcher(input);
		    str1 = matcher.replaceAll(",");
		}else{
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
