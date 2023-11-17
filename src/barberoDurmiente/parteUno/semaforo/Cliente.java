package barberoDurmiente.parteUno.semaforo;

public class Cliente extends Thread {
	
	private int id;
	private Barberia barberia;
	
	public Cliente(int id, Barberia barberia) {
		this.id=id;
		this.barberia = barberia;
	}
	
	@Override
	public void run() {
		try {
			barberia.ProcesoDePelado(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
