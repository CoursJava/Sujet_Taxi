package Sujet_Taxi;

import java.util.ArrayList;
import java.util.List;
import Sujet_Taxi.Saisies;

public class Taxi {
	//Objets
	static Saisies saisies = new Saisies();
	static List<Tarif> tarifs = new ArrayList<Tarif>();
	
	static double[][] array_tarifs = {
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
	
	/**
	 * Fonction de recherche de la grille de tarifs correspondante au departement saisi
	 * @return indice (int)
	 */
	public static int Recherche()
	{
		int indice = -1;
		for (int i = 0; i < 10; i++) { // Pour toutes les lignes du tableau,
			if (tarifs.get(i).getDepartement() == saisies.getDepartement()){ // Si un departement correspond à celui saisie
				indice = i; // Stockage de l'indice de la ligne dans le tableau
				break;
			}
		}
		return indice;
	}

	/**
	 * Fonction de calcul du prix à payer en fonction du département saisi
	 * @param indiceDept (int)
	 * @return prix (double)
	 */
	public static double Calcul(int indiceDept)
	{
		double prix = 0.0;

		if (saisies.getTypeTrajet() == 's') { // Si le trajet est un aller simple
			if (saisies.getJour() == 's' && saisies.getHeure() == 'j') { // En semaine, de jour
				prix = tarifs.get(indiceDept).getPriseEnCharge() + (saisies.getKm() * tarifs.get(indiceDept).getKmAlleSimpleJourSem());
				if (saisies.getDuree() > 60) // Et de plus d'une heure
					prix += (int) (saisies.getDuree() / 60) * tarifs.get(indiceDept).getTarifHoraireJourSem();
			} else { // Sinon, s'il est de nuit, ou le dimanche
				prix = tarifs.get(indiceDept).getPriseEnCharge() + (saisies.getKm() * tarifs.get(indiceDept).getKmAlleSimpleNuitDim());
				if (saisies.getDuree() > 60) // ET de plus d'une heure
					prix += (int) (saisies.getDuree() / 60) * tarifs.get(indiceDept).getTarifHoraireNuitDim();
			}
		} else if (saisies.getTypeTrajet() == 'r') { // Si le trajet est un aller retour
			if (saisies.getJour() == 's' && saisies.getHeure() == 'j') { // En semaine, de jour
				prix = tarifs.get(indiceDept).getPriseEnCharge() + (saisies.getKm() * tarifs.get(indiceDept).getKmAlleRetourJourSem());
				if (saisies.getDuree() > 60) // Et de plus d'un heure
					prix += (int) (saisies.getDuree() / 60) * tarifs.get(indiceDept).getTarifHoraireJourSem();
			} else { // Sinon, s'il est de nuit ou le dimanche
				prix = tarifs.get(indiceDept).getPriseEnCharge() + (saisies.getKm() * tarifs.get(indiceDept).getKmAlleRetourNuitDim());
				if (saisies.getDuree() > 60) // Et de plus d'une heure
					prix += (int) (saisies.getDuree() / 60) * tarifs.get(indiceDept).getTarifHoraireNuitDim();
			}
		}

		return prix;
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {		
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
		
		//Implémentation des grilles de tarifs
		for(int i = 0; i < array_tarifs.length; i++){
			tarifs.add(new Tarif((int)(array_tarifs[i][0]), array_tarifs[i][1], array_tarifs[i][2], array_tarifs[i][3], array_tarifs[i][4], array_tarifs[i][5], array_tarifs[i][6], array_tarifs[i][7]));
		}

		saisies.Saisie();

		if (Recherche() != -1) // Si un departement à été trouvé
			System.out.print("\n\nPrix : " + String.valueOf(df.format(Calcul(Recherche()))) + "€"); // Affichage du prix
		else
			System.out.print("\n\nDépartement inconnu");
	}
}