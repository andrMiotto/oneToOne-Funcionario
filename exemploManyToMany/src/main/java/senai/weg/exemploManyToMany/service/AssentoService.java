package senai.weg.exemploManyToMany.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.exemploManyToMany.dto.assento.AssentoResponse;
import senai.weg.exemploManyToMany.mapper.AssentoMapper;
import senai.weg.exemploManyToMany.repository.AssentoRepository;

@Service
@RequiredArgsConstructor
public class AssentoService {

    private final AssentoRepository assentoRepository;
    private final AssentoMapper assentoMapper;



}
