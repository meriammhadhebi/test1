/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author ASUS
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class mail {
    
    public static void sendMail(String recep) throws Exception{
    Properties p= new Properties();
    
    p.put("mail.smtp.auth", "true");
    p.put("mail.smtp.starttls.enable", "true");
    p.put("mail.smtp.host", "smtp.gmail.com");
    p.put("mail.smtp.port", "587");
    
    String e_mail="zmhadhebi2@gmail.com"; 
    String pass = "Poisson1991";

    Session session =Session.getInstance(p,new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
          return new PasswordAuthentication(e_mail, pass);
        }
    });
     
        Message message=prepareMessage(session,e_mail,recep);
        Transport.send(message);
       
    }
private static Message prepareMessage(Session session,String e_mail, String recipient) throws MessagingException{
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress(e_mail));
message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
message.setSubject(" Colis Affecté ");
message.setText("Bonjour cher client , \n on est heureux de vous annoncez que votre colis a ete affecté . \n Consultez notre platforme pour plus de details .");


return message;

}
}
