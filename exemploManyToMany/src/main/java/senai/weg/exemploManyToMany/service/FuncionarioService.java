package senai.weg.exemploManyToMany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioRequest;
import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioResponse;
import senai.weg.exemploManyToMany.mapper.FuncionarioMapper;
import senai.weg.exemploManyToMany.model.Assento;
import senai.weg.exemploManyToMany.model.Funcionario;
import senai.weg.exemploManyToMany.model.Projeto;
import senai.weg.exemploManyToMany.repository.AssentoRepository;
import senai.weg.exemploManyToMany.repository.FuncionarioRepository;
import senai.weg.exemploManyToMany.repository.ProjetoRepository;

@RequiredArgsConstructor
@Service
public class FuncionarioService {

    private final FuncionarioMapper funcionarioMapper;
    private final FuncionarioRepository funcionarioRepository;
    private final AssentoRepository assentoRepository;
    private final ProjetoRepository projetoRepository;

    public FuncionarioResponse create(FuncionarioRequest funcionarioRequest) {

        Funcionario funcionario = funcionarioMapper.toRequest(funcionarioRequest);

        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        FuncionarioResponse funcionarioResponse = funcionarioMapper.toResponse(funcionarioSalvo);

        return funcionarioResponse;
    }

    public List<FuncionarioResponse> listAll() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        if (funcionarios.isEmpty()) {
            throw new RuntimeException("Nao existe nenhum funcionario cadastrado");
        } else {
            List<FuncionarioResponse> dtos = new ArrayList<>();

            for (Funcionario funcionario : funcionarios) {
                dtos.add(funcionarioMapper.toResponse(funcionario));
            }
            return dtos;

        }

    }

    public FuncionarioResponse findById(long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao existe nenhum funcinario com esse id"));

        return funcionarioMapper.toResponse(funcionario);
    }

    public FuncionarioResponse update(long id, FuncionarioRequest funcionarioRequest) {

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nao existe nenhum funcionario com esse id"));

        funcionario.setNome(funcionarioRequest.nome());

        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        return funcionarioMapper.toResponse(funcionarioSalvo);

    }

    public void delete(long id) {
        if (funcionarioRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Nao existe nenhum funcinario com esse id");
        } else {
            funcionarioRepository.deleteById(id);
        }

    }

    public FuncionarioResponse associarAssento(long funcionario_id, long assento_id) {

        Funcionario funcionario = funcionarioRepository.findById(funcionario_id)
                .orElseThrow(() -> new RuntimeException("Nao existe nenhum funcionario com esse id"));

        Assento assento = assentoRepository.findById(assento_id)
                .orElseThrow(() -> new RuntimeException("Nao existe nenhum assento com esse id"));

        funcionario.setAssento(assento);

        return funcionarioMapper.toResponse(funcionarioRepository.save(funcionario));
    }

    public FuncionarioResponse associarProjeto(long funcionario_id, long projeto_id) {

        Funcionario funcionario = funcionarioRepository.findById(funcionario_id)
                .orElseThrow(() -> new RuntimeException("Nao existe funcionario com esse id"));

        Projeto projeto = projetoRepository.findById(projeto_id)
                .orElseThrow(() -> new RuntimeException("Nao existe projeto com esse id"));

        funcionario.getProjetos().add(projeto);

        return funcionarioMapper.toResponse(funcionarioRepository.save(funcionario));
    }
}
