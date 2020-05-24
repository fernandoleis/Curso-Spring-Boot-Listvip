package br.com.aluras.listavip.service;

import br.com.aluras.listavip.model.Convidado;
import br.com.aluras.listavip.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadeService {

    @Autowired
    private ConvidadoRepository repository;

    public Iterable<Convidado> obterTodos(){
        Iterable<Convidado> convidados = repository.findAll();
        return convidados;
    }

    public void salvar(Convidado convidado){
        repository.save(convidado);
    }

}

