package br.com.camilo.gabriela.techchallenge5soat49.adapters.inbound.api.dtos.order;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOrderRequest {
    private HashMap<String, Integer> products;

    private HashMap<String, Integer> bundles;

    private String customerName;

    private String customerCpf;

    public CreateOrderRequest(HashMap<String, Integer> products, HashMap<String, Integer> bundles) {
        this.products = products;
        this.bundles = bundles;
    }

    public HashMap<String, Integer> getProducts() {
        return products;
    }

    public HashMap<String, Integer> getBundles() {
        return bundles;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCpf() {
        return customerCpf;
    }
}
