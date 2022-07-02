package me.seondongpyo.application;

import me.seondongpyo.domain.Client;
import me.seondongpyo.domain.ClientRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryClientRepository implements ClientRepository {

    private final Map<Long, Client> clients = new HashMap<>();

    @Override
    public Client save(Client client) {
        clients.put(client.getId(), client);
        return client;
    }
}
