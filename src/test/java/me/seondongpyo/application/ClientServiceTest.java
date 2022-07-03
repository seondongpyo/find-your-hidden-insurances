package me.seondongpyo.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.seondongpyo.domain.Client;
import me.seondongpyo.domain.ClientRepository;
import me.seondongpyo.domain.Contact;
import me.seondongpyo.domain.Gender;
import me.seondongpyo.domain.Nationality;
import me.seondongpyo.domain.Survey;
import me.seondongpyo.domain.Telecom;
import me.seondongpyo.exception.ClientNotFoundException;

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

        assertAll(
            () -> assertThat(client.getId()).isEqualTo(expected.getId()),
            () -> assertThat(client.getName()).isEqualTo(expected.getName()),
            () -> assertThat(client.getBirthDate()).isEqualTo(expected.getBirthDate()),
            () -> assertThat(client.isAgreement()).isEqualTo(expected.isAgreement()),
            () -> assertThat(client.getGender()).isEqualTo(expected.getGender()),
            () -> assertThat(client.getNationality()).isEqualTo(expected.getNationality()),
            () -> assertThat(client.getContact()).isEqualTo(expected.getContact()),
            () -> assertThat(client.getSurvey()).isEqualTo(expected.getSurvey())
        );
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
            .birthDate(LocalDate.of(1990, 1, 1))
            .agreement(true)
            .gender(Gender.MALE)
            .nationality(Nationality.DOMESTIC)
            .contact(contact())
            .survey(survey())
            .build();
    }

    private Contact contact() {
        return Contact.builder()
            .telecom(Telecom.SKT)
            .phoneNumber("010-1234-5678")
            .email("tester@example.com")
            .postcode("12345")
            .address("서울특별시 서초구")
            .build();
    }

    private Survey survey() {
        return Survey.builder()
            .answer1("답변1")
            .answer2("답변2")
            .answer3("답변3")
            .answer4("답변4")
            .answer5("답변5")
            .build();
    }
}
