import java.util.List;
import java.util.Scanner;

import entities.Commande;
import entities.Produit;
import entities.ProduitCommande;
import services.CommandeService;
import services.ProduitService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        ProduitService produitService=new ProduitService();
        CommandeService commandeService=new CommandeService();
        
        int choix;
        do{
            System.out.println("1-Creer Produit");
            System.out.println("2-Lister les  Produit");
            System.out.println("3-Creer une commande");
            System.out.println("4-Lister les produits d'une commande");
            System.out.println("5-Quitter");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
              case 1:
                Produit produit=new Produit();
                System.out.println("Entrer le Libelle");
                produit.setLibelle(scanner.nextLine());
                System.out.println("Entrer le PU");
                produit.setPrixUnitaire(scanner.nextInt());
                produitService.creerProduit(produit);
              break;

              case 2:
              List<Produit> listerProduit = produitService.listerProduit();
              for (Produit p : listerProduit) {
                System.out.println("ID :"+p.getId());
                System.out.println("Libelle :"+p.getLibelle());
                System.out.println("PU: "+p.getPrixUnitaire());
              }
              break;

              case 3:
                Commande commande=new Commande();
                //1-Donner les Infos de commande (Numero)
                  System.out.println("Entrer le Numero");
                  commande.setNumero(scanner.nextLine());
                //2-Ajouter 1 ou plusieurs produits a la commande 
                    //Apres chaque ajout recalculer le montant
                    listerProduit = produitService.listerProduit();
                    int response;
                    int montant=0;
                    do {
                        for (Produit p : listerProduit) {
                            System.out.println(p.getId()+"-"+p.getLibelle()+"-"+p.getPrixUnitaire());
                          }
                         System.out.println("Veuillez selectionner un produit pour l'ajouter dans la commande");
                          int idProd=scanner.nextInt(); 
                          produit= produitService.RechercherProduitParId(idProd);
                          if (produit!=null) {
                             System.out.println("Entrer la Qte Commande");
                             int QteComd=scanner.nextInt();
                             montant=montant+(QteComd*produit.getPrixUnitaire());
                             ProduitCommande produitCommande=new ProduitCommande();
                             produitCommande.setQteComd(QteComd);
                             produitCommande.setProduit(produit);
                             commande.getProduitCommandes().add(produitCommande);

                          }else{
                             System.out.println("Cet Id n'existe pas");
                          } 
                          System.out.println("Montant : "+montant);
                         
                         System.out.println("Voulez continuez 1-Oui 2-Non"); 
                         response=scanner.nextInt(); 
                       
                    } while (response==1);

                    if (commande.getProduitCommandes().size()==0) {
                          System.out.println("La commande doit contenir au moins un produit");
                    }else{
                        commande.setMontant(montant);
                        commandeService.creerCommande(commande);
                    }
                    
                  
              break;

              case 4:
               System.out.println("Entrer le Numero");
               String numero=scanner.nextLine();
               commande=commandeService.RecupererCommandeParNumero(numero);
                   if (commande != null) {
                       System.out.println("Numero :"+commande.getNumero()+" Montant :"+commande.getMontant());
                       List<ProduitCommande> produitCommandes=commande.getProduitCommandes();
                     
                       for (ProduitCommande pc : produitCommandes) {
                          System.out.println("----------------------------------------------------");
                          System.out.println("Libelle "+pc.getProduit().getLibelle()+" Qte Cmde   "+pc.getQteComd());
                        }
                       System.out.println("Montant : "+commande.getMontant());
                 }
              break;
           }
       }while(choix !=5);
}
}
