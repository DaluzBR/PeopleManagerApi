package br.com.daluz.PeopleManagerApi.dtos.mapper;



import br.com.daluz.PeopleManagerApi.dtos.request.PersonDTO;
import br.com.daluz.PeopleManagerApi.entities.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MapStruct é um gerador de código que simplifica a implementação de mapeamentos
 * entre os tipos de bean Java com base em uma convenção sobre abordagem de configuração.
 * Realiza o mapeamento entre as classes PersonEntity e PersonDTO.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    /**
     * Converte um objeto PersonDTO para objeto PersonEntity. o @Mapping realiza
     * um parse para converter a string da data de nascimento para o objeto
     * LocalDate da classe PersonEntity.
     *
     * @param dto Objeto PersonDTO a ser convertida.
     * @return Retorna o objeto PersonEntity.
     */
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    PersonEntity toModel(PersonDTO dto);

    /**
     * Converte um objeto PersonEntity para objeto PersonDTO.
     *
     * @param entity Objeto PersonEntity a ser convertida.
     * @return Retorna o objeto PersonDTO.
     */
    PersonDTO toDTO(PersonEntity entity);
}
