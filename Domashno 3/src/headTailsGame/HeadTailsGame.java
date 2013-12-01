package headTailsGame;

import java.util.Random;

public class HeadTailsGame implements Runnable{
	private String personName;
	public Thread person;
	private int coin;
	private int headOccurrences;
	private int points;
	private int victories;
	Random rand = new Random();
	
	public HeadTailsGame(String name){
		this.personName = name;
		this.person = new Thread(this, this.personName);
		this.coin = 0;
		this.headOccurrences = 0;
		this.points = 0;
		this.victories = 0;
	}
	
	public int getCoin(){
		return this.coin;
	}
	
	public void setCoin(int newCoin){
		this.coin = newCoin;
		this.headOccurrences ++;	
	}
	
	public String getPersonName(){
		return this.personName;
	}
	
	public int getHeadOccurrences(){
		return this.headOccurrences;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public void setPoints(int newPoints){
		this.points += newPoints;
	}
	
	public int getVictories(){
		return this.victories;
	}
	
	public void setVictories(int vict){
		this.victories += vict;
	}
	
	
	//1 = "Head" ,  2 = "Tail"
	
	
	@Override
	public void run() {
		while(true){
			this.setCoin(rand.nextInt(2) + 1);
			if(this.getCoin() != 1){
				person.interrupt();
				-- this.headOccurrences ;
				return;
			}
		}		
	}	
}
