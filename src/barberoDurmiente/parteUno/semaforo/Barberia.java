package barberoDurmiente.parteUno.semaforo;

import java.util.concurrent.Semaphore;

public class Barberia {
	
	private Semaphore sillas = new Semaphore(5);
	private Semaphore sillon = new Semaphore(1);
	private Semaphore esperar = new Semaphore(0);
	private Semaphore barbero = new Semaphore(0);
	
	public void ProcesoDePelado(int idCliente) throws InterruptedException {
		
		sillas.acquire();
		System.out.println("Cliente " +idCliente + " a la espera de ser pelado.");
		sillon.acquire();
		barbero.release();
		System.out.println("Cliente " +idCliente + " esperando al peluquero a pelarme.");
		esperar.acquire();
		sillas.release();
		sillon.release();
		System.out.println("Cliente "+ idCliente + " sale de la barberia");
	}
	
	
	public void barbero() throws InterruptedException {
		while(true) {
			if(sillon.availablePermits() == 0) {
				System.out.println("Voy a pelar");
				Thread.sleep(2000);
				System.out.println("Cliente pelado");
				esperar.release();
			}else {
				System.out.println("no hay clientes, voy a dormir");
				Thread.sleep(5000);
				barbero.acquire();
			}
		}
	}
}
