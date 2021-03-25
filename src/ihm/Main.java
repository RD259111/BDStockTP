package ihm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import persistance.DAO.CategorieDaoImpl;
import persistance.DAO.ClientDaoImpl;
import persistance.DAO.CommandeDaoImpl;
import persistance.DAO.ProduitDaoImpl;
import persistance.entities.Categorie;
import persistance.entities.Client;
import persistance.entities.Commande;
import persistance.entities.CommandeId;
import persistance.entities.Produit;

public class Main {

	static List<Commande> listCommandes = new ArrayList<Commande>();

	public static void main(String[] args) {
		Categorie categorie = new Categorie(new BigDecimal(2), "a", "b", new HashSet<Produit>());
		Produit produit = new Produit(new BigDecimal(2), categorie, "eau", new BigDecimal(5.2), new BigDecimal(4),
				"bouteille", "cristaline", "bouteille eau", new HashSet<Commande>());
		Client client = new Client(new BigDecimal(2), null, null, "goulum", null, null, null, null, null, null, null,
				null, "00.00.00.00.00", null, null, "test@test.com", new HashSet<Commande>());

		CommandeId commandeId = new CommandeId(produit.getIdproduit(), client.getIdclient());
		Commande commande = new Commande(commandeId, client, produit, new BigDecimal(4), new Date(), new BigDecimal(5));

		// Ajout à la Database

		CategorieDaoImpl daoCategorie = new CategorieDaoImpl();
		daoCategorie.add(categorie);

		ProduitDaoImpl daoProduit = new ProduitDaoImpl();
		daoProduit.add(produit);

		ClientDaoImpl daoClient = new ClientDaoImpl();
		daoClient.add(client);

		CommandeDaoImpl daoCommande = new CommandeDaoImpl();
		daoCommande.add(commande);

		listCommandes = daoCommande.findAll();
		for (Commande cc : listCommandes) {
			CommandeId cid = cc.getId();
			System.out.println("idclient = " + cid.getIdclient() + " idproduit = " + cid.getIdproduit());
		}
	}
}