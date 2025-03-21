package com.example.java10x.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //Camada de serviço
public class NinjaService {

    private NinjaRepository ninjaRepository;//Acesso aos métodos do JPA.
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar o ninja por id
    public NinjaDTO listarNinjasId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id); // Usando Optional, pois o ninja pode ou não existir.
        return ninjaPorId.map(ninjaMapper::map).orElse(null); //Se o Optional contiver um valor, o metodo map() aplica a transformação e retorna um Optional com o novo valor transformado.
    }

    //Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll(); //Criando uma lista de ninjas.
        return ninjas.stream()
                .map(ninjaMapper::map)//Convertendo todos os elementos do Model pro Dto.
                .collect(Collectors.toList());//Após a conversão de cada NinjaModel para NinjaDTO, os resultados são coletados em uma lista e retornados.
    }

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO); //Crio um Model para mapear meu Dto.
        ninja = ninjaRepository.save(ninja); //Salvando o Model.
        return ninjaMapper.map(ninja); //Retornando o mapper do dto.
    }

    //Alterar Id
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id); //Recebendo um id que pode ou não existir.
        if(ninjaExistente.isPresent()){ //Se o id estiver presente (se existir).
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO); //Crio um ninja model e mapeio o Dto que o usuário escrever.
            ninjaAtualizado.setId(id); //Setando o id novamente
            NinjaModel ninjaNovoSalvo = ninjaRepository.save(ninjaAtualizado); //Metodo para salvar
            return ninjaMapper.map(ninjaNovoSalvo); //Mapeando o ninja editado.
        }
        return null;
    }

    //Deletar um ninja por ID - Tem que ser um metodo void.
    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }


}
