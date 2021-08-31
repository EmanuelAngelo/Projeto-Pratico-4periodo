/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://www.google.com/settings/security/lesssecureapps
 */

package inicio;

/**
 *
 * @author Naveen
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class EmailSend {

    public void email(String usuario, String mensagem ){
        try{
            String host ="smtp.gmail.com" ;
            String user = "plantaoundb@gmail.com";
            String pass = "undb123456";
            String to = usuario;
            String from = "plantaoundb@gmail.com";
            String subject = "Plantão Tira-Dúvidas";
            String messageText = mensagem;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           Alert a = new Alert(AlertType.INFORMATION);
   			a.setHeaderText("Operação concluída");
   			a.setContentText("E-mail enviado com sucesso");
   			a.showAndWait();
        }catch(Exception ex)
        {
        	 Alert a = new Alert(AlertType.ERROR);
    			a.setHeaderText("Erro");
    			a.setContentText("Não foi possível estabelecer conexão com a internet");
    			a.showAndWait();
        }

    }
}
