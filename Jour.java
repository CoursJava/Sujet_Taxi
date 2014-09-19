package Sujet_Taxi;

import java.util.Scanner; //Bibliothèque permettant de lire la saisie de l'utilisateur

public class Jour {

	private Scanner reader = new Scanner(System.in);
	private char jour;

	public Jour() { //Constructeur par defaut
		jour = ' ';
	}
	
	public char Value(){
		return jour;
	}
	
	public void Saisie(){
		do {
			System.out.print("Veuillez saisir le jour du trajet (S: Semaine / W: Week-end) : ");
			jour = reader.next().charAt(0);
			if (jour != 'S' || jour != 'W')
				System.out.print("Le jour saisi est incorrect\n");
		} while (jour != 'S' && jour != 'W'); // Tant que le jour n'est pas S ou W
		
		reader.close();
	}

}
