package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		Connection conn = SingleConnex.getConnex();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO produits VALUES(null,?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setDouble(3, p.getQuantite());
			int ok = ps.executeUpdate();
			if(ok!=0) {
				PreparedStatement stmt2 = conn.prepareStatement("SELECT MAX(id_prod) as max from produits ");
				ResultSet rs = stmt2.executeQuery();
				if(rs.next()) {
					p.setId(rs.getInt("max"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public ArrayList<Produit> prodByMc(String mc) {
		Connection conn = SingleConnex.getConnex();
		String sql = "SELECT * FROM produits WHERE  designation LIKE '"+mc+"'";
		ArrayList<Produit> listes = new ArrayList<Produit>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Produit p = new Produit();
				p.setId(rs.getInt("id_prod"));
				p.setPrix(rs.getDouble("prix"));
				p.setDesignation(rs.getString("designation"));
				p.setQuantite(rs.getDouble("quantite"));
				listes.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listes;
	}

	@Override
	public Produit getProduit(int id) {
		Connection conn = SingleConnex.getConnex();
		Produit prod = new Produit();
		try {
			PreparedStatement pr = conn.prepareStatement("SELECT * FROM produits WHERE id_prod=?");
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if(rs.next()){
				prod = new Produit();
				prod.setId(id);
				prod.setQuantite(rs.getDouble("quantite"));
				prod.setPrix(rs.getDouble("prix"));
				prod.setDesignation(rs.getString("designation"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public int update(int id,double prix , double qte , String name) {
		Connection conn = SingleConnex.getConnex();
		int ok=0;
		String sql = "UPDATE produits set designation=? , quantite=? , prix=? where id_prod=?";
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, name);
			pr.setDouble(2, qte);
			pr.setDouble(3, prix);
			pr.setInt(4, id);
			
			ok = pr.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public int Delete(int id) {
		Connection conn = SingleConnex.getConnex();
		String sql = "DELETE FROM produits WHERE id_prod=?";
		int ok =0;
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, id);
			ok = pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

}
