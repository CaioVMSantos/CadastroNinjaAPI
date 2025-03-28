package com.example.java10x.CadastroNinja.Missoes;

import com.example.java10x.CadastroNinja.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_ninja")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    // @OneToMany - Uma missão terá vários ninjas.
    @OneToMany(mappedBy = "missao")
    @JsonIgnore //Parando o loop de serialização do JSON.
    private List<NinjaModel> ninjas;

}
