package Sujet_Taxi;

import java.util.Scanner; //Bibliothèque permettant de lire la saisie de l'utilisateur

public class Heure {

	private Scanner reader = new Scanner(System.in);
	private char heure;
	
	public Heure() { //Constructeur par defaut
		heure = ' ';
	}
	
	public char Value(){
		return heure;
	}
	
	public void Saisie(){
		do {
			System.out.print("Veuillez saisir l'heure du trajet (J: Avant 20h / N: Après 20h) : ");
			heure = reader.next().charAt(0);
			if (heure != 'J' || heure != 'N')
				System.out.print("L'heure saisi est incorrect\n");
		} while (heure != 'J' && heure != 'N'); // Tant que l'heure n'est pas J ou N
		
		reader.close();
	}

}
