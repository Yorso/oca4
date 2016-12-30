package com.jorge.main;

public class Explore {
	
	public void explore(){
		try {
			seeAnimals();
			fall();
			System.out.println("Esta linea nunca se ejecutará, fall() va a RuntimeException catch block y ya no volverá al bloque try");
		} catch (IndexOutOfBoundsException e) { //Nunca se ejecutará este catch
			System.out.println("Nunca se ejecutará: IndexOutOfBoundsException catch block: " + e.toString()); 
		} catch(RuntimeException e){
			System.out.println("RuntimeException catch block: " + e.toString());
			getHugFromDaddy();
		} finally {
			seeMoreAnimals();
		}
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
