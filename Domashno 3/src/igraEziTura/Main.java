package igraEziTura;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args){
		System.out.print("Input number of games: ");
		Scanner input = new Scanner(System.in);
		
		int NumberOfGames = input.nextInt();
		
		GameHeadTails firstPerson = new GameHeadTails("Ivan");
		GameHeadTails secondPerson = new GameHeadTails("Pesho");
		GameHeadTails thirdPerson = new GameHeadTails("Misho");
		
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
		
				
		firstPerson.setPoints(firstPerson.getOccurrencesHead());		
		secondPerson.setPoints(secondPerson.getOccurrencesHead());		
		thirdPerson.setPoints(thirdPerson.getOccurrencesHead());
		
		System.out.print("The winner at game number 1 is:  "); 
		
		try {
			winner(firstPerson, secondPerson, thirdPerson);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println();
		
		for (int i=1; i<NumberOfGames; i++){
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
			
			
			firstPerson.setPoints(firstPerson.getOccurrencesHead());
			secondPerson.setPoints(secondPerson.getOccurrencesHead());
			thirdPerson.setPoints(thirdPerson.getOccurrencesHead());
			
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
			resultOfGames(firstPerson, secondPerson, thirdPerson);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
		
	
		System.out.println();
		System.out.println();
	}
	
	public static void winner(GameHeadTails first, GameHeadTails second, GameHeadTails third) throws InterruptedException{
		int max = Math.max(Math.max(first.getOccurrencesHead(), second.getOccurrencesHead()), third.getOccurrencesHead());
		if(max == first.getOccurrencesHead()){
			if(max == first.getOccurrencesHead()){
				if(max == second.getOccurrencesHead() && max == third.getOccurrencesHead()){
					first.run();
					second.run();
					third.run();
					
					first.person.join();
					second.person.join();
					third.person.join();
					
					winner(first, second, third);
					return;
				}
				else if(max == second.getOccurrencesHead()){
					first.run();
					second.run();
					
					first.person.join();
					second.person.join();
					
					winner(first, second, third);
					return;
				}
				else if(max == third.getOccurrencesHead()){
					first.run();
					third.run();
					
					first.person.join();
					third.person.join();
					
					winner(first, second, third);
					return;
				}
			System.out.printf(" %s. He has %d throws \"head\". \n", first.getPersonName(), max);
			first.setVictories(1);
			return;
		}
		else if(max == second.getOccurrencesHead()){
			if(max == third.getPoints()){
				second.run();
				third.run();
				
				second.person.join();
				third.person.join();
				
				winner(first, second, third);
				return;
			}
		}
			System.out.printf(" %s. He has %d throws \"head\". \n", second.getPersonName(), max);
			second.setVictories(1);
			return;
		}
		else if(max == third.getOccurrencesHead()){
			System.out.printf(" %s. He has %d throws \"head\". \n", third.getPersonName(), max);
			third.setVictories(1);
			return;
		}
	}
	
	
	public static void resultOfGames(GameHeadTails first, GameHeadTails second, GameHeadTails third) throws InterruptedException{		
		
		System.out.println("After games played, final result is:");
		System.out.printf("%s has %d victories and total number of points (total number of occurances \"Head\"): %d\n", first.getPersonName(), first.getVictories(), first.getPoints());
		System.out.printf("%s has %d victories and total number of points (total number of occurances \"Head\"): %d\n", second.getPersonName(), second.getVictories(), second.getPoints());
		System.out.printf("%s has %d victories and total number of points (total number of occurances \"Head\"): %d\n", third.getPersonName(), third.getVictories(), third.getPoints());
	}
}
