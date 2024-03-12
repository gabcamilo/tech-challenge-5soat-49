package br.com.camilo.gabriela.techchallenge5soat49.business.exceptions;

public class DataValidationException extends RuntimeException{
    String message;

    public DataValidationException(String message) {
        this.message = message;
    }
}
