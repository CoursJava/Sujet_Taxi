package Sujet_Taxi;

public class Departement {
	int dept;

	public Departement() { //Constructeur par defaut
		dept = 0;
	}
	
	public int Value(){
		return dept;
	}
	
	public void Saisie(){
		do {
			System.out.print("Veuillez saisir le departement : ");
			dept = main.reader.nextInt();
			if (dept <= 0 || dept > 95)
				System.out.print("Le departement saisi est incorrect\n");
		} while (dept <= 0 || dept > 95); // Tant que le departement est pas compris entre 0 et 95
	}
	
	public int Indice(){
		int indice = 0;
		for (int i = 0; i < 10; i++) { // Pour toutes les lignes du tableau,
			if (main.tarifs[i][0] == dept) // Si un departement correspond à celui saisie
				indice = i; // Stockage de l'indice de la ligne dans le tableau
		}
		
		return indice;
	}
}
