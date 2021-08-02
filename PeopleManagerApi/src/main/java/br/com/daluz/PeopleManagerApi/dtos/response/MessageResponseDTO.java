package br.com.daluz.PeopleManagerApi.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data // Lombok - Equivalente as anotações: @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Builder // Lombok - Produz APIs de construtor complexas automaticamente para a classe (Builder pattern).
public class MessageResponseDTO {

    /**
     * Mensagem da resposta.
     */
    private String message;
}
