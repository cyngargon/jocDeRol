package personatge;
import java.util.Optional;

public class Main {
        
	public static void main(String[] args) {
            int exit;
            Tabler tabler = new Tabler();
            
            tabler.generarPersonatge(Optional.empty());
            tabler.dimensioTauler();
            tabler.generarTauler();
            do{
                tabler.mostrarTauler();
                System.out.println("");
                tabler.mostrarDatos();
                exit = tabler.menu();
            }while(exit==0);
	}   
        
}

