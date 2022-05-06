package personatge;
import java.util.Optional;

public class Main {
        
	public static void main(String[] args) {
            int exit, guanyar;
            Tabler tabler = new Tabler();
            
            tabler.generarPersonatge(Optional.empty());
            tabler.dimensioTauler();
            System.out.println("");
            tabler.generarTauler();
            do{
                tabler.mostrarTauler();
                System.out.println("");
                tabler.mostrarDatos();
                System.out.println("");
                exit = tabler.menu();
				guanyar = tabler.sortida();
                System.out.println("\n\n\n");
            }while(exit==0 || guanyar != 1);
	}   
        
}

