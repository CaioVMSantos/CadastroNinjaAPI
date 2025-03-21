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
    public NinjaDTO listarNinjasPorId(@PathVariable Long id){ //@PathVariable O que o usuários colocar na url, entrará no metodo.
        return ninjaService.listarNinjasId(id);
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){ //@RequestBody - O usuário tem que mandar um JSON, pra depois ocorrer a serialização inversa.
        return ninjaService.criarNinja(ninja);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar ninjas (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaId(id);
    }
}
