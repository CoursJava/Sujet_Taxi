package Sujet_Taxi;

import java.util.InputMismatchException;
import Sujet_Taxi.*;

import java.util.Scanner; //Bibliothèque permettant de lire la saisie de l'utilisateur

public class main {

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
		Departement dept = new Departement();
		dept.Saisie();
		
		TypeTrajet typeTrajet = new TypeTrajet();
		typeTrajet.Saisie();
 
		Jour jour = new Jour();
		jour.Saisie();
		
		Heure heure = new Heure();
		heure.Saisie();
		
		Duree duree = new Duree();
		duree.Saisie();
		
		Km km = new Km();
		km.Saisie();
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