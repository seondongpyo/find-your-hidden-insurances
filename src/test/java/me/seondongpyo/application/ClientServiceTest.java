package me.seondongpyo.application;

import me.seondongpyo.domain.Client;
import me.seondongpyo.domain.ClientRepository;
import me.seondongpyo.exception.ClientNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ClientServiceTest {

    private ClientService clientService;
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        clientRepository = new InMemoryClientRepository();
        clientService = new ClientService(clientRepository);
    }

    @DisplayName("새로운 고객을 등록한다.")
    @Test
    void create() {
        Client expected = client(1L, "홍길동");

        Client client = clientService.create(expected);

        assertThat(client.getId()).isEqualTo(expected.getId());
        assertThat(client.getName()).isEqualTo(expected.getName());
    }

    @DisplayName("식별자로 고객을 조회한다.")
    @Test
    void findById() {
        Client expected = clientRepository.save(client(2L, "김길동"));

        Client client = clientService.findById(2L);

        assertThat(client.getId()).isEqualTo(expected.getId());
        assertThat(client.getName()).isEqualTo(expected.getName());
    }

    @DisplayName("식별자에 해당하는 고객이 존재하지 않다면 ClientNotFoundException 이 발생한다.")
    @Test
    void notFound() {
        assertThatThrownBy(() -> clientService.findById(1L))
            .isInstanceOf(ClientNotFoundException.class);
    }

    private Client client(Long id, String name) {
        return Client.builder()
            .id(id)
            .name(name)
            .build();
    }
}
