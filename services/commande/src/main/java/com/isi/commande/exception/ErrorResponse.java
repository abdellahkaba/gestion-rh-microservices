package com.isi.commande.exception;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
