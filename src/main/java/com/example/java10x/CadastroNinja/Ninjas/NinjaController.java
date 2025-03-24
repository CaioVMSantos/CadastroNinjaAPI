package com.example.java10x.CadastroNinja.Ninjas;

import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Dizendo que essa classe será a controller
@RequestMapping("/ninjas")//Dizendo que eu vou mapear as minhas rotas
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){ //@PathVariable O que o usuários colocar na url, entrará no metodo.
        NinjaDTO ninja = ninjaService.listarNinjasId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                        body("Ninja com o id " + id + " não existe nos nossos registros!");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){ //@RequestBody - O usuário tem que mandar um JSON, pra depois ocorrer a serialização inversa.
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com Sucesso!: " + novoNinja.getNome() + ", ID: " + novoNinja.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        if (ninjaService.listarNinjasId(id) != null){
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja com id: " + id + ", alterado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com id " + id + " não foi encontrado!");
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjasId(id) != null){
            ninjaService.deletarNinjaId(id);
            return ResponseEntity.ok("Ninja com id: " + id + ", deletado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com id " + id + " não foi encontrado!");
        }

    }
}
