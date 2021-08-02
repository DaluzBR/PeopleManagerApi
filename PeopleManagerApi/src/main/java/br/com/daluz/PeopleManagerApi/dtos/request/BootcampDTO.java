package br.com.daluz.PeopleManagerApi.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/* Um DTO (Data Transfer Object) é um padrão de projeto utilizado para transferência de dados.*/
@Data // Lombok - Equivalente as anotações: @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Builder // Lombok - Produz APIs de construtor complexas automaticamente para a classe (Builder pattern).
@NoArgsConstructor // Lombok - Cria um construtor vazio.
@AllArgsConstructor // Lombok - Cria um construtor recebendo todos os parâmetros.
public class BootcampDTO {

    private Long id;

    @NotEmpty
    @Size(min = 1, max = 100, message = "BootcampDTO.name must contain between 1 and 100 characters.")
    private String name;

    @NotEmpty
    @Size(min = 1, max = 3, message = "BootcampDTO.duration must contain between 1 and 3 characters.")
    private String duration;
}
