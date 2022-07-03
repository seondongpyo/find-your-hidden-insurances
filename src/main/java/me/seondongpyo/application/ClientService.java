package me.seondongpyo.application;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.domain.Client;
import me.seondongpyo.domain.ClientRepository;
import me.seondongpyo.exception.ClientNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundException(id));
    }
}
