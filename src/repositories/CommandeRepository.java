package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Commande;
import entities.Produit;
import entities.ProduitCommande;


public class CommandeRepository  extends Database{
    private final String SQL_INSERT="INSERT INTO `commande` ( `numero_cmde`, `montant_cmde`) VALUES (?,?);";
    private final String SQL_LAST_VALUE_INSERT="SELECT Max(`id_cmde`) as max FROM `commande`";
    private final String SQL_SELECT_CMDE_NUM="SELECT * FROM `commande` c,produit_commande pc,produit p WHERE c.`id_cmde`=pc.cmde_id and pc.produit_id=p.id_prod and `numero_cmde` like ?";
    public void insert(Commande  commande){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT);
             statement.setString(1,commande.getNumero());
             statement.setInt(2,commande.getMontant());
             executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  Commande selectLastCommande(){
        Commande commande=null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_LAST_VALUE_INSERT);
     
            ResultSet rs = executeSelect();
            while (rs.next()) {
                commande=new Commande(); 
                commande.setId(rs.getInt("max")); 
             
            }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return commande;
      }

      public  Commande selectCommandeByNum(String numero){
        Commande commande=null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_CMDE_NUM);
           statement.setString(1, numero);
            ResultSet rs = executeSelect();
            commande=new Commande(); 
            while (rs.next()) {
                //Produits
                   Produit produit=new Produit(); 
                   produit.setId(rs.getInt("id_prod")); 
                   produit.setLibelle(rs.getString("libelle_prod")); 
                   produit.setPrixUnitaire(rs.getInt("pu_prod")); 
                 //Commande 
                  
                   commande.setId(rs.getInt("id_cmde")); 
                   commande.setMontant(rs.getInt("montant_cmde")); 
                   commande.setNumero(rs.getString("numero_cmde")); 
                //Qte Cmde
                int qteComd=rs.getInt("qte_cmde");

                //Produit Commande 
                 ProduitCommande produitCommande=new ProduitCommande();
                 produitCommande.setProduit(produit);
                 produitCommande.setQteComd(qteComd);
                 commande.getProduitCommandes().add(produitCommande);
            }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return commande;
      }
}
