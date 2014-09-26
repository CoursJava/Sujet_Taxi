package Sujet_Taxi;

import java.util.Scanner; //Bibliothèque permettant de lire la saisie de l'utilisateur

public class Saisies {
	//Reader
	private Scanner reader = new Scanner(System.in);
	
	//Attributs
	private int dept, km, duree;
	private char typeTrajet, heure, jour;

	// Accesseurs
	/**
	 * Accesseur du département saisie
	 * 
	 * @return Numéro du département (int)
	 */
	public int getDepartement() {
		return dept;
	}
	/**
	 * Accesseur du type de trajet
	 * 
	 * @return Type de trajet (char)
	 */
	public char getTypeTrajet() {
		return typeTrajet;
	}
	/**
	 * Accesseur du jour
	 * 
	 * @return Jour (char)
	 */
	public char getJour() {
		return jour;
	}
	/**
	 * Accesseur de l'heure
	 * 
	 * @return Heure (char)
	 */
	public char getHeure() {
		return heure;
	}
	/**
	 * Accesseur des kilomètres
	 * 
	 * @return Km (int)
	 */
	public int getKm() {
		return km;
	}
	/**
	 * Accesseur de la durée
	 * 
	 * @return Duree (int)
	 */
	public int getDuree() {
		return duree;
	}
	
	//Méthodes
	public void SaisieDepartement() {
		do {
			System.out.print("Veuillez saisir le departement : ");
			dept = reader.nextInt();
			if (dept <= 0 || dept > 95)
				System.out.print("Le departement saisi est incorrect\n");
		} while (dept <= 0 || dept > 95); // Tant que le departement est pas compris entre 0 et 95
	}

	public void SaisieTypeTrajet() {
		do {
			System.out.print("Veuillez saisir le type de trajet (S: Aller simple / R: Aller-Retour) : ");
			typeTrajet = reader.next().toLowerCase().charAt(0);
			if (typeTrajet != 's' && typeTrajet != 'r')
				System.out.print("Le type de trajet saisi est incorrect\n");
		} while (typeTrajet != 's' && typeTrajet != 'r'); // Tant que le type de trajet n'est pas S ou R
	}

	public void SaisieJour() {
		do {
			System.out.print("Veuillez saisir le jour du trajet (S: Semaine / W: Week-end) : ");
			jour = reader.next().toLowerCase().charAt(0);
			if (jour != 's' && jour != 'w')
				System.out.print("Le jour saisi est incorrect\n");
		} while (jour != 's' && jour != 'w'); // Tant que le jour n'est pas S ou
												// W
	}

	public void SaisieHeure() {
		do {
			System.out.print("Veuillez saisir l'heure du trajet (J: Avant 20h / N: Après 20h) : ");
			heure = reader.next().toLowerCase().charAt(0);
			if (heure != 'j' && heure != 'n')
				System.out.print("L'heure saisi est incorrect\n");
		} while (heure != 'j' && heure != 'n'); // Tant que l'heure n'est pas J
												// ou N
	}

	public void SaisieKm() {
		do {
			System.out.print("Veuillez saisir le nombre de kilomètres : ");
			km = reader.nextInt();
			if (km < 0)
				System.out.print("Le nombre de kilomètres saisi est incorrect\n");
		} while (km < 0); // Tant que le nombre de kilomètres est inferieur à 0
	}

	public void SaisieDuree() {
		do {
			System.out.print("Veuillez saisir la durée du trajet (en minutes) : ");
			duree = reader.nextInt();
			if (duree < 0)
				System.out.print("La durée saisie est incorrect\n");
		} while (duree < 0); // Tant que la durée est inferieur à 0
	}
	
	public void Saisie()
	{
		SaisieDepartement();
		SaisieTypeTrajet();
		SaisieJour();
		SaisieHeure();
		SaisieDuree();
		SaisieKm();
	}
}