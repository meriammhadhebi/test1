/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;
import entities.vehicule;
/**
 *
 * @author ASUS
 */
public class servicesvehicule {
    
    Connection c= ConnexionBD.getInstance().getCnx();
   
    
       public void affichervehicule(String type,String position,String destination)
    {
        int dispo =1;
        try {
            PreparedStatement pt = c.prepareStatement("select * from vehicule where type = '"+type+"' and  dispo ='"+dispo+"'  ");
            ResultSet rs = pt.executeQuery();
            
            while (rs.next()) {  
                if (type.equals("Taxi"))
                {
                if(position.equals(rs.getString(9)))
                {
                    System.out.println("des taxis disponible dans votre zone");
                System.out.println("vehicule [ id_v: " +rs.getInt(1) + "  marque : " + rs.getString(3) + "  modele: " + rs.getString(4)+ "  couleur:" +rs.getString(6)+ "  position: " +rs.getString(9) + "]");
                }
                else {
                    System.out.println("des taxis disponible un peu loin de votre zone");
                System.out.println("vehicule [ id_v: " +rs.getInt(1) + "  marque : " + rs.getString(3) + "  modele: " + rs.getString(4)+ "  couleur:" +rs.getString(6)+ "  position: " +rs.getString(9) + "]");
                        }
                }
                else if (type.equals("co-voiturage"))
                {
                if(position.equals(rs.getString(9)) & destination.equals(rs.getString(10)) )
                {
                    System.out.println("des co-voiturage disponible a votre pt de depart et qui partent a la destination demandee");
                System.out.println("vehicule [ id_v: " +rs.getInt(1) + "  marque : " + rs.getString(3) + "  modele: " + rs.getString(4)+ "  couleur:" +rs.getString(6)+ "  position: " +rs.getString(9) +  "  destination: " +rs.getString(10) + "]");
                }
                else {
                    System.out.println("des co-voiturage disponible un peu loin de votre pt de depart ou votre destination demandee");
                System.out.println("vehicule [ id_v: " +rs.getInt(1) + "  marque : " + rs.getString(3) + "  modele: " + rs.getString(4)+ "  couleur:" +rs.getString(6)+ "  position: " +rs.getString(9) +  "  destination: " +rs.getString(10) +"]");
                        }
                }
            }
            
             
            
        } catch (SQLException ex) {
            Logger.getLogger(servicesvehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
  
      public void vehiculeAFC(int idc)
    {
        int dispo =1;
        String depart="";
        String destination="";
        try {
            String stat = ("select * from colis where id_c='"+idc+"'");
            PreparedStatement pt1=c.prepareStatement(stat);
            ResultSet rs1 = pt1.executeQuery();            
            if (rs1.next()) {
                
                depart = rs1.getString(2);
                destination= rs1.getString(3);
            }
            PreparedStatement pt = c.prepareStatement("select * from vehicule where dispo ='"+dispo+"' and position='"+depart+"' and destination='"+destination+"'  ");
            ResultSet rs = pt.executeQuery();
             System.out.println("Liste des vehicule partant de "+depart);
             System.out.println("vers "+destination);
            while (rs.next()) 
                {  
                System.out.println("vehicule [ id_v: " +rs.getInt(1) + "  marque : " + rs.getString(3) + "  modele: " + rs.getString(4)+ "  couleur:" +rs.getString(6)+ "  position: " +rs.getString(9) + "  destination: " +rs.getString(10) + "]");
                
                }
             } catch (SQLException ex) {
            Logger.getLogger(servicesvehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
