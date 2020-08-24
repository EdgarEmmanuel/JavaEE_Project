package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitModel {
	private String mCle;
	private ArrayList<Produit> listProds = new ArrayList<Produit>();
	
	
	public String getmCle() {
		return mCle;
	}
	public void setmCle(String mCle) {
		this.mCle = mCle;
	}
	public ArrayList<Produit> getListProds() {
		return listProds;
	}
	public void setListProds(ArrayList<Produit> listProds) {
		this.listProds = listProds;
	}
	
	
	
}
