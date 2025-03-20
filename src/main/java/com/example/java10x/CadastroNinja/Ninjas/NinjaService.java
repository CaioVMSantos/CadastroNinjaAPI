package com.example.java10x.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Camada de serviço
public class NinjaService {

    private NinjaRepository ninjaRepository;//Acesso aos métodos do JPA.
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os meus ninjas
    public NinjaModel listarNinjasId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id); // Usando Optional, pois o ninja pode ou não existir.
        return ninjaPorId.orElse(null);
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll(); //procurando tudo o que tem no banco (INSERT)
    }

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Alterar Id
    public NinjaModel alterarNinja(Long id, NinjaModel novoNinja){
        if(ninjaRepository.existsById(id)){
            novoNinja.setId(id);
            return ninjaRepository.save(novoNinja);
        }
        return null;
    }

    //Deletar um ninja por ID - Tem que ser um metodo void.
    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }


}
