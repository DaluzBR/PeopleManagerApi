package br.com.daluz.PeopleManagerApi.services;


import br.com.daluz.PeopleManagerApi.dtos.mapper.PersonMapper;
import br.com.daluz.PeopleManagerApi.dtos.request.PersonDTO;
import br.com.daluz.PeopleManagerApi.dtos.response.MessageResponseDTO;
import br.com.daluz.PeopleManagerApi.entities.PersonEntity;
import br.com.daluz.PeopleManagerApi.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.daluz.PeopleManagerApi.utils.PersonUtils.createFakeDTO;
import static br.com.daluz.PeopleManagerApi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        PersonEntity expectedSavedPersonEntity = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPersonEntity);
        when(personRepository.save(any(PersonEntity.class))).thenReturn(expectedSavedPersonEntity);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPersonEntity.getId());
        MessageResponseDTO successMessage = personService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }

}
