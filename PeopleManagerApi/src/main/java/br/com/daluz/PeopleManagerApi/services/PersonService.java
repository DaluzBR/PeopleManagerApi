package br.com.daluz.PeopleManagerApi.services;


import br.com.daluz.PeopleManagerApi.dtos.mapper.PersonMapper;
import br.com.daluz.PeopleManagerApi.dtos.request.PersonDTO;
import br.com.daluz.PeopleManagerApi.dtos.response.MessageResponseDTO;
import br.com.daluz.PeopleManagerApi.entities.PersonEntity;
import br.com.daluz.PeopleManagerApi.exceptions.PersonNotFoundException;
import br.com.daluz.PeopleManagerApi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
A anotação @Service indica para o Spring que a classe PersonService é uma classe
para gerenciamento das regras de negócio da aplicação (melhor suporte transacional).

OBS.: Para o  Lombok anotar construtores gerado usa-se @AllArgsConstructor.
O parâmetro onConstructor aceita uma matriz de anotações (ou uma única anotação
como neste exemplo específico) que devem ser colocadas em um construtor gerado.
O sublinhado duplo foi introduzido por causa dos problemas de compatibilidade
com versões anteriores do Java JDK.
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired)) // Elimina construtores de classes injetadas.
public class PersonService {

    // Injeção de dependência da classe PersonRepository.
    private final PersonRepository personRepository;

    // Injeção de dependência da classe PersonMapper.
    private final PersonMapper personMapper;

    /**
     * Recebe as requisições do POST.
     *
     * @param personDTO Recebe um objeto PersonDTO;
     * @return Mensagem de retorno.
     */
    public MessageResponseDTO create(PersonDTO personDTO) {
        // Converte de PersonDTO para PersonEntity.
        PersonEntity personEntity = personMapper.toModel(personDTO);
        // Persiste o objeto PersonEntity no banco de dados.
        PersonEntity savedPersonEntity = personRepository.save(personEntity);
        // Gera a mensagem de resposta com o id do objeto PersonEntity persistido.
        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPersonEntity.getId());
        // Retorna a mensagem.
        return messageResponse;
    }

    /**
     * Lista com todos os registros.
     *
     * @return Retorna uma lista com todos os registros.
     */
    public List<PersonDTO> listAll() {
        List<PersonEntity> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO) // Chama o método .toDTO para cada um dos registros.
                .collect(Collectors.toList());
    }

    /**
     * Busca um usuário cadastrado pelo id.
     *
     * @param id Id do usuário.
     * @return Retorna um usuário.
     * @throws PersonNotFoundException Lança exceção de o registro não for encontrado.
     */
    public PersonDTO findById(Long id) throws PersonNotFoundException {
        // Verifica se o id do objeto existe nos registros.
        PersonEntity personEntity = verifyIfIdExists(id);

        return personMapper.toDTO(personEntity);
    }

    /**
     * Deleta um registro com base no id informado.
     *
     * @param id Id do registro a ser deletado se existir.
     * @throws PersonNotFoundException Lança exceção de o registro não for encontrado.
     */
    public void delete(Long id) throws PersonNotFoundException {
        // Verifica se o id do objeto existe nos registros.
        verifyIfIdExists(id);

        personRepository.deleteById(id);
    }

    /**
     * Atualiza um registro com base no id informado.
     *
     * @param id        Id do registro a ser atualizado se existir.
     * @param personDTO Objeto PersonDTO do registro a ser atualizado.
     * @return Mensagem de retorno.
     * @throws PersonNotFoundException Lança exceção de o registro não for encontrado.
     */
    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        // Verifica se o id do objeto existe nos registros.
        verifyIfIdExists(id);
        // Converte de PersonDTO para PersonEntity.
        PersonEntity updatedPersonEntity = personMapper.toModel(personDTO);
        // Atualiza o objeto PersonEntity no banco de dados.
        PersonEntity savedPersonEntity = personRepository.save(updatedPersonEntity);
        // Gera a mensagem de resposta com o id do objeto PersonEntity atualizado.
        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPersonEntity.getId());

        return messageResponse;
    }

    /**
     * Método para organizar a mensagem de resposta de uma requisição.
     *
     * @param s   Texto da mensagem.
     * @param id2 Id do registro do usuário.
     * @return Retorna um texto com a mensagem.
     */
    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO
                .builder()
                .message(s + id2)
                .build();
    }

    /**
     * Método para verificar se o id da entidade passada existe.
     *
     * @param id O id do registro.
     * @return Retorna a entidade procurada com base no id informado.
     * @throws PersonNotFoundException Lança exceção de o registro não for encontrado.
     */
    private PersonEntity verifyIfIdExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
