package igraEziTura;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args){
		System.out.print("Kolko igri shte izigraqt igrachite? ");
		Scanner input = new Scanner(System.in);
		
		int broiIgri = input.nextInt();
		
		EziTura firstPerson = new EziTura("Ivan");
		EziTura secondPerson = new EziTura("Pesho");
		EziTura thirdPerson = new EziTura("Misho");
		
		secondPerson.person.start();		
		firstPerson.person.start();		
		thirdPerson.person.start();
		
		firstPerson.run();
		secondPerson.run();
		thirdPerson.run();
		
		try {
			firstPerson.person.join();
			secondPerson.person.join();
			thirdPerson.person.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
		
				
		firstPerson.setTochki(firstPerson.getSreshtaniqEzi());		
		secondPerson.setTochki(secondPerson.getSreshtaniqEzi());		
		thirdPerson.setTochki(thirdPerson.getSreshtaniqEzi());
		
		System.out.print("Ot igra nomer 1" + " "); 
		pobeditel(firstPerson, secondPerson, thirdPerson);
		System.out.println();
		
		for (int i=1; i<broiIgri; i++){
			firstPerson.run();
			secondPerson.run();
			thirdPerson.run();
			
			try {
				firstPerson.person.join();
				secondPerson.person.join();
				thirdPerson.person.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			
			
			firstPerson.setTochki(firstPerson.getSreshtaniqEzi());
			secondPerson.setTochki(secondPerson.getSreshtaniqEzi());
			thirdPerson.setTochki(thirdPerson.getSreshtaniqEzi());
			
			System.out.print("Ot igra nomer " + (i+1) + " "); 
			pobeditel(firstPerson, secondPerson, thirdPerson);
			System.out.println();
		}
		
		System.out.print("Krainiq pobeditel e: "); 
		try {
			kraenPobeditel(firstPerson, secondPerson, thirdPerson);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
		System.out.println();
		System.out.println();
	}
	
	public static void pobeditel(EziTura first, EziTura second, EziTura third){
		int max = Math.max(Math.max(first.getSreshtaniqEzi(), second.getSreshtaniqEzi()), third.getSreshtaniqEzi());
		if(max == first.getSreshtaniqEzi()){
			System.out.printf("pobeditelq e: %s, koito ima %d hvyrlqniq \"ezi\" \n", first.getPersonName(), max);
		}
		else if(max == second.getSreshtaniqEzi()){
			System.out.printf("pobeditelq e: %s, koito ima %d hvyrlqniq \"ezi\" \n", second.getPersonName(), max);
		}
		else if(max == third.getSreshtaniqEzi()){
			System.out.printf("pobeditelq e: %s, koito ima %d hvyrlqniq \"ezi\" \n", third.getPersonName(), max);
		}
	}
	
	
	public static void kraenPobeditel(EziTura first, EziTura second, EziTura third) throws InterruptedException{
		
		
		
		int max = Math.max(Math.max(first.getTochki(), second.getTochki()), third.getTochki());
		
		if(max == first.getTochki()){
			if(max == second.getTochki() && max == third.getTochki()){
				
				first.run();
				second.run();
				third.run();
				
				first.person.join();
				second.person.join();
				third.person.join();
				
				kraenPobeditel(first, second, third);
				return;
			}
			else if(max == second.getTochki()){
				
				first.run();
				second.run();
				
				first.person.join();
				second.person.join();	
				
				kraenPobeditel(first, second, third);
				return;
			}
			System.out.printf("%s, koito ima obshto %d hvyrlqniq \"ezi\" \n", first.getPersonName(), max);
			return;
		}
		else if(max == second.getTochki()){
			if(max == third.getTochki()){
				
				first.run();
				third.run();
				
				first.person.join();
				third.person.join();
				
				kraenPobeditel(first, second, third);
				return;
			}
			System.out.printf("%s, koito ima obshto %d hvyrlqniq \"ezi\" \n", second.getPersonName(), max);
			return;
		}
		else if(max == third.getSreshtaniqEzi()){
			System.out.printf("%s, koito ima obshto %d hvyrlqniq \"ezi\" \n", third.getPersonName(), max);
			return;
		}			
	}
}
