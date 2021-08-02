package br.com.daluz.PeopleManagerApi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity // JPA entidade (Entidade do banco de dados).
@Data // Lombok - Equivalente as anotações: @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Builder // Lombok - Produz APIs de construtores complexos automaticamente para a classe (Builder pattern).
@NoArgsConstructor // Lombok - Cria um construtor vazio.
@AllArgsConstructor // Lombok - Cria um construtor recebendo todos os parâmetros.
@Table(name = "Person") // JPA tabela.
public class PersonEntity {

    /**
     * Coluna do Id da entidade Person no banco de dados.
     * Valores são gerados por auto incremento do BD (Incremental).
     * É responsabilidade da JPA inicializar o valor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Coluna do primeiro nome da entidade Person no banco de dados.
     * É o primeiro nome da pessoa. Coluna NOT NULL.
     */
    @Column(name = "first_name", nullable = false) // JPA coluna NOT NULL.
    private String firstName;

    /**
     * Coluna do sobrenome da entidade Person no banco de dados.
     * É o sobrenome da pessoa. Coluna NOT NULL.
     */
    @Column(name = "last_name", nullable = false) // JPA coluna NOT NULL.
    private String lastName;

    /**
     * Coluna do CPF da entidade Person no banco de dados.
     * É o CPF da pessoa. Coluna NOT NULL.
     */
    @Column(name = "cpf", nullable = false, unique = true)  // JPA coluna NOT NULL & UNIQUE.
    private String cpf;

    /**
     * Coluna da data de nascimento da entidade Person no banco de dados.
     * É a data de nascimento da pessoa.
     */
    @Column(name = "birth_date")
    private LocalDate birthDate;

    /**
     * Coluna dos telefones da entidade Person no banco de dados.
     * É a lista com os telefones da pessoa.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "phones")
    private List<PhoneEntity> phones = new ArrayList<>();

    /**
     * Coluna dos bootcamps da entidade Person no banco de dados.
     * É a lista com os bootcamps que a pessoa participa.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "bootcamps")
    private List<BootcampEntity> bootcamps = new ArrayList<>();
}

    /*
    OneToMany: Uma Person para muitos Phones.
    FetchType.EAGER: puxar um objeto do BD puxando outro objeto necessário também.
    FetchType.LAZY: puxar um objeto a mais necessário usando o join fetch num select específico.
    CASCADE:
    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH} = CascadeType.ALL
    */