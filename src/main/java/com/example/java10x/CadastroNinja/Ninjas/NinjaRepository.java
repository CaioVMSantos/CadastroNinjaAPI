package com.example.java10x.CadastroNinja.Ninjas;

import org.springframework.data.jpa.repository.JpaRepository;

//Repository - Abstração do métodos dos bancos de dados.
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
