package headTailGame;

import java.util.Random;

public class HeadTailGame implements Runnable{
	private String personName;
	public Thread person;
	private int coin;
	private int occurrencesHead;
	private int points;
	Random rand = new Random();
	private int victories;
	
	public HeadTailGame(String name){
		this.personName = name;
		this.person = new Thread(this, this.personName);
		this.coin = 0;
		this.occurrencesHead = 0;
		this.points = 0;
		this.victories = 0;
	}
	
	public int getCoin(){
		return this.coin;
	}
	public void setCoin(int newCoin){
		this.coin = newCoin;
		this.occurrencesHead ++;
		
	}
	public String getPersonName(){
		return this.personName;
	}
	
	public int getHeadOccurrences(){
		return this.occurrencesHead;
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
				-- this.occurrencesHead ;
				return;
			}
		}		
	}	
}
