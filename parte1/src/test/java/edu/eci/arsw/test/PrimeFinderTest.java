package edu.eci.arsw.test;


import org.junit.Test;
import static org.junit.Assert.*;


import edu.eci.arsw.primefinder.PrimeFinderThread;

public class PrimeFinderTest{
    
    PrimeFinderThread pft1;
	PrimeFinderThread pft2;
	PrimeFinderThread pft3;
    
    public PrimeFinderTest(){
        pft1=new PrimeFinderThread(0, 10000000);
	    pft2=new PrimeFinderThread(10000000, 20000000);
	    pft3=new PrimeFinderThread(20000000, 30000000);
    }

    @Test
    public void deberianSerIguales(){
        PrimeFinderThread pft = new PrimeFinderThread(0, 30000000);
        
        pft.start();
        pft1.start();
        pft2.start();
        pft3.start();
        boolean vivos = true;
        while (vivos==true){
            if(pft1.isAlive() || pft2.isAlive() || pft3.isAlive() || pft.isAlive()){
                vivos = true;
            }else{vivos=false;}
        }
        int lon1 = pft1.getPrimes().size();
        int lon2 = pft2.getPrimes().size();
        int lon3 = pft3.getPrimes().size();

        int lon = pft.getPrimes().size();
        //1857859
        assertEquals( lon, lon1+lon2+lon3);
    }
}