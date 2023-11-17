package barberoDurmiente.parteUno.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Barberia {
	
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition sillas = lock.newCondition();
	private Condition sillon = lock.newCondition();
	private Condition pelar = lock.newCondition();
	private int ocupaSillon=0;
	private int ocupaSillas =0;
			
	public void ProcesoDePelado(int idCliente) throws InterruptedException {
		lock.lock();
		
		while(ocupaSillas ==5) {
			sillas.await();
		}
		
		while(ocupaSillon ==1) {
			ocupaSillas++;
			System.out.println("Cliente " + idCliente + " a la espera de ");
			sillon.await();
			ocupaSillas--;
			sillas.signal();
		}
		ocupaSillon++;
		System.out.println("Cliente " +idCliente + " esperando al peluquero a pelarme.");
		//Thread.sleep(10000);
		pelar.await();
		System.out.println("Cliente "+ idCliente + " sale de la barberia");
		ocupaSillon--;
		sillon.signal();
		
		lock.unlock();
	}
	
	
	public void barbero() throws InterruptedException {
		/*while(true) {
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
		}*/
	}
}
