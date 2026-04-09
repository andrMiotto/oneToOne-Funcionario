package senai.weg.exemploManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import senai.weg.exemploManyToMany.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
