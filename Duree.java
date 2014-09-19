package Sujet_Taxi;

import java.util.Scanner;

public class Duree {

	private Scanner reader = new Scanner(System.in);
	private int duree;
	
	public Duree() { //Constructeur par defaut
		duree = 0;
	}
	
	public Duree(int duree) {
		this.duree = duree;
	}
	
	public int Saisie(){
		do {
			System.out.print("Veuillez saisir la durée du trajet (en minutes) : ");
			duree = reader.nextInt();
			if (duree < 0)
				System.out.print("La durée saisie est incorrect\n");
		} while (duree < 0); // Tant que la durée est inferieur à 0
		
		reader.close();
		return duree;
	}

}
