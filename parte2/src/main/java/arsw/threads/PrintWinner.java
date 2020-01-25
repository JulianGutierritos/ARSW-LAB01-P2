package arsw.threads;

public class PrintWinner {
	
	public synchronized static void print(Canodromo can, RegistroLlegada reg) {
		can.winnerDialog(reg.getGanador(),reg.getUltimaPosicionAlcanzada() - 1); 
        System.out.println("El ganador fue:" + reg.getGanador());
	}
}
