package com.capgemini.market.web.controller;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //controlador de API REST
@RequestMapping("/api/clients") //Path donde aceptara peticiones
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id")String clientId){
        return clientService.getClient(clientId);
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String clientId){
        return clientService.delete(clientId);
    }
}
