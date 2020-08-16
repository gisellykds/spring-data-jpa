package com.introduction.jpa.repository;

import com.introduction.jpa.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    /** -------------------------------------
                PRIMEIRA TABELA
     --------------------------------------*/
    @Modifying
    @Transactional
    @Query("DELETE FROM Contact AS c WHERE c.id = :id") //Parâmetros nomeados
    void deleteByIdWithJPQLNamedParameter(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Contact AS c WHERE c.id = ?1") //Parâmetros posicionais
    void deleteByIdWithJPQLPositionedParameter(Long id);

    /** -------------------------------------
                SEGUNDA TABELA
     --------------------------------------*/

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Contact WHERE id = :id", nativeQuery = true) //Parâmetros nomeados
    void deleteByIdWithNativeSQLNamedParameter(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Contact WHERE id = ?1", nativeQuery = true) //Parâmetros posicionais
    void deleteByIdWithNativeSQLPositionedParameter(Long id);

    /** -------------------------------------
                 TERCEIRA TABELA
     --------------------------------------*/

    // FIND BY ID -> buscar um registro na tabela contact pelo id, passando por parâmetro o campo (ID), nos retorna um Optional (uma das novidades de Java 8)
    Optional<Contact> findById(Long id);

    //FIND ALL -> buscar todos os registros na tabela contact, não necessita de parâmetros, nos retornando uma lista de registros
    List<Contact> findAll();

    //SAVE -> salvar ou atualizar um registro na tabela de contact, necessita de um objeto instância da entidade por parâmetro, nos retornando o registro salvo em contact
    Contact save(Contact contact);

    //DELETE BY ID -> deletar um registro na tabela de contact, passando por parâmetro o campo (ID) e não retornando nada
    void deleteById(Long id);


    /** -------------------------------------
                QUARTA TABELA
     --------------------------------------*/

    //FIND BY EMAIL -> buscar um registro na tabela contact que contenha o email especificado por parâmetro (detalhe: para retornar apenas um, deve ser um atributo unique)
    Contact findByEmail(String email);

    //FIND ALL BY EMAIL -> buscar todos os contato que contenha o email especificado por parâmetro (detalhe: retorna uma lista dos registros que tenham o email especificado)
    List<Contact> findAllByEmail(String email);

    //FIND BY ID AND EMAIL -> buscar um registro em contact que contenha o id e email especificados
    Contact findByIdAndEmail(Long id, String email);

    //FIND BY ID OR EMAIL -> buscar um contato por id ou email
    Contact findByIdOrEmail(Long id, String email);


    /** -------------------------------------
                QUINTA TABELA
     --------------------------------------*/

    // Buscar um contato por email
    @Query(value = "SELECT * FROM Contact WHERE email = ?1", nativeQuery = true)
    Contact findByEmailNativeSQL(String email);

    @Query("select c FROM Contact AS c WHERE c.email = ?1")
    Contact findByEmailJPQLPositionedParameter(String email);

    @Query("select c FROM Contact AS c WHERE c.email = :email")
    Contact findByEmailJPQLNamedParameter (@Param("email") String email);

    // Buscar uma lista de registros em contact que contenham o name especificado
    List<Contact> findByNameContaining(String name);

    @Query(value = "SELECT * FROM Contact WHERE name LIKE %?1%", nativeQuery = true)
    List<Contact> findByNameContainingNativeQuery(String name);

    @Query("SELECT c FROM Contact AS c WHERE c.name LIKE %?1%")
    List<Contact> findByNameContainingJPQL(String name);

    // Buscar uma lista de registros em contact que não contenham o name especificado
    @Query(value = "SELECT * FROM Contact WHERE name NOT LIKE %?1%", nativeQuery = true)
    List<Contact> findByNameNotContainingNativeQuery(String name);

    @Query("SELECT c FROM Contact AS c WHERE c.name NOT LIKE %?1%")
    List<Contact> findByNameNotContainingJPQL(String name);

    List<Contact> findByNameNotContaining(String name);


    /** -------------------------------------
                 SEXTA TABELA
     --------------------------------------*/

    // Listar registros da tabela que o email que possuam o email null
    @Query("SELECT c FROM Contact AS c WHERE c.email IS NULL")
    List<Contact> findByEmailIsNull();

    // Listar os registros da tabela contact que não possuam email nulo
    @Query("SELECT c FROM Contact AS c WHERE c.email IS NOT NULL")
    List<Contact> findByEMailIsNotNull();

    // Lista registros da tabela contact que possuam o name especificado
    @Query("SELECT c FROM Contact AS c WHERE c.name = ?1")
    List<Contact> findByName(String name);

    // Lista registros da tabela contact que possuam o name especificado sem case sensitive
    @Query("SELECT c FROM Contact AS c WHERE lower(c.name) = lower(?1) ")
    List<Contact> findByNameIgnoreCase(String name);

    // Lista registros da tabela contact que não possuam o name especificado
    @Query("SELECT c FROM Contact AS c WHERE c.name <> ?1")
    List<Contact> findByNameNotEqual(String name);

    // Listar registros da tabela contact que tenham date entre from e to
    @Query("SELECT c FROM Contact c WHERE c.date BETWEEN  ?1 AND ?2")
    List<Contact> findByDateBetween(Date from, Date to);

    // Lista registros da tabela contact que tenham date antes de before
    @Query("SELECT c FROM Contact AS c WHERE c.date < ?1")
    List<Contact> findByDateBefore(Date before);

    // Listar registros da tabela contact que tenham date depois de after
    @Query("SELECT c FROM Contact AS c WHERE c.date > ?1")
    List<Contact> findByDateAfter(Date after);

    @Modifying
    @Transactional
    @Query("update Contact AS c SET c.name = :name WHERE c.id = :id")
    void updateNameById (@Param("id") Long id, @Param("name") String name);

}
