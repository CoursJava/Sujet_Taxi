package Sujet_Taxi;

import java.util.Scanner; //Bibliothèque permettant de lire la saisie de l'utilisateur

public class Km {

	private Scanner reader = new Scanner(System.in);
	private int km;
	
	public Km() { //Constructeur par defaut
		km = 0;
	}
	
	public int Value(){
		return km;
	}
	
	public void Saisie(){
		do {
			System.out.print("Veuillez saisir le nombre de kilomètres : ");
			km = reader.nextInt();
			if (km < 0)
				System.out
						.print("Le nombre de kilomètres saisi est incorrect\n");
		} while (km < 0); // Tant que le nombre de kilomètres est inferieur à 0
		
		reader.close();
	}

}
