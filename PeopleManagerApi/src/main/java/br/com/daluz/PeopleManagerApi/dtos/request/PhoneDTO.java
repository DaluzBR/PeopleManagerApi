package br.com.daluz.PeopleManagerApi.dtos.request;


import br.com.daluz.PeopleManagerApi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/* Um DTO (Data Transfer Object) é um padrão de projeto utilizado para transferência de dados.*/
@Data// Lombok - Equivalente as anotações: @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Builder // Lombok - Produz APIs de construtor complexas automaticamente para a classe (Builder pattern).
@NoArgsConstructor // Lombok - Cria um construtor vazio.
@AllArgsConstructor // Lombok - Cria um construtor recebendo todos os parâmetros.
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)  // Enumeração do tipo String..
    private PhoneType type;

    @NotEmpty  // Indica que este campo nunca pode ser vazio.
    @Size(min = 13, max = 14, message = "PhoneDTO.number must contain between 13 and 14 characters.")
    // Limita o número de caracteres.
    private String number;
}
