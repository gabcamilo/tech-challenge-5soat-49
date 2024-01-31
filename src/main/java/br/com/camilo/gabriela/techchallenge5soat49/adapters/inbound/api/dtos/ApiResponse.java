package br.com.camilo.gabriela.techchallenge5soat49.adapters.inbound.api.dtos;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {
    private String message;
    private Integer httpStatusCode;
    private Serializable data;

    public ApiResponse(String message, Integer httpStatusCode, Serializable data) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
        this.data = data;
    }

    public static ApiResponse created(String entity, Serializable data) {
        return new ApiResponse(entity + " created successfully", 201, data);
    }

    public static ApiResponse get(String entity, Serializable data) {
        return new ApiResponse(entity + " found successfully", 200, data);
    }

    public static ApiResponse list(String entity, Serializable data) {
        return new ApiResponse(entity + " listed successfully", 200, data);
    }

    public String getMessage() {
        return message;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public Serializable getData() {
        return data;
    }
}
