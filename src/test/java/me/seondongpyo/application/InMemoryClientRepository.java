package me.seondongpyo.application;

import me.seondongpyo.domain.Client;
import me.seondongpyo.domain.ClientRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryClientRepository implements ClientRepository {

    private final Map<Long, Client> clients = new HashMap<>();

    @Override
    public Client save(Client client) {
        clients.put(client.getId(), client);
        return client;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(clients.get(id));
    }
}
