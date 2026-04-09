package senai.weg.exemploManyToMany.mapper;

import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioRequest;
import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioResponse;
import senai.weg.exemploManyToMany.model.Funcionario;
@Component
public class FuncionarioMapper {

    public Funcionario toRequest(FuncionarioRequest funcionarioRequest) {

        return new Funcionario(funcionarioRequest.nome());
    }

    public FuncionarioResponse toResponse(Funcionario funcionario) {

        return new FuncionarioResponse(funcionario.getId(), funcionario.getNome(), funcionario.getAssento(),
                funcionario.getProjetos());
    }

}
