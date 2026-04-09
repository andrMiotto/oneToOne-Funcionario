package senai.weg.exemploManyToMany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioRequest;
import senai.weg.exemploManyToMany.dto.funcionario.FuncionarioResponse;
import senai.weg.exemploManyToMany.mapper.FuncionarioMapper;
import senai.weg.exemploManyToMany.model.Funcionario;
import senai.weg.exemploManyToMany.repository.FuncionarioRepository;

@RequiredArgsConstructor
@Service
public class FuncionarioService {

    private final FuncionarioMapper funcionarioMapper;
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioResponse create(FuncionarioRequest funcionarioRequest) {

        Funcionario funcionario = funcionarioMapper.toRequest(funcionarioRequest);

        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        FuncionarioResponse funcionarioResponse = funcionarioMapper.toResponse(funcionarioSalvo);

        return funcionarioResponse;
    }

    public List<FuncionarioResponse> listAll() {

        if (funcionarioRepository.findAll().isEmpty()) {
            throw new RuntimeException("Nao existe nenhum funcionario cadastrado");
        } else {
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            List<FuncionarioResponse> dtos = new ArrayList<>();

            for (Funcionario funcionario : funcionarios) {
                dtos.add(funcionarioMapper.toResponse(funcionario));
            }
            return dtos;

        }

    }

    public FuncionarioResponse findById(long id) {

        if (funcionarioRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Nao existe nenhum funcinario com esse id");
        } else {
            Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
            FuncionarioResponse funcionarioResponse = funcionarioMapper.toResponse(funcionario);

            return funcionarioResponse;
        }

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

}
