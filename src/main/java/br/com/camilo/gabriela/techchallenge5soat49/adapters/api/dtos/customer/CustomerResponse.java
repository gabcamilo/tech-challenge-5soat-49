package br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.customer;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse implements Serializable {
    public CustomerResponse(Customer domain) {
        this.id = domain.getId();
        this.name = domain.getName();
        this.email = domain.getEmail();
        this.cpf = domain.getCpf();
        this.createdAt = domain.getCreatedAt();
        this.updatedAt = domain.getUpdatedAt();
    }

    private String id;

    private String name;

    private String email;

    //TODO: mask cpf
    private String cpf;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
