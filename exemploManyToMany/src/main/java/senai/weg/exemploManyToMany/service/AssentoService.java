package senai.weg.exemploManyToMany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.exemploManyToMany.dto.assento.AssentoRequest;
import senai.weg.exemploManyToMany.dto.assento.AssentoResponse;
import senai.weg.exemploManyToMany.mapper.AssentoMapper;
import senai.weg.exemploManyToMany.model.Assento;
import senai.weg.exemploManyToMany.repository.AssentoRepository;

@Service
@RequiredArgsConstructor
public class AssentoService {

    private final AssentoRepository assentoRepository;
    private final AssentoMapper assentoMapper;

    public AssentoResponse create(AssentoRequest assentoRequest) {

        Assento assento = assentoMapper.toRequest(assentoRequest);

        Assento assentoSalvo = assentoRepository.save(assento);

        AssentoResponse assentoResponse = assentoMapper.toResponse(assentoSalvo);

        return assentoResponse;
    }

    public List<AssentoResponse> listAll() {

        List<Assento> assentos = assentoRepository.findAll();

        if (assentos.isEmpty()) {
            throw new RuntimeException("Nao existe nenhum assento cadastrado");
        } else {
            List<AssentoResponse> dtos = new ArrayList<>();

            for (Assento assento : assentos) {
                dtos.add(assentoMapper.toResponse(assento));
            }
            return dtos;

        }

    }

    public AssentoResponse findById(long id) {

        Assento assento = assentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao existe nenhum assento com esse id"));

        return assentoMapper.toResponse(assento);

    }

    public AssentoResponse update(long id, AssentoRequest assentoRequest) {

        Assento assento = assentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao existe nenhum assento com esse id"));

        assento.setCodigo(assentoRequest.codigo());

        Assento assentoSalvo = assentoRepository.save(assento);

        return assentoMapper.toResponse(assentoSalvo);

    }

    public void delete(long id) {
        if (assentoRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Nao existe nenhum assento com esse id");
        } else {
            assentoRepository.deleteById(id);
        }

    }

}
