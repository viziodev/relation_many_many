package services;

import java.util.List;

import entities.Produit;
import repositories.ProduitRepository;

public class ProduitService {
      private ProduitRepository produitRepository=new ProduitRepository();
    public  void creerProduit(Produit produit){
        produitRepository.insert(produit);
      }

      public   List<Produit >listerProduit(){
         return produitRepository.select();
      }
      public  Produit RechercherProduitParId(int id){
        return produitRepository.selectById(id);
      }


}
