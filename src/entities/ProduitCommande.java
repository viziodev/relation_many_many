package entities;

public class ProduitCommande {
    private int id;
    private int qteComd;
    
    private Commande commande;
    private Produit produit;

    public Commande getCommande() {
        return commande;
    }
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
 

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQteComd() {
        return qteComd;
    }
    public void setQteComd(int qteComd) {
        this.qteComd = qteComd;
    }
    public Produit getProduit() {
        return produit;
    }
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
}
