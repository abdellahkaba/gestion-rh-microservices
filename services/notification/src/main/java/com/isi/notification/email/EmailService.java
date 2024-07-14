package com.isi.notification.email;


import com.isi.notification.kafka.commande.Produit;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.UTF8;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender ;
    private final SpringTemplateEngine templateEngine;
    @Async
    public void sendPayementSuccessEmail(
            String destinationEmail,
            String clientPrenom,
            String clientNom,
            BigDecimal montant,
            String commandeRef
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(
                mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name());
        messageHelper.setFrom("abdallahkaba98@gmail.com");
        final String templateName = EmailTemplates.PAYEMENT_CONFIRMATION.getTemplate();

        Map<String,Object> variables = new HashMap<>();
        variables.put("prenomClient", clientPrenom);
        variables.put("nomClient", clientNom);
        variables.put("montant",montant);
        variables.put("commandeReference",commandeRef);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(EmailTemplates.PAYEMENT_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName,context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("Info - Envoie de mail a %s avec template %s, ", destinationEmail, templateName));
        }catch (MessagingException ex){
            log.warn("WARNING - Non l'envoie de mail a {}", destinationEmail);
        }
    }



    @Async
    public void sendCommandeConfirmationEmail(
            String destinationEmail,
            String clientPrenom,
            String clientNom,
            BigDecimal montant,
            String commandeRef,
            List<Produit> produits
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(
                mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED,
                StandardCharsets.UTF_8.name());
        messageHelper.setFrom("abdallahkaba98@gmail.com");
        final String templateName = EmailTemplates.COMMANDE_CONFIRMATION.getTemplate();

        Map<String,Object> variables = new HashMap<>();
        variables.put("prenomClient", clientPrenom);
        variables.put("nomClient", clientNom);
        variables.put("montantTotal",montant);
        variables.put("commandeReference",commandeRef);
        variables.put("produits",produits);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(EmailTemplates.COMMANDE_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName,context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("Info - Envoie de mail a %s avec template %s, ", destinationEmail, templateName));
        }catch (MessagingException ex){
            log.warn("WARNING - Non l'envoie de mail a {}", destinationEmail);
        }
    }


}
