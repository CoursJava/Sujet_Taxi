package Sujet_Taxi;

import java.util.InputMismatchException;
import java.util.Scanner; //Bibliothèque permettant de lire la saisie de l'utilisateur

public class main {

	// Variables globales
	static Scanner reader = new Scanner(System.in);
	static int dept, duree, km;
	static char typeTrajet, jour, heure;

	// Constantes
	static double[][] tarifs = {
			{ 21, 2, 0.86, 1.72, 21.93, 1.29, 2.58, 21.93 },
			{ 25, 2.1, 0.83, 1.66, 22.5, 1.2, 2.4, 22.5 },
			{ 39, 2.1, 0.83, 1.66, 22.5, 1.23, 2.46, 25 },
			{ 44, 2.2, 0.79, 1.58, 24.19, 1.19, 2.37, 24.19 },
			{ 72, 2.15, 0.79, 1.58, 22.86, 1.19, 2.38, 22.86 },
			{ 73, 2.4, 0.84, 1.68, 25.4, 1.26, 2.52, 25.4 },
			{ 74, 3.15, 0.92, 1.84, 17.3, 1.38, 2.76, 17.3 },
			{ 75, 2.5, 1, 1.24, 0.0, 1.5, 1.5, 0.0 },
			{ 85, 2.3, 0.8, 1.6, 22.2, 1.2, 2.4, 22.2 },
			{ 90, 2.2, 0.83, 1.66, 21, 1.15, 2.3, 21 } };

	public static void Saisie() // Methode permettant la saisie des entrées
	{
		do {
			System.out.print("Veuillez saisir le departement : ");
			dept = reader.nextInt();
			if (dept <= 0 || dept > 95)
				System.out.print("Le departement saisi est incorrect\n");
		} while (dept <= 0 || dept > 95); // Tant que le departement est pas compris entre 0 et 95

		do {
			System.out.print("Veuillez saisir le type de trajet (S: Aller simple / R: Aller-Retour) : ");
			typeTrajet = reader.next().charAt(0);
			if (typeTrajet != 'S' || typeTrajet != 'R')
				System.out.print("Le type de trajet saisi est incorrect\n");
		} while (typeTrajet != 'S' && typeTrajet != 'R'); // Tant que le type de trajet n'est pas S ou R

		do {
			System.out
					.print("Veuillez saisir le jour du trajet (S: Semaine / W: Week-end) : ");
			jour = reader.next().charAt(0);
			if (jour != 'S' || jour != 'W')
				System.out.print("Le jour saisi est incorrect\n");
		} while (jour != 'S' && jour != 'W'); // Tant que le jour n'est pas S ou W

		do {
			System.out
					.print("Veuillez saisir l'heure du trajet (J: Avant 20h / N: Après 20h) : ");
			heure = reader.next().charAt(0);
			if (heure != 'J' || heure != 'N')
				System.out.print("L'heure saisi est incorrect\n");
		} while (heure != 'J' && heure != 'N'); // Tant que l'heure n'est pas J ou N

		do {
			System.out
					.print("Veuillez saisir la durée du trajet (en minutes) : ");
			duree = reader.nextInt();
			if (duree < 0)
				System.out.print("La durée saisie est incorrect\n");
		} while (duree < 0); // Tant que la durée est inferieur à 0

		do {
			System.out.print("Veuillez saisir le nombre de kilomètres : ");
			km = reader.nextInt();
			if (km < 0)
				System.out
						.print("Le nombre de kilomètres saisi est incorrect\n");
		} while (km < 0); // Tant que le nombre de kilomètres est inferieur à 0
		
		reader.close();
	}

	public static double Calcul(int departement) // Methode calculant de total des frais en fonction du departement
	{
		double prix = 0.0;

		if (typeTrajet == 'S') { // Si le trajet est un aller simple
			if (jour == 'S' && heure == 'J') { // En semaine, de jour
				prix = tarifs[departement][1] + (km * tarifs[departement][3]);
				if (duree > 60) // Et de plus d'une heure
					prix += (int) (duree / 60) * tarifs[departement][4];
			} else { // Sinon, s'il est de nuit, ou le dimanche
				prix = tarifs[departement][1] + (km * tarifs[departement][6]);
				if (duree > 60) // ET de plus d'une heure
					prix += (int) (duree / 60) * tarifs[departement][7];
			}
		} else if (typeTrajet == 'R') { // Si le trajet est un aller retour
			if (jour == 'S' && heure == 'J') { // En semaine, de jour
				prix = tarifs[departement][1] + (km * tarifs[departement][2]);
				if (duree > 60) // Et de plus d'un heure
					prix += (int) (duree / 60) * tarifs[departement][4];
			} else { // Sinon, s'il est de nuit ou le dimanche
				prix = tarifs[departement][1] + (km * tarifs[departement][5]);
				if (duree > 60) // Et de plus d'une heure
					prix += (int) (duree / 60) * tarifs[departement][7];
			}
		}

		return prix;
	}

	public static void main(String[] args) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");

		int departement = 0;

		Saisie(); // Saisie de l'utilisateur

		for (int i = 0; i < 10; i++) { // Pour toutes les lignes du tableau,
			if (tarifs[i][0] == dept) // Si un departement correspond à celui saisie
				departement = i; // Stockage de l'indice de la ligne dans le tableau
		}

		if (departement != 0) // Si un departement à été trouvé
			System.out.print("\n\nPrix : " + String.valueOf(df.format(Calcul(departement))) + "€"); // Affichage du prix
		else
			System.out.print("\n\nDépartement inconnu");
	}
}