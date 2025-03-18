package com.example.java10x.CadastroNinja.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository - Abstração relacioanado ao banco de dados, ou seja, vai simplificar os parametros para usar banco de dados.
public interface MissoesRepository extends JpaRepository<MissaoModel, Long> {
}
