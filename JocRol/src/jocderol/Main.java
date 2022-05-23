package jocderol;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Contingut Programa
 * @author MarcSerra, CynthiaGarcia, PolCrespo 
 */
public class Main {
        
    public static void main(String[] args) {
        int exit, guanyar, tempsInici, tempsFinal;
        Dato d1 = new Dato();
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
        //Se'ns guarda Temps Inicial Sistema
        tempsInici = d1.tempsActual();

        do{
            tabler.mostrarTauler(); //tabler.mostrarTaulerDev(); per veure mapa desbloquejat
                            //posar k al menu tembé mostra el mapa
            System.out.println("");
            tabler.mostrarDatos();
            System.out.println("");
            exit = tabler.menu();
			guanyar = tabler.sortida();
            System.out.println("\n\n\n");
        }while(exit == 0 && guanyar != 1);
		
		///////////////////////DADES////////////////////////////
		d1.intoduccioNom();
		//Calcul Puntuacio
		int puntuacioFinal = d1.calculPuntuacio(tabler, guanyar);
		// Modifiquem Puntuacio
		d1.setPuntuacio(puntuacioFinal);
        //Se'ns guarda temps final Sistema
        tempsFinal = d1.tempsActual();
        // Modifiquem Temps
        d1.setTemps(tempsFinal-tempsInici);
		
        ///////////////////////FITXERS//////////////////////////
		System.out.println("\nFITXERS");
        d1.grabarArchivo(d1);
        ArrayList<Dato> dades = d1.leerArchivo();
        int resp = d1.demanarDades();
        if (resp==1) {
            d1.mostrar(dades);
        }
        
        ////////////////////BASES DE DADES///////////////////////
        System.out.println("\n\nBASE DE DADES");
        try{
			//Creem objecte de base de dades
            BaseDades bd = new BaseDades();
            //Mètodes
			bd.insertarRegistre(d1.getNom(), d1.getPuntuacio(), d1.getTemps());
			bd.mostrarRegistresOrdenats();
            //Tancar base de dades
            bd.close();
        } catch (SQLException ex) {
			System.out.println("S'ha trobat una excepcio...");
			System.out.println("Aquesta és la següent: " + ex.getMessage());
		}
    }    

	
}

