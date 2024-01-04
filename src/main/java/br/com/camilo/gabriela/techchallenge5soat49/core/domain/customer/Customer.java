package br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class Customer extends BaseDomain {
    @NotBlank
    private final String name;

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    @CPF
    private final String cpf;

    public Customer(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String email, String cpf) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Customer update(Customer customer) {
        var c = customer;
        return new Customer(
                getId(),
                getCreatedAt(),
                LocalDateTime.now(),
                customer.getName(),
                customer.getEmail(),
                this.cpf
        );
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
}
