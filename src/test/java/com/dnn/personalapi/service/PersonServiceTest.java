package com.dnn.personalapi.service;

import com.dnn.personalapi.dto.request.PersonDTO;
import com.dnn.personalapi.dto.response.MessageResponseDTO;
import com.dnn.personalapi.entity.Person;
import com.dnn.personalapi.repository.PersonRepository;
import com.dnn.personalapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = PersonUtils.createFakePersonDTO();
        Person expectedPerson = PersonUtils.createFakePersonEntity();

        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(expectedPerson);

        MessageResponseDTO message = MessageResponseDTO.builder()
                .message("Person created with id " + expectedPerson.getId())
                .build();

        MessageResponseDTO messagedto = personService.createPerson(personDTO);

        Assertions.assertEquals(message, messagedto);
    }
}
