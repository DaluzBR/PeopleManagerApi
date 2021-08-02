package br.com.daluz.PeopleManagerApi.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/* Um DTO (Data Transfer Object) é um padrão de projeto utilizado para transferência de dados.*/
@Data // Lombok - Equivalente as anotações: @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Builder // Lombok - Produz APIs de construtor complexas automaticamente para a classe (Builder pattern).
@NoArgsConstructor // Lombok - Cria um construtor vazio.
@AllArgsConstructor // Lombok - Cria um construtor recebendo todos os parâmetros.
public class PersonDTO {

    private Long id;

    @NotEmpty // Indica que este campo nunca pode ser vazio.
    @Size(min = 2, max = 100, message = "PersonDTO.firstName must contain between 2 and 100 characters.")
    // Limita o número de caracteres.
    private String firstName;

    @NotEmpty // Indica que este campo nunca pode ser vazio.
    @Size(min = 2, max = 100, message = "PersonDTO.lastName must contain between 2 and 100 characters.")
    // Limita o número de caracteres.
    private String lastName;

    @NotEmpty // Indica que este campo nunca pode ser vazio.
    @CPF // Validação do CPF
    private String cpf;

    @NotNull // Indica que este campo nunca pode ser vazio.
    private String birthDate;

    @Valid
    // Indica que cada um dos dados da lista de telefones precisam ser validados (através dos atributos da classe).
    @NotEmpty // Indica que este campo nunca pode ser vazio.
    private List<PhoneDTO> phones;

    @Valid
    // Indica que cada um dos dados da lista de bootcamps precisam ser validados (através dos atributos da classe).
    @NotEmpty // Indica que este campo nunca pode ser vazio.
    private List<BootcampDTO> bootcamps;
}
