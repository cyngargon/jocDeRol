package jocderol;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
/**
 * Contingut Programa
 * @author MarcSerra, CynthiaGarcia, PolCrespo 
 */
public class Main {
        
	public static void main(String[] args) {
            int exit, guanyar, tempsInici, tempsFinal;
			Dato d1 = new Dato();
			System.out.println("JOC DE ROL 1.0\n");
			d1.intoduccioNom();
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
            //Se'ns guarda temps final Sistema
            tempsFinal = d1.tempsActual();
            // Modifiquem Temps
            d1.setTemps(tempsFinal-tempsInici);
            d1.setPuntuacio(100);
            /********FITXERS*********/
            grabarArchivo(d1);
            ArrayList<Dato> dades = leerArchivo();
            int resp = d1.demanarDades();
            if (resp==1) {
                mostrar(dades);
            }
	}    

	public static void grabarArchivo(Dato d1) {
		byte [] bDato = new byte[Dato.NOM_SIZE]; //Array amb posicions de bytes del nostre nom
		try
		{
			RandomAccessFile file = new RandomAccessFile("files\\fitxer.bin", "rw"); //rw --> Read && Write
			long pos = file.length(); //Varibale per saber el lloc on escribim
			file.seek(pos); //Ens posem en la posicio correcta
			bDato = d1.getFormattedString().getBytes(); //Carguem el nom amb array de tipo bytes
			file.write(bDato); //Escriu un array de bites
			file.writeInt(d1.getPuntuacio()); //Posem la puntuacio
			file.writeInt(d1.getTemps());
			//Hem escrit en binari i en el fitxer
			file.close();
		}
		catch(IOException e) //Capturamos la Excepción.
		{
			System.out.println(e.toString()); //Mostrar per pantalla excepcio
		}
	}
	
	public static ArrayList<Dato> leerArchivo()
	{
		long numBytes;
		int numRegs;
		ArrayList<Dato> datos = new ArrayList<>();		
		byte [] bDato = new byte[Dato.NOM_SIZE];
			
		try
		{
			RandomAccessFile file = new RandomAccessFile("files\\fitxer.bin", "r"); //r --> READ
			numBytes = file.length(); //Longitud del fitxer
			numRegs = (int) (numBytes / Dato.size()); // Numero de registres en el nostre fitxer
			
			for(int i = 0; i < numRegs; i++) 
			{
				int pos = i * Dato.size();
				file.seek(pos);
				file.read(bDato); //LLegim el bdato (array de bytes
				String nom = new String(bDato).trim(); //String guardant el registre
				int puntuacio = file.readInt(); // Llegir enter i guardar-lo
				int temps = file.readInt(); // Legir enter i guardar-lo
				Dato d = new Dato(nom, puntuacio, temps); // Ho guardem en la nostre variable de String i int
				datos.add(d); // Ho guardem en el nostre arraylist
			}
			file.close();
		}
		catch(IOException e)
		{
			System.out.println(e.toString());//Mostrar per pantalla excepcio
		}
		
		return datos;
	}
	public static void mostrar(ArrayList<Dato> dades)
	{
            
            Collections.sort(dades, Comparator.comparing(Dato::getNom));
            int i = 1;
            for(Dato d: dades) //
            {
                    System.out.print(i++ + ".- ");
                    System.out.println("NOM: " + d.getNom() + "\tPUNTUACIO: " + d.getPuntuacio() + "\tTEMPS DE JOC: " + d.getTemps() + "''");
            }
	}
}

