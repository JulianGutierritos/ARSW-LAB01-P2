package arsw.threads;

/**
 * Un galgo que puede correr en un carril
 * 
 * @author rlopez
 * 
 */
public class Galgo extends Thread {
	
	private int paso;
	private Carril carril;
	RegistroLlegada regl;
	public boolean pausar;
	public Canodromo can;

	public synchronized static void print(Canodromo can, RegistroLlegada reg) {
		can.winnerDialog(reg.getGanador(),reg.getUltimaPosicionAlcanzada() - 1); 
        System.out.println("El ganador fue:" + reg.getGanador());
	}
	
	public Galgo(Carril carril, String name, RegistroLlegada reg, Canodromo can) {
		super(name);
		this.carril = carril;
		paso = 0;
		this.regl=reg;
		this.pausar = false;
		this.can=can;
	}

	public void corra() throws InterruptedException {
		while (paso < carril.size()) {			
			Thread.sleep(100);
			carril.setPasoOn(paso++);
			carril.displayPasos(paso);
			
			if (paso == carril.size()) {						
				carril.finish();
				int ubicacion=regl.getUltimaPosicionAlcanzada();
				regl.setUltimaPosicionAlcanzada(ubicacion+1);
				System.out.println("El galgo "+this.getName()+" llego en la posicion "+ubicacion);
				if (ubicacion==1){
					regl.setGanador(this.getName());
				}
				
			}
			synchronized (this) {
				while (pausar) {
					wait();
				}
			}
		}

		print(can,regl);
//		synchronized (this) {
//			notify();
//		}
	}


	@Override
	public void run() {
		try {
			corra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
