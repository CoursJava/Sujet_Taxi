package Sujet_Taxi;

public class Tarif {
	// Attributs //
	private int departement;
	private double priseEnCharge, kmAlleRetourJourSem, kmAlleSimpleJourSem, kmAlleRetourNuitDim, kmAlleSimpleNuitDim, tarifHoraireJourSem, tarifHoraireNuitDim;

	// Constructeurs //
	/**
	 * Constructeur avec initialisation à partir de paramètres
	 * 
	 * @param Numéro du département (int)
	 * @param Prise en charge (double)
	 * @param Tarif kilométrique Allé/Retour d'un jour de semaine (double)
	 * @param Tarif kilométrique Allé Simple d'un jour de semaine (double)
	 * @param Tarif kilométrique Allé/Retour de nuit ou le dimanche (double)
	 * @param Tarif kilométrique Allé Simple de nuit ou le dimanche (double)
	 * @param Tarif horaire d'un jour de semaine (double)
	 * @param Tarif horaire de nuit ou le dimanche (double)
	 */
	public Tarif(int departement, double priseEnCharge, double kmAlleRetourJourSem, double kmAlleSimpleJourSem, double kmAlleRetourNuitDim, double kmAlleSimpleNuitDim, double tarifHoraireJourSem, double tarifHoraireNuitDim) {
		this.departement = departement;
		this.priseEnCharge = priseEnCharge;
		this.kmAlleRetourJourSem = kmAlleRetourJourSem;
		this.kmAlleSimpleJourSem = kmAlleSimpleJourSem;
		this.kmAlleRetourNuitDim = kmAlleRetourNuitDim;
		this.kmAlleSimpleNuitDim = kmAlleSimpleNuitDim;
		this.tarifHoraireJourSem = tarifHoraireJourSem;
		this.tarifHoraireNuitDim = tarifHoraireNuitDim;
	}

	// Accesseurs
	/**
	 * Accesseur du département
	 * 
	 * @return Numéro du département (int)
	 */
	public double getDepartement(){
		return departement;
	}

	/**
	 * Accesseur du montant de la prise en charge
	 * @return Montant de prise en charge (double)
	 */
	public double getPriseEnCharge(){
		return priseEnCharge;
	}

	/**
	 * Accesseur du tarif kilométrique d'un Allé/Retour lors d'un jour de semaine
	 * @return Tarif kilométrique Allé/Retour d'un jour de semaine (double)
	 */
	public double getKmAlleRetourJourSem(){
		return kmAlleRetourJourSem;
	}

	/**
	 * Accesseur du tarif kilométrique d'un Allé Simple lors d'un jour de semaine
	 * @return Tarif kilométrique Allé Simple d'un jour de semaine (double)
	 */
	public double getKmAlleSimpleJourSem(){
		return kmAlleSimpleJourSem;
	}

	/**
	 * Accesseur du tarif kilométrique d'un Allé/Retour de nuit ou le dimanche
	 * @return Tarif kilométrique Allé/Retour de nuit ou le dimanche (double)
	 */
	public double getKmAlleRetourNuitDim(){
		return kmAlleRetourNuitDim;
	}

	/**
	 * Accesseur du tarif kilométrique d'un Allé Simple de nuit ou le dimanche
	 * @return Tarif kilométrique Allé Simple de nuit ou le dimanche (double)
	 */
	public double getKmAlleSimpleNuitDim(){
		return kmAlleSimpleNuitDim;
	}

	/**
	 * Accesseur du tarif horaire d'un jour de semaine
	 * @return Tarif horaire d'un jour de semaine (double)
	 */
	public double getTarifHoraireJourSem(){
		return tarifHoraireJourSem;
	}

	/**
	 * Accesseur du tarif horaire de nuit ou le dimanche
	 * @return Tarif horaire de nuit ou le dimanche (double)
	 */
	public double getTarifHoraireNuitDim(){
		return tarifHoraireNuitDim;
	}
}