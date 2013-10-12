import java.util.Arrays;
import java.util.Scanner;


public class CompareArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Vyvedi razmernost na pyrviq masiv.\nn=");
		int n = input.nextInt();
		System.out.println("Vyvedi razmernost na vtoriq masiv.\nm=");
		int m = input.nextInt();
		char[] array1 = new char[n];
		char[] array2 = new char[m];
		
		int i=0;
		System.out.print("Vyvedi array1: \n");
		while (input.hasNextLine() && i<n)  
		    for (char c : input.nextLine().toCharArray()){  
		        array1[i]=c;
		    	i++;
		    }
		System.out.println(Arrays.toString(array1));
		
		i=0;
		System.out.print("Vyvedi array2: \n");
		while (input.hasNextLine() && i<m)  
		    for (char c : input.nextLine().toCharArray()){  
		        array2[i]=c;
		    	i++;
		    }
		System.out.println(Arrays.toString(array2));
		
		if(n!=m){	
			String x=null;
			for(i=0 ; i<Math.min(n, m); i++){
				if((int) array1[0] < (int)array2[0]){
					x = "array1<array2";
					break;
				}
				if((int) array1[0] > (int)array2[0]){
					x = "array1>array2";
					break;
				}				
				if((int) array1[i] != (int)array2[i]){
					if((int) array1[i] < (int)array2[i]){
						x = "array1<array2";
						break;
					}
					else{
						x = "array1>array2";
						break;
					}
				}
				else{
					if(n<m){
						x = "array1<array2";
					}
					else{
						x = "array1>array2";
					}
				}
			}
			System.out.println(x);
		}
	
		else{
			String x="";
			for(i=0; i<n; i++){
				if((int) array1[0] < (int)array2[0]){
					x = "array1<array2";
					break;
				}
				if((int) array1[0] > (int)array2[0]){
					x = "array1>array2";
					break;
				}
				
				if((int) array1[i] != (int)array2[i]){
					if((int) array1[i] < (int)array2[i]){
						x = "array1<array2";
						break;
					}
					else{
						x = "array1>array2";
						break;
					}
				}
				else{
					x = "array1=array2";
				}
			}
			System.out.println(x);
			
		}
		
	}
}
		
