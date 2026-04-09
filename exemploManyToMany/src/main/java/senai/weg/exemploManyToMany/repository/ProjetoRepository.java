package senai.weg.exemploManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import senai.weg.exemploManyToMany.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
