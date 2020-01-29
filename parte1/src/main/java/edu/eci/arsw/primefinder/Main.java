package edu.eci.arsw.primefinder;

import java.util.Scanner;

public class Main{

	private static PrimeFinderThread pft1, pft2, pft3;

	public static void main(String[] args) throws InterruptedException {
		pft1 = new PrimeFinderThread(0, 1000000);
		pft2 = new PrimeFinderThread(10000000, 20000000);
		pft3 = new PrimeFinderThread(20000000, 30000000);
		startAll();

		Thread.sleep(5000);

		stopAll();
		System.out.println("De 0 a 10000000: "+ pft1.getPrimes().size());
		System.out.println("De 10000000 a 20000000: "+ pft2.getPrimes().size());
		System.out.println("De 20000000 a 30000000: "+ pft3.getPrimes().size());
		input();
		resumeAll();
		
		boolean vivos = true;
		while (vivos==true){
            if(pft1.isAlive() || pft2.isAlive() || pft3.isAlive()){
                vivos = true;
            }else{vivos=false;}
		}
		System.out.println("De 0 a 10000000: "+ pft1.getPrimes().size());
		System.out.println("De 10000000 a 20000000: "+ pft2.getPrimes().size());
		System.out.println("De 20000000 a 30000000: "+ pft3.getPrimes().size());

	}

	private static void startAll(){
		pft1.start();
		pft2.start();
		pft3.start();

	}

	private static void input(){
		System.out.println("Please, press the ENTER key to continue");
		Scanner sc = new Scanner(System.in);
		String i = "enter";
		while(true){
			if (i.equals("")){
				break;
			}
			i = sc.nextLine();
		}
		sc.close();
	}

	private static void stopAll(){
		pft1.stopThread();
		pft2.stopThread();
		pft3.stopThread();
	}

	private static void resumeAll(){
		pft1.resumeThread();
		pft2.resumeThread();
		pft3.resumeThread();
	}
	
}
