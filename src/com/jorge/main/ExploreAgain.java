package com.jorge.main;

public class ExploreAgain {
	public void explore(){ //Error: catch block debe estar antes que finally block
		try { 
			seeAnimals();
			fall();
		} finally {
			seeMoreAnimals();
		} catch(RuntimeException e){ 
			System.out.println("RuntimeException catch block: " + e.toString());
			getHugFromDaddy();
		}
		goHome();
	}
	
	public void explore2(){ //Correcto: aunque no exista catch block, como sí existe finally block entonces es permitido
		try { 
			seeAnimals();
			fall();
		} finally { 
			seeMoreAnimals();
		} 
		goHome();
	}
	
	public void explore3(){ //Error: si hay un bloque try debe haber uno catch o uno finally. No puede ser sólo try
		try { 
			seeAnimals();
			fall();
		}
		goHome();
	}
	
	public void explore4(){ //Todo mal: aunque solo haya un statement enlos bloques try, catch o finally SIMEPRE debe de llevar llaves {}
		try
			seeAnimals();
				
		catch (IndexOutOfBoundsException e) 
			System.out.println("IndexOutOfBoundsException catch block: " + e.toString()); 
		
	    finally
			seeMoreAnimals();

		goHome();
	}
	private void seeAnimals(){
		System.out.println("I see animals");
	}
	
	private void fall(){ //Forzamos que se vaya al bloque catch, forzamos la exception con throw
		System.out.println("Launching throw new RuntimeException");
		throw new RuntimeException(); // Va a catch(RuntimeException e), no a catch (IndexOutOfBoundsException e)
	}
	
	private void getHugFromDaddy(){
		System.out.println("Method called from RuntimeException catch block: A hug from daddy");
	}
	
	private void seeMoreAnimals(){
		System.out.println("Finally: Seeing more animals");
	}
	
	private void goHome(){
		System.out.println("Let's go to home");
	}
}
