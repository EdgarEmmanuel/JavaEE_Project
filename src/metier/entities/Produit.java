package metier.entities;

import java.io.Serializable;

public class Produit implements Serializable {
	private int id;
	private double quantite;
	private double prix;
	private String designation;
	
	public Produit() {
		
	}
	

	@Override
	public String toString() {
		return "Produit [id=" + id + ", quantite=" + quantite + ", prix=" + prix + ", designation=" + designation + "]";
	}


	public int getId(){
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Produit(int id ,double quantite, double prix, String designation) {
		this.quantite = quantite;
		this.prix = prix;
		this.designation = designation;
		this.id = id;
	}

	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
}
