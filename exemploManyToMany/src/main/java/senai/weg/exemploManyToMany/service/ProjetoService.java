package senai.weg.exemploManyToMany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.exemploManyToMany.dto.projeto.ProjetoRequest;
import senai.weg.exemploManyToMany.dto.projeto.ProjetoResponse;
import senai.weg.exemploManyToMany.mapper.ProjetoMapper;
import senai.weg.exemploManyToMany.model.Projeto;
import senai.weg.exemploManyToMany.repository.ProjetoRepository;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final ProjetoMapper projetoMapper;

    public ProjetoResponse create(ProjetoRequest projetoRequest) {

        Projeto projeto = projetoMapper.toRequest(projetoRequest);

        Projeto projetoSalvo = projetoRepository.save(projeto);

        ProjetoResponse projetoResponse = projetoMapper.toResponse(projetoSalvo);

        return projetoResponse;
    }

    public List<ProjetoResponse> listAll() {
        List<Projeto> projetos = projetoRepository.findAll();

        if (projetos.isEmpty()) {
            throw new RuntimeException("Nao existe nenhum projeto cadastrado");
        } else {
            List<ProjetoResponse> dtos = new ArrayList<>();

            for (Projeto projeto : projetos) {
                dtos.add(projetoMapper.toResponse(projeto));
            }
            return dtos;

        }

    }

    public ProjetoResponse findById(long id) {

        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao existe nenhum projeto com esse id"));

        return projetoMapper.toResponse(projeto);

    }

    public ProjetoResponse update(long id, ProjetoRequest projetoRequest) {

        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao existe nenhum projeto com esse id"));

        projeto.setNome(projetoRequest.nome());

        Projeto projetoSalvo = projetoRepository.save(projeto);

        return projetoMapper.toResponse(projetoSalvo);

    }

    public void delete(long id) {
        if (projetoRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Nao existe nenhum projeto com esse id");
        } else {
            projetoRepository.deleteById(id);
        }

    }

}
