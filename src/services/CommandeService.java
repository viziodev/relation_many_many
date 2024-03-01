package services;

import java.util.List;

import entities.Commande;
import entities.ProduitCommande;
import repositories.CommandeRepository;
import repositories.ProduitCommandeRepository;


public class CommandeService {
      private CommandeRepository commandeRepository=new CommandeRepository();
      private ProduitCommandeRepository produitCommandeRepository=new ProduitCommandeRepository();
      public  void creerCommande(Commande commande){
        //Transaction
         commandeRepository.insert(commande);
         Commande lastCommande= commandeRepository.selectLastCommande();
         List<ProduitCommande> produitCommandes = commande.getProduitCommandes();
         for (ProduitCommande pc  : produitCommandes) {
            pc.setCommande(lastCommande);
            produitCommandeRepository.insert(pc);
         }

      }

      public  Commande RecupererCommandeParNumero(String numero){
          return commandeRepository.selectCommandeByNum(numero);
      }
}
