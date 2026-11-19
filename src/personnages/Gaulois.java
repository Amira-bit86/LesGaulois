package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
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
		romain.recevoirCoup((force * effetPotion) / 3);
		if (effetPotion > 1) {
			effetPotion--;
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	@Override
	public String toString() {
		return nom;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
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
}