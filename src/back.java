/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
import entities.colis;
import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.mail;
import services.servicescolis;
import services.servicesvehicule;
public class back {

    /**
     * @param args the command line arguments
     */
     boolean exit ;
    public static void main(String[] args) {
   
    back menu = new back();
    menu.runMenu();
    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|        Welcome to TaxiCo                      |");
        System.out.println("|        Taxi , Co-voiturage et Colis           |");
        System.out.println("+-----------------------------------------------+");
    }

    private void printMenu() {
        displayHeader("Please make a selection");
        System.out.println("1) Afficher la liste des colis");
        System.out.println("2) Affecter un coli a une vehicule");
        System.out.println("2) Modifier l'etat d'un colis");
        System.out.println("0) Exit");
    }

    private int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > 3) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > 3);
        return choice;
    }

    private void performAction(int choice) {
        servicescolis src = new servicescolis();
        servicesvehicule srv = new servicesvehicule();
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
           case 1: {
                src.afficherAllcolis();
            }
            break;
            case 2: {
                Scanner sc = new Scanner(System.in);
                System.out.println("La Liste Des Colis Non Affectés :");
                src.afficherNFcolis();
                System.out.println("Veuillez saisir l'id du colis a affecté :");
                int idc = sc.nextInt();
                srv.vehiculeAFC(idc);
                System.out.println("Veuillez saisir l'id de la voiture choisi:");
                int idv = sc.nextInt();
                src.affecter (idc,idv);
                src.modifieretat (1,idc);
                String admail = src.cherchermail (idc);
            try {
                mail.sendMail(admail);
                } catch (Exception ex) {
                Logger.getLogger(back.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            }
            break;
            case 3:
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir l'id du colis :");
            int idc = sc.nextInt();
            System.out.println("Veuillez saisir ll'etat (0:non affecté , 1:affecté , 2:soti ,3:delivré");
            int etat = sc.nextInt();
            src.modifieretat (etat,idc);    
            break;
           
            default:
                System.out.println("Wrong number !.");
        }
    }

    

    
  


    
    private void displayHeader(String message){
        System.out.println();
        int width = message.length() + 6;
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for(int i = 0; i < width; ++i){
            sb.append("-");
        }
        sb.append("+");
        System.out.println(sb.toString());
        System.out.println("|   " + message + "   |");
        System.out.println(sb.toString());
    }
    
    
}
