package barberoDurmiente.parteUno.semaforo;

import java.util.Iterator;

public class Principal {
	public static void main(String[] args) {
		System.out.println("Barberia con semaforo");
		Barberia barberia = new Barberia();
		Thread barbero = new Barbero(barberia);
		barbero.start();
		
		for(int x=0; x<10;x++) {
			Thread c = new Cliente(x,barberia);
			c.start();
		}

	}
}
