package Sujet_Taxi;

public class TypeTrajet {
	char typeTrajet;

	public TypeTrajet() { //Constructeur par defaut
		typeTrajet = ' ';
	}
	
	public char Value(){
		return typeTrajet;
	}
	
	public void Saisie(){
		do {
			System.out.print("Veuillez saisir le type de trajet (S: Aller simple / R: Aller-Retour) : ");
			typeTrajet = main.reader.next().charAt(0);
			if (typeTrajet != 'S' || typeTrajet != 'R')
				System.out.print("Le type de trajet saisi est incorrect\n");
		} while (typeTrajet != 'S' && typeTrajet != 'R'); // Tant que le type de trajet n'est pas S ou R
	}
}
