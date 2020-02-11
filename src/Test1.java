import entities.colis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.servicesvehicule;
import services.servicescolis;
import t2s.son.LecteurTexte;

public class Test1 {

    //Instance Variables
    boolean exit;

    public static void main(String[] args) {
        Test1 menu = new Test1();
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
        System.out.println("1) Reserver un taxi");
        System.out.println("2) Reserver un co-voiturage");
        System.out.println("3) Envoyer colis");
        System.out.println("4) consulter etat colis");
        System.out.println("5) Annuler l'envoi de colis");
        System.out.println("6) Modifier colis");
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
            if (choice < 0 || choice > 6) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > 6);
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
                LecteurTexte lecteur = new LecteurTexte("Bonjour");
                lecteur.playAll();
                lecteur.setTexte("Quelle est votre point de depart");
                lecteur.playAll();              
                Scanner sc = new Scanner(System.in);
                System.out.println("Veuillez saisir votre point de depart :");
                String pt_depart = sc.nextLine();
                srv.affichervehicule("Taxi",pt_depart,"");
            }
            break;
            case 2: {
                
                Scanner sc = new Scanner(System.in);
                System.out.println("Veuillez saisir votre point de depart :");
                String pt_depart = sc.nextLine();
                System.out.println("Veuillez saisir votre destination :");
                String dest = sc.nextLine();
                srv.affichervehicule("co-voiturage",pt_depart,dest);
            }
            break;
            case 3:
                
                Scanner sc = new Scanner(System.in);
                System.out.println("Veuillez saisir votre point de depart :");
                String depart = sc.nextLine();
                System.out.println("Veuillez saisir votre destination :");
                String destination = sc.nextLine();
                System.out.println("Veuillez saisir votre nom :");
                String nom_expediteur = sc.nextLine();
                System.out.println("Veuillez saisir le nom du destinataire :");
                String nom_destinataire = sc.nextLine();
                System.out.println("Veuillez saisir le poids du colis:");
                float poids = sc.nextFloat();
                System.out.println("Veuillez saisir votre adresse mail :");
                String email = sc.nextLine();
                String mail = sc.nextLine();
                colis col = new colis(depart,destination,nom_expediteur,nom_destinataire,poids,0,mail);
                src.ajoutercolis(col);
                System.out.println("votre colis sera affecter a une vehicule le plus tot possible <3");
                System.out.println("vous pouvez consulter l'etat de votre colis avec l'id: "+col.getId_c());
                break;
            case 4:
                Scanner scan = new Scanner(System.in);
                System.out.println("Veuillez saisir l'id de votre colis :");
                int id = scan.nextInt();
                src.affichercolis(id);
                break;
            case 5:
                Scanner scansupp = new Scanner(System.in);
                System.out.println("Veuillez saisir l'id de votre colis :");
                int idsupp = scansupp.nextInt();
                src.supprimercolis(idsupp);
                break;
            case 6:
                Scanner scanmodif = new Scanner(System.in);
                System.out.println("Veuillez saisir l'id de votre colis :");
                int idmodif = scanmodif.nextInt();
                System.out.println("Veuillez saisir le champs a changer \n (depart/destination/nom_expediteur/nom_destinataire) :");
                String modifier = scanmodif.nextLine();
                String modif = scanmodif.nextLine();
                System.out.println("Veuillez saisir la nouvelle adresse :");
                String adresse = scanmodif.nextLine();
                src.modifiercolisdepart(idmodif,modif,adresse);
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