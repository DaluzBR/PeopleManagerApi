package br.com.daluz.PeopleManagerApi.entities;


import br.com.daluz.PeopleManagerApi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // JPA entidade (Entidade do banco de dados).
@Data // Lombok - Equivalente a combinação das anotações: @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Builder // Lombok - Produz APIs de construtores complexos automaticamente para a classe (Builder pattern).
@NoArgsConstructor // Lombok - Cria um construtor vazio.
@AllArgsConstructor // Lombok - Cria um construtor recebendo todos os parâmetros.
@Table(name = "Phone") // JPA tabela.
public class PhoneEntity {

    /**
     * Coluna do Id da entidade Phone no banco de dados.
     * Valores são gerados por auto incremento do BD (Incremental).
     * É responsabilidade da JPA inicializar o valor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Coluna do tipo de telefone da entidade Phone no banco de dados.
     * É o tipo do telefone. Coluna NOT NULL.
     * Declara que o valor dever ser convertido para String no banco de dados.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PhoneType type;

    /**
     * Coluna do número do telefone da entidade Phone no banco de dados.
     * É o número do telefone. Coluna NOT NULL.
     */
    @Column(name = "number", nullable = false)
    private String number;
}
