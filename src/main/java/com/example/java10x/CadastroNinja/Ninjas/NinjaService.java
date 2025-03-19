package com.example.java10x.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service //Camada de serviço
public class NinjaService {

    private NinjaRepository ninjaRepository; //Acesso aos métodos do JPA.

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll(); //procurando tudo o que tem no banco (INSERT)
    }


}
