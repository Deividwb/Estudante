package br.com.dwb.Estudante.service;

import br.com.dwb.Estudante.entity.Estudante;
import br.com.dwb.Estudante.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    EstudanteRepository estudanteRepository;

    public Estudante saveEstudante(Estudante estudante){
        return estudanteRepository.save(estudante);
    }

    public List<Estudante> listarEstudantes(){
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> listarEstudantePorId(Long id){
        return estudanteRepository.findById(id);
    }

    public void deletarEstudante(Long id){
        estudanteRepository.deleteById(id);
    }
}
