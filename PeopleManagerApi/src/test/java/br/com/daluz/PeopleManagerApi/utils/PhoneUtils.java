package br.com.daluz.PeopleManagerApi.utils;


import br.com.daluz.PeopleManagerApi.dtos.request.PhoneDTO;
import br.com.daluz.PeopleManagerApi.entities.PhoneEntity;
import br.com.daluz.PeopleManagerApi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static PhoneEntity createFakeEntity() {
        return PhoneEntity.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
