package Sujet_Taxi;

public class Heure {
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
			heure = main.reader.next().toLowerCase().charAt(0);
			if (heure != 'J' || heure != 'N')
				System.out.print("L'heure saisi est incorrect\n");
		} while (heure != 'J' && heure != 'N'); // Tant que l'heure n'est pas J ou N
	}

}
