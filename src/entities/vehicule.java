/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author ASUS
 */
public class vehicule {
    private int id_v,dispo;
    private String matricule,marque,modele,cartegrise,couleur,type,position,destination;

    public vehicule(int id_v, int dispo, String matricule, String marque, String modele, String cartegrise, String couleur, String type, String position) {
        this.id_v = id_v;
        this.dispo = dispo;
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.cartegrise = cartegrise;
        this.couleur = couleur;
        this.type = type;
        this.position = position;
    }

    

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "vehicule{" + "id_v=" + id_v + ", dispo=" + dispo + ", matricule=" + matricule + ", marque=" + marque + ", modele=" + modele + ", cartegrise=" + cartegrise + ", couleur=" + couleur + ", type=" + type + ", position=" + position + ", destination=" + destination + '}';
    }

   

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public void setId_v(int id_v) {
        this.id_v = id_v;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setCartegrise(String cartegrise) {
        this.cartegrise = cartegrise;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_v() {
        return id_v;
    }

    public int getDispo() {
        return dispo;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getCartegrise() {
        return cartegrise;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getType() {
        return type;
    }
    
    
}
