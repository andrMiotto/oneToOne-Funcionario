package senai.weg.exemploManyToMany.mapper;

import org.springframework.stereotype.Component;

import senai.weg.exemploManyToMany.dto.projeto.ProjetoRequest;
import senai.weg.exemploManyToMany.dto.projeto.ProjetoResponse;
import senai.weg.exemploManyToMany.model.Projeto;

@Component
public class ProjetoMapper {


    public Projeto toRequest(ProjetoRequest projetoRequest){
        
        return new Projeto(projetoRequest.nome());
    }

    public ProjetoResponse toResponse(Projeto projeto){
        
        return new ProjetoResponse(projeto.getId(),projeto.getNome());
    }
    
}
