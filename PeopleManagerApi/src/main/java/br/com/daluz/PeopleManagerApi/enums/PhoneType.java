package br.com.daluz.PeopleManagerApi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter // Lombok - Cria os métodos getters.
@AllArgsConstructor  // Lombok - Cria um construtor recebendo todos os parâmetros.
public enum PhoneType {
    HOME("Home"), // Tipo de telefone residencial.
    MOBILE("Mobile"), // Tipo de telefone móvel.
    COMMERCIAL("Commercial"); // Tipo de telefone comercial.

    /**
     * Descrição do tipo de telefone.
     */
    private final String description;
}
