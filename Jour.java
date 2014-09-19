package Sujet_Taxi;

public class Jour {
	private char jour;

	public Jour() { //Constructeur par defaut
		jour = ' ';
	}
	
	public char Value(){
		return jour;
	}
	
	public void Saisie(){
		do {
			System.out.print("Veuillez saisir le jour du trajet (S: Semaine / W: Week-end) : ");
			jour = main.reader.next().toLowerCase().charAt(0);
			if (jour != 'S' || jour != 'W')
				System.out.print("Le jour saisi est incorrect\n");
		} while (jour != 'S' && jour != 'W'); // Tant que le jour n'est pas S ou W
	}

}
