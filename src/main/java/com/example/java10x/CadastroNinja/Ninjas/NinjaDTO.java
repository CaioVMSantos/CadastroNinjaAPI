package com.example.java10x.CadastroNinja.Ninjas;

import com.example.java10x.CadastroNinja.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

        private Long id;
        private String nome;
        private String email;
        private String imgUrl;
        private int idade;
        private String rank;
        private MissaoModel missao;


}
