package pl.kodolamacz.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Scheduled(cron = "0 * * * * ?")
    public void sendMessage(){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("kodolamacz-sages@o2.pl");
        simpleMailMessage.setTo("kodolamacz-sages@o2.pl");
        simpleMailMessage.setSubject("Pozdro z kursu! ");
        simpleMailMessage.setText("To jest tekst");

        javaMailSender.send(simpleMailMessage);
    }


}