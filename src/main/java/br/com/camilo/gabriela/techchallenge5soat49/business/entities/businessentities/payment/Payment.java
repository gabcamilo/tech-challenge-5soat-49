package br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.payment;

import jakarta.validation.constraints.NotBlank;

public class Payment {

    @NotBlank
    private PaymentStatus status;

    public Payment(){
        this.status = PaymentStatus.PENDING;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void pay(){
        this.status = PaymentStatus.APPROVED;
    }

    public void reject(){
        this.status = PaymentStatus.REJECTED;
    }

}
