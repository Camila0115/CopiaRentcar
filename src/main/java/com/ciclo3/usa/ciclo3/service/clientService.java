package com.ciclo3.usa.ciclo3.service;

import com.ciclo3.usa.ciclo3.model.Client;
import com.ciclo3.usa.ciclo3.repository.clientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clientService {
    
    @Autowired
    private clientRepository ClientRepository;

    public List<Client> getAllClient() {
        return (List<Client>) ClientRepository.getAllClient();
    }
    public Optional<Client> getClient(int id) {
        return ClientRepository.getClient(id);
    }
    public Client saveClient(Client Client) {
        if(Client.getidClient() == null){
            return ClientRepository.saveClient(Client);
        }
        else{
            Optional<Client> ClientAux = ClientRepository.getClient(Client.getidClient());
            if(ClientAux.isEmpty()){
                return ClientRepository.saveClient(Client); 
            }else{
                return Client;
            }
        }
        
    }
    
    public Client update(Client client) {
        if (client.getidClient() != null) {
            Optional<Client> ClientAux = ClientRepository.getClient(client.getidClient());
            if (client.getname() != null) {
                ClientAux.get().setname(client.getname());
            }
            if (client.getemail() != null) {
                ClientAux.get().setemail(client.getemail());
            }
            if (client.getpassword() != null) {
                ClientAux.get().setpassword(client.getpassword());
            }
            if (client.getage() != null) {
                ClientAux.get().setage(client.getage());
            }
            return ClientRepository.saveClient(ClientAux.get());
        }
        return client;
    }

    public boolean deleteClient (int IdClient) {
        Boolean aBoolean = getClient(IdClient).map(client ->{
            ClientRepository.deleteClient(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
