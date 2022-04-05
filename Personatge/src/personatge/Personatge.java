package personatge;

public abstract class Personatge {

	private int vides;
	private int[][]posicio;
	private int monedes;
	
	public abstract String missatgePosicio();
	
	public int mostrarMenu() {
		int seleccio = 0;
		return seleccio;
	}
	
	public String mostrarPosicio() {
		return	"W -> Arriba"
				+ "S -> Abajo"
				+ "D -> Derecha"
				+ "A -> Izquierda";
	}
	
	public void checkCasilla() {
		
	}
	
	public void checkPosicio() {
		
	}
	
	public void opcionesMenu() {
		int seleccio = mostrarMenu();
		switch (seleccio) {
			case 1:
				System.out.println("Moverse");
				missatgePosicio();
				
		}
	}
}
