package com.dnn.personalapi.utils;

import com.dnn.personalapi.dto.request.PhoneDTO;
import com.dnn.personalapi.entity.Phone;
import com.dnn.personalapi.enums.PhoneType;

public class PhoneUtils {

    public static final PhoneType TIPO = PhoneType.MOBILE;
    public static final String NUMERO = "(35)987456321";

    public static PhoneDTO createFakePhoneDTO() {
        return PhoneDTO.builder()
                .type(TIPO)
                .number(NUMERO)
                .build();
    }

    public static Phone createFakePhoneEntity() {
        return Phone.builder()
                .id(1L)
                .type(TIPO)
                .number(NUMERO)
                .build();
    }

}
