package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Produit;

public class ProduitRepository extends Database{
    private final String SQL_INSERT="INSERT INTO `produit` (`libelle_prod`, `pu_prod`) VALUES (?, ?);";
    private final String SQL_SELECT="SELECT * FROM `produit` ";
    private final String SQL_SELECT_BY_ID="SELECT * FROM `produit` where id_prod=? ";
    public void insert(Produit produit){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT);
              statement.setString(1, produit.getLibelle());
              statement.setInt(2, produit.getPrixUnitaire());
             executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  List<Produit>select(){
        List<Produit> produits=new ArrayList<>();
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT);
       
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Produit produit=new Produit(); 
                produit.setId(rs.getInt("id_prod")); 
                produit.setLibelle(rs.getString("libelle_prod")); 
                produit.setPrixUnitaire(rs.getInt("pu_prod")); 
                produits.add(produit)  ;    
            }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return produits;
      }

      public  Produit selectById(int id){
        Produit produit=null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                produit=new Produit(); 
                produit.setId(rs.getInt("id_prod")); 
                produit.setLibelle(rs.getString("libelle_prod")); 
                produit.setPrixUnitaire(rs.getInt("pu_prod")); 
             
            }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return produit;
      }

    
}
