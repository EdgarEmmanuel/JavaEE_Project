package dao;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public interface IProduitDao {
	public Produit save(Produit p);
	public ArrayList<Produit> prodByMc(String mc);
	public Produit getProduit(int id);
	public int update(int id,double prix , double qte , String name);
	public int Delete(int id);
}
