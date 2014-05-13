/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Maxim
 */
public class MailHelper {
    
    public static void sendEmail(String toEmail, String subject, String body)
    {
        try
        {
            Properties configFile = new Properties();
            configFile.load(MailHelper.class.getClassLoader().getResourceAsStream("config.properties"));

            final String username = configFile.getProperty("mail.account.username");
            final String password = configFile.getProperty("mail.account.password");

            Properties props = System.getProperties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", configFile.getProperty("mail.smtp.host"));
            props.put("mail.smtp.port", configFile.getProperty("mail.smtp.port"));

            Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                }
            );
            
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(configFile.getProperty("mail.from.email"), configFile.getProperty("mail.from.name")));
            msg.setReplyTo(InternetAddress.parse("mygardev@gmail.com", false));
            msg.setSubject(subject, "UTF-8");
            msg.setContent(body, "text/html");
            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);  

            System.out.println("Email werd verzonden");
        } 
        catch(IOException ex) 
        {
            ex.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
