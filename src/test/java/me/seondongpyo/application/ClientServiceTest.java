package me.seondongpyo.application;

import me.seondongpyo.domain.Client;
import me.seondongpyo.domain.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientServiceTest {

    private ClientService clientService;

    @BeforeEach
    void setUp() {
        ClientRepository clientRepository = new InMemoryClientRepository();
        clientService = new ClientService(clientRepository);
    }

    @DisplayName("새로운 고객을 등록한다.")
    @Test
    void create() {
        Client client = clientService.create(Client.builder()
            .id(1L)
            .name("홍길동")
            .build());

        assertThat(client.getId()).isEqualTo(1L);
        assertThat(client.getName()).isEqualTo("홍길동");
    }
}
