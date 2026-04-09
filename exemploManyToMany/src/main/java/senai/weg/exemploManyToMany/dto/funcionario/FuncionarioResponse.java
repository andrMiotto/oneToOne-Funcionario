package senai.weg.exemploManyToMany.dto.funcionario;

import java.util.List;

public record FuncionarioResponse(

        long id,
        String nome,
        Long assento,
        List<Long> projetos

) {

}
