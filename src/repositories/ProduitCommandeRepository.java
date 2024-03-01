package repositories;

import java.sql.SQLException;

import entities.ProduitCommande;
public class ProduitCommandeRepository extends Database {
    private final String SQL_INSERT="INSERT INTO `produit_commande` (`qte_cmde`, `produit_id`, `cmde_id`) VALUES (?, ?, ?);";
    public void insert(ProduitCommande  produitCommande){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT);
             statement.setInt(1,produitCommande.getQteComd());
             statement.setInt(2,produitCommande.getProduit().getId());
             statement.setInt(3,produitCommande.getCommande().getId());
             executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 
}
