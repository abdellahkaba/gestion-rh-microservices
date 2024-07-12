package com.isi.client.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class ClientNotFoundException extends RuntimeException {
    private final String message ;
}
