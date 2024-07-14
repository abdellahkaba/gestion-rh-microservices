package com.isi.payement.payement;


import com.isi.payement.notification.NotificationProducer;
import com.isi.payement.notification.PayementNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayementService {

    private final PayementRepository repository;
    private final PayementMapper mapper;
    private final NotificationProducer notificationProducer ;

    public Integer createPayement(PayementRequest request) {
        var payement = repository.save(mapper.toPayement(request));
        notificationProducer.sendNotification(
                new PayementNotificationRequest(
                        request.commandeRef(),
                        request.montant(),
                        request.payementMethode(),
                        request.client().prenom(),
                        request.client().nom(),
                        request.client().email()
                )
        );
        return payement.getId();
    }
}
