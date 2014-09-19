package Sujet_Taxi;

import java.util.Scanner;

public class Departement {
	
	private Scanner reader = new Scanner(System.in);
	private int dept;

	public Departement() { //Constructeur par defaut
		dept = 0;
	}
	
	public Departement(int dept) {
		this.dept = dept;
	}
	
	public int Saisie(){
		do {
			System.out.print("Veuillez saisir le departement : ");
			dept = reader.nextInt();
			if (dept <= 0 || dept > 95)
				System.out.print("Le departement saisi est incorrect\n");
		} while (dept <= 0 || dept > 95); // Tant que le departement est pas compris entre 0 et 95
		
		reader.close();
		return dept;
	}
}
