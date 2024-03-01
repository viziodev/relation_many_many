package entities;

import java.util.ArrayList;
import java.util.List;

public class Produit {
    private int id;
    private String libelle;
    private int prixUnitaire;
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
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public int getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
