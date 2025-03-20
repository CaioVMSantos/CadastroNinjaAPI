package com.example.java10x.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Dizendo que essa classe será a controller
@RequestMapping("/ninjas")//Dizendo que eu vou mapear as minhas rotas
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
    //Criando CRUD
    //Procurar um ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){ //@PathVariable para o usuário colocar o id na própria url.
        return ninjaService.listarNinjasId(id);
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){ //@RequestBody - O usuário tem que mandar um JSON, pra depois ocorrer a serialização inversa.
        return ninjaService.criarNinja(ninja);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Ninja alterado!";
    }

    //Deletar ninjas (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Ninja deletado!";
    }
}
