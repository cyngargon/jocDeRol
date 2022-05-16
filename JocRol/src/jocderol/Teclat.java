// =============================================================================
// Classe Teclat

// Paquet
package jocderol;

// Imports
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Cont� diferents m�todes per llegir dades des del teclat, en funci� del tipus 
 * de dada a llegir. Aquesta versi� no llen�a excepcions expl�cites.
 * Data de creaci�: 24/08/2020
 * @author Jos� Luis Garc�a Ma�as
 */
public class Teclat
{
	/**
	 * Llegeix una cadena des del teclat i la retorna.
	 * @return La cadena llegida des del teclat
	 */
	public static String llegirString()
	{
		return new Scanner(System.in).nextLine();
	}

	/**
	 * Llegeix un car�cter des del teclat i el retorna. Si es produeix un error 
	 * perqu� all� introdu�t no �s un car�cter, mostra un missatge d'error i 
	 * retorna el car�cter ASCII 0.
	 * @return El car�cter llegit des del teclat
	 */
	public static char llegirChar()
	{
		// Inicialitzem el car�cter a car�cter buit. Si es produeix algun error,
		// es retornar� aquest valor
		char c = 0;

		// Si no es produeix cap error, es retornar� el car�cter llegit
		String s = llegirString();

		// Controlem que el que s'ha llegit �s un car�cter
		if(s.length() == 1)
		{
			c = s.charAt(0);
		}
		else
		{
			System.err.println("La dada introdu�da no �s un car�cter.");
		}

		return c;
	}

	/**
	 * Llegeix un n�mero enter (short) des del teclat i el retorna.
	 * @return El n�mero enter (short) llegit des del teclat
	 */
	public static short llegirShort()
	{
		return new Scanner(System.in).nextShort();
	}

	/**
	 * Llegeix un n�mero enter des del teclat i el retorna.
	 * @return El n�mero enter llegit des del teclat
	 */
	public static int llegirInt()
	{
		return new Scanner(System.in).nextInt();
	}

	/**
	 * Llegeix un n�mero enter (long) des del teclat i el retorna.
	 * @return El n�mero enter (long) llegit des del teclat
	 */
	public static long llegirLong()
	{
		return new Scanner(System.in).nextLong();
	}

	/**
	 * Llegeix un n�mero enter (BigInteger) des del teclat i el retorna.
	 * @return El n�mero enter (BigInteger) llegit des del teclat
	 */
	public static BigInteger llegirBigInteger()
	{
		return new Scanner(System.in).nextBigInteger();
	}

	/**
	 * Llegeix un n�mero real (float) des del teclat i el retorna. 
	 * @return El n�mero real (float) llegit des del teclat
	 */
	public static float llegirFloat()
	{
		return new Scanner(System.in).nextFloat();
	}

	/**
	 * Llegeix un n�mero real (double) des del teclat i el retorna. 
	 * @return El n�mero real (double) llegit des del teclat
	 */
	public static double llegirDouble()
	{
		return new Scanner(System.in).nextDouble();
	}

	/**
	 * Llegeix un n�mero real (BigDecimal) des del teclat i el retorna. 
	 * @return El n�mero real (BigDecimal) llegit des del teclat
	 */
	public static BigDecimal llegirBigDecimal()
	{
		return new Scanner(System.in).nextBigDecimal();
	}

	/**
	 * Llegeix un valor boole� des del teclat i el retorna. 
	 * @return El valor boole� llegit des del teclat
	 */
	public static boolean llegirBoolean()
	{
		return new Scanner(System.in).nextBoolean();
	}
}
// =============================================================================
