package com.isi.notification.email;

import lombok.Getter;

public enum EmailTemplates {


    PAYEMENT_CONFIRMATION("payement-confirmation.html", "Le processus de payement effectué"),
    COMMANDE_CONFIRMATION("commande-confirmation.html", "Le processus de commande effectuée");

    @Getter
    private final String template;
    @Getter
    private final String subject;
    EmailTemplates(String template, String subject){
        this.template = template;
        this.subject = subject;
    }
}
