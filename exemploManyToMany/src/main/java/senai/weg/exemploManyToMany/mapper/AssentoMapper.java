package senai.weg.exemploManyToMany.mapper;

import senai.weg.exemploManyToMany.dto.assento.AssentoRequest;
import senai.weg.exemploManyToMany.dto.assento.AssentoResponse;
import senai.weg.exemploManyToMany.model.Assento;

public class AssentoMapper {

    public Assento toRequest(AssentoRequest assentoRequest) {

        return new Assento(assentoRequest.codigo());
    }

    public AssentoResponse tResponse(Assento assento) {

        return new AssentoResponse(assento.getId(), assento.getCodigo());
    }

}
