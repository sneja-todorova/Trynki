package headTailsGame;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args){
		System.out.print("Input number of games: ");
		Scanner input = new Scanner(System.in);
		
		int numberOfGames = input.nextInt();
		
		HeadTailsGame firstPerson = new HeadTailsGame("Ivan");
		HeadTailsGame secondPerson = new HeadTailsGame("Pesho");
		HeadTailsGame thirdPerson = new HeadTailsGame("Misho");
		
		secondPerson.person.start();		
		firstPerson.person.start();		
		thirdPerson.person.start();
		
		
		System.out.println();
		
		for (int i=0; i<numberOfGames; i++){
			
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
			
			
			firstPerson.setPoints(firstPerson.getHeadOccurrences());
			secondPerson.setPoints(secondPerson.getHeadOccurrences());
			thirdPerson.setPoints(thirdPerson.getHeadOccurrences());
			
			System.out.print("The winner at game number " + (i+1) + " is: "); 
			
			try {
				winner(firstPerson, secondPerson, thirdPerson);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			
			System.out.println();
		}
		
		try {
			resultOfGames(firstPerson, secondPerson, thirdPerson, numberOfGames);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
		
	
		System.out.println();
		System.out.println();
	}
	
	public static void winner(HeadTailsGame first, HeadTailsGame second, HeadTailsGame third) throws InterruptedException{
		int max = Math.max(Math.max(first.getHeadOccurrences(), second.getHeadOccurrences()), third.getHeadOccurrences());
		if(max == first.getHeadOccurrences()){
			if(max == second.getHeadOccurrences() && max == third.getHeadOccurrences()){
				first.run();
				second.run();
				third.run();
				
				first.person.join();
				second.person.join();
				third.person.join();
				
				winner(first, second, third);
				return;
			}
			else if(max == second.getHeadOccurrences()){
				first.run();
				second.run();
				
				first.person.join();
				second.person.join();
				
				winner(first, second, third);
				return;
			}
			else if(max == third.getHeadOccurrences()){
				first.run();
				third.run();
				
				first.person.join();
				third.person.join();
				
				winner(first, second, third);
				return;
			}
			
			System.out.printf(" %s. He has %d throws \"head\". \n", first.getPersonName(), max);
			// Increment victories by 1
			first.setVictories(1);
			return;
		}
		else if(max == second.getHeadOccurrences()){
			if(max == third.getPoints()){
				second.run();
				third.run();
				
				second.person.join();
				third.person.join();
				
				winner(first, second, third);
				return;
			}
	
			System.out.printf(" %s. He has %d throws \"head\". \n", second.getPersonName(), max);
			// Increment victories by 1
			second.setVictories(1);
			return;
		}
		
		else if(max == third.getHeadOccurrences()){
			System.out.printf(" %s. He has %d throws \"head\". \n", third.getPersonName(), max);
			// Increment victories by 1
			third.setVictories(1);
			return;
		}
	}
	
	
	
	public static void resultOfGames(HeadTailsGame first, HeadTailsGame second, HeadTailsGame third, int number) throws InterruptedException{		
		
		System.out.printf("After %d games played, final result is:\n", number);
		System.out.printf("%s has %d victories and total number of points (total number of occurrences \"Head\"): %d\n", first.getPersonName(), first.getVictories(), first.getPoints());
		System.out.printf("%s has %d victories and total number of points (total number of occurrences \"Head\"): %d\n", second.getPersonName(), second.getVictories(), second.getPoints());
		System.out.printf("%s has %d victories and total number of points (total number of occurrences \"Head\"): %d\n", third.getPersonName(), third.getVictories(), third.getPoints());
	}
}


