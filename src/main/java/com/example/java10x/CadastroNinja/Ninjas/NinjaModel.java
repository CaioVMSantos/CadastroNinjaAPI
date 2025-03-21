package com.example.java10x.CadastroNinja.Ninjas;
import com.example.java10x.CadastroNinja.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

//JPA - Java Persisitence API

@Entity //Transformando toda a minha classe em uma entidade.
@Table(name = "tb_cadastro") //Gerando a tabela.
@Data
@NoArgsConstructor //Construtor sem argumento automático.
@AllArgsConstructor //Construtor com todos os argumentos automáticos, mesmo se eu adicionar mais atributos.
public class NinjaModel {

    @Id //O próximo atributo que estiver em baixo dele será o id.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Passar uma estratégia de como ele irá passar os valores.
    private Long id;

    private String nome;

    @Column(unique = true) //Dizendo que essa coluna é única, não se repete.
    private String email;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    // @ManyToOne - Muitos ninjas terão uma missão.
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoModel missao;
}
