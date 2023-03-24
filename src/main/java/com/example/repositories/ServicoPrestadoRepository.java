package com.example.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.ServicoPrestado;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    @Query(value = "SELECT sp.id, c.nome, sp.descricao, sp.valor, "
            + " sp.data_servico_prestado "
            + " FROM servico_prestado sp "
            + " LEFT JOIN cliente c "
            + " ON c.id = sp.id_cliente "
            + " where upper( c.nome ) like upper( :nome ) "
            + " OR sp.data_servico_prestado = :data", nativeQuery = true)
    List<ServicoPrestado> findByNomeClienteOrMes(
            @Param("nome") String nome,
            @Param("data") LocalDate data);
}
