package senai.weg.exemploManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import senai.weg.exemploManyToMany.model.Assento;

public interface AssentoRepository extends JpaRepository<Assento,Long> {

    
}
