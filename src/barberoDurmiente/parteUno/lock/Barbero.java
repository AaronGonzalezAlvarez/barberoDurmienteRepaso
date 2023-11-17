package barberoDurmiente.parteUno.lock;

public class Barbero extends Thread {
	
	private Barberia barberia;
	
	public Barbero(Barberia barberia) {
		this.barberia = barberia;
	}
	
	@Override
	public void run() {
		try {
			barberia.barbero();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

