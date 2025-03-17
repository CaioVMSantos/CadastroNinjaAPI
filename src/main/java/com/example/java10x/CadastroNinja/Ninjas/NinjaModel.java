package com.example.java10x.CadastroNinja.Ninjas;
import com.example.java10x.CadastroNinja.Missoes.MissaoModel;
import jakarta.persistence.*;

//JPA - Java Persisitence API

@Entity //Transformando toda a minha classe em uma entidade.
@Table(name = "tb_cadastro") //Gerando a tabela.
public class NinjaModel {

    @Id //O próximo atributo que estiver em baixo dele será o id.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Passar uma estratégia de como ele irá passar os valores.
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne - Muitos ninjas terão uma missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoModel missao;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
