package br.com.daluz.PeopleManagerApi.mapper;



import br.com.daluz.PeopleManagerApi.dtos.mapper.PersonMapper;
import br.com.daluz.PeopleManagerApi.dtos.request.PersonDTO;
import br.com.daluz.PeopleManagerApi.dtos.request.PhoneDTO;
import br.com.daluz.PeopleManagerApi.entities.PersonEntity;
import br.com.daluz.PeopleManagerApi.entities.PhoneEntity;
import br.com.daluz.PeopleManagerApi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        PersonEntity personEntity = personMapper.toModel(personDTO);

        assertEquals(personDTO.getFirstName(), personEntity.getFirstName());
        assertEquals(personDTO.getLastName(), personEntity.getLastName());
        assertEquals(personDTO.getCpf(), personEntity.getCpf());

        PhoneEntity phoneEntity = personEntity.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        assertEquals(phoneDTO.getType(), phoneEntity.getType());
        assertEquals(phoneDTO.getNumber(), phoneEntity.getNumber());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        PersonEntity personEntity = PersonUtils.createFakeEntity();
        PersonDTO personDTO = personMapper.toDTO(personEntity);

        assertEquals(personEntity.getFirstName(), personDTO.getFirstName());
        assertEquals(personEntity.getLastName(), personDTO.getLastName());
        assertEquals(personEntity.getCpf(), personDTO.getCpf());

        PhoneEntity phoneEntity = personEntity.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        assertEquals(phoneEntity.getType(), phoneDTO.getType());
        assertEquals(phoneEntity.getNumber(), phoneDTO.getNumber());
    }
}
