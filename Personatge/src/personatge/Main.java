package personatge;
import java.util.Optional;
/**
 * Contingut Programa
 * @author MarcSerra, CynthiaGarcia, PolCrespo 
 */
public class Main {
        
	public static void main(String[] args) {
            int exit, guanyar;
			System.out.println("JOC DE ROL 1.0\n");
			System.out.println("Objectiu del joc: Arriba a SORTIDA (S) amb la clau i 10 monedes.");
			System.out.println("Mecàniques:\n"
								+ "- Hi ha una clau amagada al mapa, troba-la!!\n" 
								+ "- Tens 3 opcions de personatge: Sacerdot, Guerrer i Mag.\n"
								+ "- Els enemics també poden ser sacerdots, guerrers o mags.\n"
								+ "- Hauràs de descobrir quina classe guanya a cada una d'elles, prova sort!\n"
								+ "- Si Guanyes una batalla guanyes una moneda, si perds perds una moneda.\n"
								+ "- Si perds totes les monedes perds una vida i tornes a començar amb les monedes inicials."
								+ "\n\nEn aquesta versió les batalles son aleatories i depenen gairebé al 100% de la sort\n\n");
            Tabler tabler = new Tabler();
            tabler.generarPersonatge(Optional.empty());
            tabler.dimensioTauler();
            System.out.println("");
            tabler.generarTauler();
            do{
                tabler.mostrarTaulerDev(); //tabler.mostrarTaulerDev(); per veure mapa desbloquejat
				//posar k al menu tembé mostra el mapa
                System.out.println("");
                tabler.mostrarDatos();
                System.out.println("");
                exit = tabler.menu();
				guanyar = tabler.sortida();
                System.out.println("\n\n\n");
            }while(exit == 0 && guanyar != 1);
	}    
}

