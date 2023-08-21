package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Client;
import com.sda.rentalloapp.exception.WrongClientException;
import com.sda.rentalloapp.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientById(Long clientId){
        return clientRepository.findById(clientId)
                .map(client -> {
                    log.info("Found client: [{}]", client);
                    return client;
                })
                .orElseThrow(() -> new WrongClientException("No car with id [%d] found ".formatted(clientId)));
    }
}
