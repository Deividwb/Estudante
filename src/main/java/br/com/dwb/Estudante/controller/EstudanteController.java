package br.com.dwb.Estudante.controller;

import br.com.dwb.Estudante.entity.Estudante;
import br.com.dwb.Estudante.service.EstudanteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    EstudanteService estudanteService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Estudante salvar(@RequestBody Estudante estudante){
        return estudanteService.saveEstudante(estudante);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Estudante> listar(){
        return estudanteService.listarEstudantes();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private Optional<Estudante> listarPorId(@PathVariable Long id){
        return estudanteService.listarEstudantePorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void atualizar(@RequestBody Estudante estudante,@PathVariable Long id){
        estudanteService.listarEstudantePorId(id)
                .map(estudanteBase -> {
                    modelMapper.map(estudante,estudanteBase);
                    estudanteService.saveEstudante(estudanteBase);
                    return Void.TYPE;
                }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Estudante not found"));

    }

    @DeleteMapping("/{id}")
    private void deletar(@PathVariable Long id){
        estudanteService.listarEstudantePorId(id)
                .map(estudante -> {
                    estudanteService.deletarEstudante(estudante.getId());
                    return Void.TYPE;
                }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Estudante not found"));
    }
}
