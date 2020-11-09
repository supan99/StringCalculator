import java.util.Scanner;
import java.util.*;
class StringCalculatorKada{
	public static Scanner sc = new Scanner(System.in);
	
	public int Add(String input){
		int sum;
		if(input.equals(" ")|| input.equals("")){
			sum = 0;
		}else{
			String numbers = extractNumbersFromInput(input);
			if(numbers.equals("II")){
			   sum = -1; 
			}else{
				sum = sumOfNumbers(numbers);
			}
		}
		return sum;
	}
	
	private static String extractNumbersFromInput(String input){
		String delimiter = ",";
		StringBuilder sb = new StringBuilder(input);
		if((input.lastIndexOf("\\n")+2)!=input.length()){
			while(sb.indexOf("\\n") > 0 && sb.indexOf("\\n")+2<=(sb.toString().length())){
				int position = sb.indexOf("\\n");
				sb.replace(position,position+2,delimiter);
			}
		}else{
			sb.replace(0,input.length(),"II");
		}
		return sb.toString();
		
	}
	
	private static int sumOfNumbers(String numbers){
		int sum=0;
		StringTokenizer str = new StringTokenizer(numbers,",");
		while(str.hasMoreTokens()){
			sum = sum + Integer.parseInt(str.nextToken());
		}
		return sum;
	}
	
	public static void main(String args[]){
		StringCalculatorKada strCalcKada = new StringCalculatorKada();
		System.out.print("\nEnter String: ");
		String input=sc.next();
		int sum = strCalcKada.Add(input);
		if(sum==-1){
			System.out.println("\nINVALID INPUT"); 
		}else{
			System.out.println(sum);
		}
	}
}