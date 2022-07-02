package me.seondongpyo.application;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.domain.Client;
import me.seondongpyo.domain.ClientRepository;

@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
            .orElseThrow(IllegalArgumentException::new);
    }
}
