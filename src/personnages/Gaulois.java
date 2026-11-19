package personnages;

import objets.Equipement;
import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	private Village village;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesBataille[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		String texte = "Bonjour, je m'appelle " + nom + ". ";
		if (village == null) {
			texte += "Je voyage de villages en villages.";
		} else if (village.getChef() == this) {
			texte += "Je suis le chef le village : " + village.getNom() + ".";
		} else {
			texte += "J'habite le village : " + village.getNom() + ".";
		}
		parler(texte);
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
}