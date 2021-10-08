package com.dnn.personalapi.service;

import com.dnn.personalapi.dto.request.PersonDTO;
import com.dnn.personalapi.dto.response.MessageResponseDTO;
import com.dnn.personalapi.entity.Person;
import com.dnn.personalapi.exception.PersonNotFoundException;
import com.dnn.personalapi.mapper.PersonMapper;
import com.dnn.personalapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    private PersonRepository personRepository;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = this.personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Person created with id ");
    }

    public List<PersonDTO> listAll() {
        List<Person> all = personRepository.findAll();
        return all.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyExists(id);
        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public MessageResponseDTO updatePersonById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyExists(id);
        Person personUpdated = personMapper.toModel(personDTO);

        Person savedPerson = this.personRepository.save(personUpdated);
        return createMessageResponse(savedPerson.getId(), "Person updated with id ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
