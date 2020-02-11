/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.colis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

/**
 *
 * @author ASUS
 */
public class servicescolis {
    
    Connection c= ConnexionBD.getInstance().getCnx();
    public void ajoutercolis (colis cl)
    {
        try {
            Statement st =c.createStatement();
            String req="insert into colis values("+cl.getId_c()+",'"+cl.getDepart()+"','"+cl.getDestination()+"','"+cl.getNom_expediteur()+"','"+cl.getNom_destinataire()+"','"+cl.getPoids()+"','"+cl.getEtat()+"',0,'"+cl.getMail()+"')";
            st.executeUpdate(req);
            PreparedStatement pt = c.prepareStatement("select * from colis ORDER BY id_c DESC LIMIT 0, 1");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {            
                cl.setId_c(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifiercolisdepart(int id,String choix, String modification)
    { String ancien_depart="";
     String ancien_destination="";
     String ancien_nomex="";
     String ancien_nomdest="";
        try {
            String stat = ("select * from colis where id_c='"+id+"'");
            PreparedStatement pt1=c.prepareStatement(stat);
            ResultSet rs = pt1.executeQuery();            
            if (rs.next()) {
                
                ancien_depart = rs.getString(2);
                ancien_destination= rs.getString(3);
                ancien_nomex = rs.getString(4);
                ancien_nomdest = rs.getString(5);
            }
            PreparedStatement pt = c.prepareStatement("update colis set depart=? , destination=? , nom_expediteur=? , nom_destinataire=? where id_c=?");
            if(choix.equals("depart"))
            {
            pt.setString(1,modification);
            pt.setString(2,ancien_destination);
            pt.setString(3,ancien_nomex);
            pt.setString(4,ancien_nomdest);
            pt.setInt(5, id);
            pt.executeUpdate();
            }
            else if(choix.equals("destination"))
            {
            pt.setString(1,ancien_depart);
            pt.setString(2,modification);
            pt.setString(3,ancien_nomex);
            pt.setString(4,ancien_nomdest);
            pt.setInt(5, id);
            pt.executeUpdate();
            }
            else if(choix.equals("nom_expediteur"))
            {
            pt.setString(1,ancien_depart);
            pt.setString(2,ancien_destination);
            pt.setString(3,modification);
            pt.setString(4,ancien_nomdest);
            pt.setInt(5, id);
            pt.executeUpdate();
            }
            else if(choix.equals("nom_destinataire"))
            {
            pt.setString(1,ancien_depart);
            pt.setString(2,ancien_destination);
            pt.setString(3,ancien_nomex);
            pt.setString(4,modification);
            pt.setInt(5, id);
            pt.executeUpdate();
            }
            else 
            {
                System.out.println("verifiez votre choix!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public void affichercolis(int id)
    {
        try {
            PreparedStatement pt = c.prepareStatement("select * from colis where id_c='"+id+"'");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {            
                if(rs.getInt(6)==0)
                System.out.println("colis [ id: " +rs.getInt(1) + " depart : " + rs.getString(2) + " destination: " + rs.getString(3)+ " nom_expediteur : " + rs.getString(4)+ " nom_destinataire : " + rs.getString(5)+ " poids : " + rs.getString(6) + "kg  etat (0:n'est pas affecte,1:affectee,2:sortie,3:livree) : " + rs.getString(7) +"]");
                else
                System.out.println("colis [ id: " +rs.getInt(1) + " depart : " + rs.getString(2) + " destination: " + rs.getString(3)+ " nom_expediteur : " + rs.getString(4)+ " nom_destinataire : " + rs.getString(5)+ " poids : " + rs.getString(6) + "kg  etat (0:n'est pas affecte,1:affectee,2:sortie,3:livree) : " + rs.getString(7) + " id_voiture : " + rs.getString(8) +"]");
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("verifier votre id ! ce colis n'existe pas");
        }
    }
    public void afficherAllcolis()
    {
        try {
            PreparedStatement pt = c.prepareStatement("select * from colis ");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {            
                System.out.println("colis [ id: " +rs.getInt(1) + " depart : " + rs.getString(2) + " destination: " + rs.getString(3)+ " nom_expediteur : " + rs.getString(4)+ " nom_destinataire : " + rs.getString(5)+ " poids : " + rs.getString(6) + "kg  etat (0:n'est pas affecte,1:affectee,2:sortie,3:livree) : " + rs.getString(7) +"]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("verifier votre id ! ce colis n'existe pas");
        }
    }
    public void afficherNFcolis()
    {
        try {
            PreparedStatement pt = c.prepareStatement("select * from colis where etat=0 ");
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {            
                System.out.println("colis [ id: " +rs.getInt(1) + " depart : " + rs.getString(2) + " destination: " + rs.getString(3)+ " nom_expediteur : " + rs.getString(4)+ " nom_destinataire : " + rs.getString(5)+ " poids : " + rs.getString(6) + "kg  etat (0:n'est pas affecte,1:affectee,2:sortie,3:livree) : " + rs.getString(7) +"]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("verifier votre id ! ce colis n'existe pas");
        }
    }
    public void affecter (int idc,int idv)
    { 
     try {
            PreparedStatement pt = c.prepareStatement("update colis set id_v=? where id_c=?");
            pt.setInt(1,idv);
            pt.setInt(2,idc);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifieretat (int etat, int idc)
    {
         try {
            PreparedStatement pt = c.prepareStatement("update colis set etat=? where id_c=?");
            pt.setInt(1,etat);
            pt.setInt(2,idc);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimercolis (int id)
    {    System.out.println("Attention !! l'annulation est possible si seulement le colis n'est pas encore affecte");
        try {
            PreparedStatement pt = c.prepareStatement("delete from colis where id_c=? and  etat=0 ");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public String cherchermail (int id)
    { String mail="";
       try {
            PreparedStatement pt = c.prepareStatement("select * from colis where id_c='"+id+"' ");
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {            
                //System.out.println("colis [ id: " +rs.getInt(1) + " depart : " + rs.getString(2) + " destination: " + rs.getString(3)+ " nom_expediteur : " + rs.getString(4)+ " nom_destinataire : " + rs.getString(5)+ " poids : " + rs.getString(6) + "kg  etat (0:n'est pas affecte,1:affectee,2:sortie,3:livree) : " + rs.getString(7) +"]");
                mail=rs.getString(9);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicescolis.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("verifier votre id ! ce colis n'existe pas");
        } 
       return mail ;
    }
    
    
    
}
