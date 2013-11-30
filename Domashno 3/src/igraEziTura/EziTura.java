package igraEziTura;

import java.util.Random;

public class EziTura implements Runnable{
	private String personName;
	public Thread person;
	private int moneta;
	private int sreshtaniqEzi;
	private int tochki;
	Random rand = new Random();
	
	public EziTura(String name){
		this.personName = name;
		this.person = new Thread(this, this.personName);
		this.moneta = 0;
		this.sreshtaniqEzi = 0;
		this.tochki = 0;
	}
	
	public int getMoneta(){
		return this.moneta;
	}
	public void setMoneta(int newMoneta){
		this.moneta = newMoneta;
		this.sreshtaniqEzi ++;
		
	}
	public String getPersonName(){
		return this.personName;
	}
	
	public int getSreshtaniqEzi(){
		return this.sreshtaniqEzi;
	}
	
	public int getTochki(){
		return this.tochki;
	}
	
	public void setTochki(int noviTochki){
		this.tochki += noviTochki;
	}
	
	
	
	//1=ezi ,  2=tura
	
	@Override
	public void run() {
		while(true){
			this.setMoneta(rand.nextInt(2) + 1);
			if(this.getMoneta() != 1){
				try {
					person.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					person.interrupt();
				}
				-- this.sreshtaniqEzi ;
				return;
			}
		}
		
   }
		
}


