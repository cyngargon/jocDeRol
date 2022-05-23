package jocderol;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dato {
    public final static int NOM_SIZE = 3;
	private final int porcGuanya = 1000, porcGuanyat = 50, porcVides = 20, porcMonedes = 5;

    private String nom;
    private int puntuacio;
    private int temps;

    public Dato() {

    }

    public Dato(String nom, int puntuacio, int temps) {
            this.nom = nom;
            this.puntuacio = puntuacio;
            this.temps = temps;
    }

    public String getNom() {
            return nom;
    }

    public void setNom(String nom) {
            this.nom = nom;
    }

    public int getPuntuacio() {
            return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
            this.puntuacio = puntuacio;
    }

    public int getTemps() {
            return temps;
    }

    public void setTemps(int temps) {
            this.temps = temps;
    }

    @Override
    public String toString()
    {
            return "NOM --> " + nom + "\nPUNTUACIO --> " + puntuacio + "\nTEMPS --> " + temps;
    }

    public String getFormattedString()
    {
            return String.format("%-" + NOM_SIZE + "." + NOM_SIZE + "s", nom);
    }

    public static int size()
    {
            return NOM_SIZE + 2 * Integer.BYTES;
    }

    public void intoduccioNom() {
            System.out.println("||Intodueix el teu nom||\n(3 caracters)");
            System.out.print("- ");
            String nomUser = Teclat.llegirString();
            this.nom = nomUser.toUpperCase();
			System.out.println();
    }
	
	public int calculPuntuacio(Tabler tabler, int guanyar){
		//BATALLES GUANYADES
		puntuacio += porcGuanyat * tabler.getPersonatge().getTotalGuanyades();
		//MONEDES OBTINGUDES
		puntuacio += porcVides * tabler.getPersonatge().getVides();
		//MONEDES OBTINGUDES
		puntuacio += porcMonedes * tabler.getPersonatge().getMonedes();
		//GUANYA???
		if (guanyar == 1) {
			puntuacio += porcGuanya; 
		}
		return puntuacio;
	}

    public int tempsActual(){
            int hora, minut, segons;

            String timeStampHora = new SimpleDateFormat("HH").format(new java.util.Date());
            String timeStampMinut = new SimpleDateFormat("mm").format(new java.util.Date());
            String timeStampSegons = new SimpleDateFormat("ss").format(new java.util.Date());

            hora = Integer.parseInt(timeStampHora);
            minut = Integer.parseInt(timeStampMinut);
            segons = Integer.parseInt(timeStampSegons);

            temps = 3600 * hora + 60 * minut + segons ;
            return temps;
    }

    public int demanarDades() {
        int resp;
        System.out.print("VOLS VEURE EL MARCADOR? (0 -> NO) (1-> SÍ) -> ");
        resp = Teclat.llegirInt();
        if (resp != 1) {
            System.out.println("\n\n\n\t\t\tPROGRAMM END");
        } 
        return resp;
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
            
            Collections.sort(dades, Comparator.comparing(Dato::getPuntuacio).reversed());
            int i = 1;
            for(Dato d: dades) //
            {
                    System.out.print(i++ + ".- ");
                    System.out.println("NOM: " + d.getNom() + "\tPUNTUACIO: " + d.getPuntuacio() + "\tTEMPS DE JOC: " + d.getTemps() + "''");
            }
	}
}
