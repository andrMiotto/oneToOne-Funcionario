package senai.weg.exemploManyToMany.dto.funcionario;

import java.util.List;

import senai.weg.exemploManyToMany.model.Assento;
import senai.weg.exemploManyToMany.model.Projeto;

public record FuncionarioResponse(

        long id,
        String nome,
        Assento assento,
        List<Projeto> projetos

) {

}
