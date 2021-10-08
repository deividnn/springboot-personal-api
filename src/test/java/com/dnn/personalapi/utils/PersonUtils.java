package com.dnn.personalapi.utils;

import com.dnn.personalapi.dto.request.PersonDTO;
import com.dnn.personalapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    public static final String NOME = "Deivid";
    public static final String SOBRENOME = "Nunes";
    public static final String CPF = "02136547856985";
    public static final String DATA_NASCIMENTO = "02-02-2000";
    public static final LocalDate DATA_NASCIMENTO_OBJ = LocalDate.of(2000, 2, 2);

    public static PersonDTO createFakePersonDTO() {
        return PersonDTO.builder()
                .id(1L)
                .firstName(NOME)
                .lastName(SOBRENOME)
                .cpf(CPF)
                .birthDate(DATA_NASCIMENTO)
                .phones(Collections.singletonList(PhoneUtils.createFakePhoneDTO()))
                .build();
    }

    public static Person createFakePersonEntity() {
        return Person.builder()
                .id(1L)
                .firstName(NOME)
                .lastName(SOBRENOME)
                .cpf(CPF)
                .birthDate(DATA_NASCIMENTO_OBJ)
                .phones(Collections.singletonList(PhoneUtils.createFakePhoneEntity()))
                .build();
    }
}
