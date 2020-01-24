package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	boolean pausar;
	
	private List<Integer> primes=new LinkedList<Integer>();
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		this.pausar = false;
	}

	public void run(){
		try{
			for (int i=a;i<=b;i++){						
				if (isPrime(i)){
					//System.out.println(i);
					primes.add(i);
				}
				synchronized (this) {
					while (pausar) {
						wait();
					}
				}
			}
	    }catch (Exception e){}
	}
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public List<Integer> getPrimes() {
		return primes;
	}
	
	public void pausar(){
		pausar = true;
	}
	
	public void reaunudar(){
		pausar = false;
		synchronized (this) {
			notify();
		}
	}
	
	
	
	
}
