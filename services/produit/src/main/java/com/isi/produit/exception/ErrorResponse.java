package com.isi.produit.exception;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}
