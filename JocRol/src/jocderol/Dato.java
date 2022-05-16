package jocderol;

import java.text.SimpleDateFormat;

public class Dato {
	public final static int NOM_SIZE = 3;

	
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
		System.out.println("\t||Intodueix el teu nom||\n(Nomes s'agafara els tres primers caracters!)");
		System.out.print("- ");
		String nomUser = Teclat.llegirString();
		this.nom = nomUser;
	}
	
	public int tempsActual(){
		int hora, minut;

		String timeStampHora = new SimpleDateFormat("HH").format(new java.util.Date());
		String timeStampMinut = new SimpleDateFormat("mm").format(new java.util.Date());

		hora = Integer.parseInt(timeStampHora);
		minut = Integer.parseInt(timeStampMinut);

		temps = 60 * hora + minut;
		return temps;
	}
}
