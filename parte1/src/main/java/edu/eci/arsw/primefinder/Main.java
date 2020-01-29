package edu.eci.arsw.primefinder;

import java.io.Console;
public class Main {

	public static void main(String[] args) {
		Console c = System.console();
		PrimeFinderThread pft1=new PrimeFinderThread(0, 10000000);
		PrimeFinderThread pft2=new PrimeFinderThread(10000000, 20000000);
		PrimeFinderThread pft3=new PrimeFinderThread(20000000, 30000000);
		pft1.start();
		pft2.start();
		pft3.start();
		try{
			Thread.sleep(5000);
			pft1.pausar();
			pft2.pausar();
			pft3.pausar();
		} catch (Exception e){}
		System.out.println("De 0 a 10000000: "+ pft1.getPrimes().size());
		System.out.println("De 10000000 a 20000000: "+ pft2.getPrimes().size());
		System.out.println("De 20000000 a 30000000: "+ pft3.getPrimes().size());
		c.format("\nPresionar Enter para continuar.\n");
		c.readLine();
		pft1.reaunudar();
		pft2.reaunudar();
		pft3.reaunudar();
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
}
