package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitImpl;
import metier.entities.Produit;

@WebServlet(name="cs",urlPatterns = {"*.php"})
public class controlleurServlet extends HttpServlet {
	private IProduitDao prod;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7094772059403290338L;
	
	@Override
	public void init() throws ServletException {
		prod = new ProduitImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getServletPath().equalsIgnoreCase("/front.php")) {
			RequestDispatcher rd = req.getRequestDispatcher("produits.jsp");
			rd.forward(req, res);
		}else if(req.getServletPath().equalsIgnoreCase("/add.php")) {
			RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
			rd.forward(req, res);
		}else if(req.getServletPath().equalsIgnoreCase("/modifier.php")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			
			Produit pro = prod.getProduit(id);
			
			req.setAttribute("produit", pro);
			
			req.getRequestDispatcher("modifier.jsp").forward(req, res);
			
		}else if(req.getServletPath().equalsIgnoreCase("/supprimer.php")) {
			int id = Integer.parseInt(req.getParameter("id"));
			int ok = prod.Delete(id);
			req.setAttribute("message", "SUPPRESSION EFFECTUE AVEC SUCCESS!!!");
			req.getRequestDispatcher("confirmation.jsp").forward(req, res);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String motCle = req.getParameter("cle");
		
		String path = req.getServletPath();
		
		if(path.equalsIgnoreCase("/index.php")) {
			ProduitModel md = new ProduitModel();
			md.setmCle(motCle);
			ArrayList<Produit> prods = prod.prodByMc("%"+motCle+"%");
			md.setListProds(prods);
			
			//insert in the request attribute 
			req.setAttribute("model",md);
			
			
			RequestDispatcher rd = req.getRequestDispatcher("produits.jsp");
			rd.forward(req, res);
		}else if(path.equalsIgnoreCase("/addPro.php")){
			
			//get the form data
			double prix = Double.parseDouble(req.getParameter("prix"));
			double qte = Double.parseDouble(req.getParameter("quantite"));
			String designation = req.getParameter("designation");
			
			//create an instance of product
			Produit pro = new Produit();
			pro.setDesignation(designation);
			pro.setPrix(prix);
			pro.setQuantite(qte);
			
			//insert and fetch the result 
			Produit p = prod.save(pro);
			
			req.setAttribute("produit", p);
			
			RequestDispatcher rd = req.getRequestDispatcher("confirmation.jsp");
			rd.forward(req, res);
			
		}else if(req.getServletPath().equalsIgnoreCase("/modify.php")){
			String name = req.getParameter("designation");
			Double prix = Double.parseDouble(req.getParameter("prix"));
			Double qte = Double.parseDouble(req.getParameter("quantite"));
			int id = Integer.parseInt(req.getParameter("idProd"));
			
			int ok = prod.update(id, prix, qte, name);
			
			if(ok!=0) {
				req.setAttribute("message", "MIS A JOUR EFFECTUE AVEC SUCCES");
				req.getRequestDispatcher("confirmation.jsp").forward(req, res);
			}
			
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("produits.jsp");
			rd.forward(req,res);
		}
	}
	
	

}
