package br.com.daluz.PeopleManagerApi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // JPA entidade (Entidade do banco de dados).
@Data
// Lombok - Equivalente a combinação das anotações: @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Builder // Lombok - Produz APIs de construtores complexos automaticamente para a classe (Builder pattern).
@NoArgsConstructor // Lombok - Cria um construtor vazio.
@AllArgsConstructor // Lombok - Cria um construtor recebendo todos os parâmetros.
@Table(name = "Bootcamp") // JPA tabela.
public class BootcampEntity {

    /**
     * Coluna do Id da entidade Bootcamp no banco de dados.
     * Valores são gerados por auto incremento do BD (Incremental).
     * É gerenciado pelo JPA. É responsabilidade da JPA inicializar o valor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Coluna do nome da entidade Bootcamp no banco de dados.
     * É o nome do bootcamp. Coluna NOT NULL.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Coluna da duração da entidade Bootcamp no banco de dados.
     * É a duração do bootcamp em horas. Coluna NOT NULL.
     */
    @Column(name = "duration", nullable = false)
    private String duration;
}
/*
 CPF[001]: 17409488239
 CPF[002]: 45517115276
 CPF[003]: 76142322160
 CPF[004]: 68576189259
 CPF[005]: 79543123306
 CPF[006]: 41138742716
 CPF[007]: 79319865043
 CPF[008]: 28602486502
 CPF[009]: 09006138908
 CPF[010]: 34460661870
 */