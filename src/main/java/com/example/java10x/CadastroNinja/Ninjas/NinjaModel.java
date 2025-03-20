package com.example.java10x.CadastroNinja.Ninjas;
import com.example.java10x.CadastroNinja.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

//JPA - Java Persisitence API

@Entity //Transformando toda a minha classe em uma entidade.
@Table(name = "tb_cadastro") //Gerando a tabela.
@NoArgsConstructor //Construtor sem argumento automático.
@AllArgsConstructor //Construtor com todos os argumentos automáticos, mesmo se eu adicionar mais atributos.
@Data //Criando todos os Getters e Setters.
public class NinjaModel {

    @Id //O próximo atributo que estiver em baixo dele será o id.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Passar uma estratégia de como ele irá passar os valores.
    private Long id;

    private String nome;

    @Column(unique = true) //Dizendo que essa coluna é única, não se repete.
    private String email;

    @Column(name = "imgUrl")
    private String imgUrl;

    private int idade;

    // @ManyToOne - Muitos ninjas terão uma missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoModel missao;

    public void setId(Long id) {
        this.id = id;
    }
}
