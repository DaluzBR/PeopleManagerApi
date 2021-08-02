package br.com.daluz.PeopleManagerApi.repositories;


import br.com.daluz.PeopleManagerApi.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Os repositórios são os responsáveis pelas interações com o banco de dados.
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
/*
PersonEntity: Entidade a ser gerenciada no BD.
Long: id da entidade gerenciada.
 */
}
