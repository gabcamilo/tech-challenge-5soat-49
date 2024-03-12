package br.com.camilo.gabriela.techchallenge5soat49.adapters.api.controllers;

import br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.customer.CreateCustomerRequest;
import br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.customer.CustomerResponse;
import br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.customer.ListCustomerResponse;
import br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.ApiResponse;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.customer.CustomerServicePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/v1/customers")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

    private final CustomerServicePort port;
    private static final String ENTITY = "Customer";

    public CustomerController(CustomerServicePort port) {
        this.port = port;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCustomer(@RequestBody @Valid CreateCustomerRequest request) throws Throwable {
        Customer customer = port.create(Customer.createNew(request.name(), request.email(), request.cpf()));
        var response = ApiResponse.created(ENTITY, customer);
        return ResponseEntity.created(new URI("/api/v1/customers/" + customer.getId())).body(response);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ApiResponse> getCustomerByCpf(@PathVariable String cpf) {
        Customer customer = port.getCustomerByCpf(cpf);
        CustomerResponse data = new CustomerResponse(customer);
        var response = ApiResponse.get(ENTITY, data);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> listAllCustomers() {
        List<Customer> customers = port.list();
        ListCustomerResponse data = new ListCustomerResponse(customers);
        var response = ApiResponse.list(ENTITY, data);
        return ResponseEntity.ok(response);
    }
}
