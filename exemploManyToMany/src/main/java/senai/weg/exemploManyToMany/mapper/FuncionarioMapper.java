package senai.weg.exemploManyToMany.mapper;

import org.springframework.stereotype.Component;

import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioRequest;
import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioResponse;
import senai.weg.exemploManyToMany.model.Funcionario;
import senai.weg.exemploManyToMany.model.Projeto;

@Component
public class FuncionarioMapper {

    public Funcionario toRequest(FuncionarioRequest funcionarioRequest) {

        return new Funcionario(funcionarioRequest.nome());
    }

    public FuncionarioResponse toResponse(Funcionario funcionario) {

        return new FuncionarioResponse(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getAssento() != null ? funcionario.getAssento().getId() : null,
                funcionario.getProjetos().stream().map(Projeto::getId).toList());
    }

}
