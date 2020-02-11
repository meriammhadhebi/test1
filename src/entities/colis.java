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
public class colis {
  private int id_c ,etat;
  private String depart,destination,nom_expediteur,nom_destinataire,mail;
  private float poids;

    public colis(String depart, String destination, String nom_expediteur, String nom_destinataire, float poids, int etat,String mail) {
       
        this.etat = etat;
        this.depart = depart;
        this.destination = destination;
        this.nom_expediteur = nom_expediteur;
        this.nom_destinataire = nom_destinataire;
        this.poids = poids;
        this.mail=mail;
    }

    @Override
    public String toString() {
        return "colis{" + "id_c=" + id_c + ", etat=" + etat + ", depart=" + depart + ", destination=" + destination + ", nom_expediteur=" + nom_expediteur + ", nom_destinataire=" + nom_destinataire + ", poids=" + poids + '}';
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNom_expediteur(String nom_expediteur) {
        this.nom_expediteur = nom_expediteur;
    }

    public void setNom_destinataire(String nom_destinataire) {
        this.nom_destinataire = nom_destinataire;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getId_c() {
        return id_c;
    }

    public int getEtat() {
        return etat;
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public String getNom_expediteur() {
        return nom_expediteur;
    }

    public String getNom_destinataire() {
        return nom_destinataire;
    }

    public float getPoids() {
        return poids;
    }
  
}
