package br.com.daluz.PeopleManagerApi.controllers;

import br.com.daluz.PeopleManagerApi.dtos.request.PersonDTO;
import br.com.daluz.PeopleManagerApi.dtos.response.MessageResponseDTO;
import br.com.daluz.PeopleManagerApi.exceptions.PersonNotFoundException;
import br.com.daluz.PeopleManagerApi.services.PersonService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe de entrada do projeto onde são mapeados os EndPoints da aplicação.
 * Classe porta de entrada e saída da aplicação quando alguém deseja utilizar
 * o serviço que foi desenvolvido.
 * O Controlador não deve ter responsabilidades de processar ou persistir dados.
 */
@RestController // Indica que a classe 'PersonController' é um controlador controlado pela API Rest.
@RequestMapping("/api/v1/people") // Informa o caminho de acesso principal da API.
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    // Injeção de dependência da classe PersonService.
    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Retorna o código do status HTTP 201.
    public MessageResponseDTO create(@Valid @RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // Retorna o código do status HTTP 200.
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK) // Retorna o código do status HTTP 200.
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // Retorna o código do status HTTP 200.
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o código do status HTTP 204.
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
