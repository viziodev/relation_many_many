package entities;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id;
    private String numero;
    private int montant;
    private List<ProduitCommande> produitCommandes=new ArrayList<>();

    public List<ProduitCommande> getProduitCommandes() {
        return produitCommandes;
    }
    public void setProduitCommandes(List<ProduitCommande> produitCommandes) {
        this.produitCommandes = produitCommandes;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public int getMontant() {
        return montant;
    }
    public void setMontant(int montant) {
        this.montant = montant;
    }
}
