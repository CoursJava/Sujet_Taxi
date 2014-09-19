package Sujet_Taxi;

import Sujet_Taxi.*;

public class main {

	// Objets
	static Departement dept = new Departement();
	static TypeTrajet typeTrajet = new TypeTrajet();
	static Jour jour = new Jour();
	static Heure heure = new Heure();
	static Duree duree = new Duree();
	static Km km = new Km();

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
		dept.Saisie();
		typeTrajet.Saisie();
		jour.Saisie();
		heure.Saisie();
		duree.Saisie();
		km.Saisie();
	}

	public static double Calcul(int indiceDept) // Methode calculant de total des frais en fonction du departement
	{
		double prix = 0.0;

		if (typeTrajet.Value() == 'S') { // Si le trajet est un aller simple
			if (jour.Value() == 'S' && heure.Value() == 'J') { // En semaine, de jour
				prix = tarifs[indiceDept][1] + (km.Value() * tarifs[indiceDept][3]);
				if (duree.Value() > 60) // Et de plus d'une heure
					prix += (int) (duree.Value() / 60) * tarifs[indiceDept][4];
			} else { // Sinon, s'il est de nuit, ou le dimanche
				prix = tarifs[indiceDept][1] + (km.Value() * tarifs[indiceDept][6]);
				if (duree.Value() > 60) // ET de plus d'une heure
					prix += (int) (duree.Value() / 60) * tarifs[indiceDept][7];
			}
		} else if (typeTrajet.Value() == 'R') { // Si le trajet est un aller retour
			if (jour.Value() == 'S' && heure.Value() == 'J') { // En semaine, de jour
				prix = tarifs[indiceDept][1] + (km.Value() * tarifs[indiceDept][2]);
				if (duree.Value() > 60) // Et de plus d'un heure
					prix += (int) (duree.Value() / 60) * tarifs[indiceDept][4];
			} else { // Sinon, s'il est de nuit ou le dimanche
				prix = tarifs[indiceDept][1] + (km.Value() * tarifs[indiceDept][5]);
				if (duree.Value() > 60) // Et de plus d'une heure
					prix += (int) (duree.Value() / 60) * tarifs[indiceDept][7];
			}
		}

		return prix;
	}

	public static void main(String[] args) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");

		Saisie(); // Saisie de l'utilisateur

		if (dept.Indice() != 0) // Si un departement à été trouvé
			System.out.print("\n\nPrix : " + String.valueOf(df.format(Calcul(dept.Indice()))) + "€"); // Affichage du prix
		else
			System.out.print("\n\nDépartement inconnu");
	}
}