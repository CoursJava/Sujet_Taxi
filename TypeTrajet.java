package Sujet_Taxi;

import java.util.Scanner;

public class TypeTrajet {
	
	private Scanner reader = new Scanner(System.in);
	private char typeTrajet;

	public TypeTrajet() { //Constructeur par defaut
		typeTrajet = ' ';
	}
	
	public TypeTrajet(char typeTrajet) {
		this.typeTrajet = typeTrajet;
	}
	
	public char Saisie(){
		do {
			System.out.print("Veuillez saisir le type de trajet (S: Aller simple / R: Aller-Retour) : ");
			typeTrajet = reader.next().charAt(0);
			if (typeTrajet != 'S' || typeTrajet != 'R')
				System.out.print("Le type de trajet saisi est incorrect\n");
		} while (typeTrajet != 'S' && typeTrajet != 'R'); // Tant que le type de trajet n'est pas S ou R
		
		reader.close();
		return typeTrajet;
	}
}
