package br.com.dwb.Estudante.repository;

import br.com.dwb.Estudante.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante,Long> {
}
