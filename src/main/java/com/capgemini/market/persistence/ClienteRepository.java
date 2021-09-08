package com.capgemini.market.persistence;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.repository.ClientRepository;
import com.capgemini.market.persistence.crud.ClienteCrudRepository;
import com.capgemini.market.persistence.crud.ProductoCrudRepository;
import com.capgemini.market.persistence.entity.Cliente;
import com.capgemini.market.persistence.mapper.ClientMapper;
import com.capgemini.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired //los obque reciben esta notacion le cedemos el control a spring para que haga las instancias
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private ClientMapper mapper;

    public List<Client> getAll(){
        List<Cliente>clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return mapper.toClients(clientes);
    }
    @Override
    public Optional<Client> getClient(String clientId) {
        return clienteCrudRepository.findById(clientId).map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clienteCrudRepository.save(cliente));
    }

    public void save(Cliente cliente){
        clienteCrudRepository.save(cliente);
    }

    public void delete(String clienteId){
        clienteCrudRepository.deleteById(clienteId);
    }

    public Long getCountRegister(){
        return clienteCrudRepository.count();
    }

    public Optional<Cliente> getCliente(String id){
        return clienteCrudRepository.findById(id);
    }
}

//Operaciones del crud
//Named Querys
