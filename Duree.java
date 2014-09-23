package Sujet_Taxi;

public class Duree {
	private int duree;
	
	public Duree() { //Constructeur par defaut
		duree = 0;
	}
	
	public int Value(){
		return duree;
	}
	
	public void Saisie(){
		do {
			System.out.print("Veuillez saisir la durée du trajet (en minutes) : ");
			duree = main.reader.nextInt();
			if (duree < 0)
				System.out.print("La durée saisie est incorrect\n");
		} while (duree < 0); // Tant que la durée est inferieur à 0
	}

}
