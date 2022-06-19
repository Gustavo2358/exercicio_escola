package service;

import domain.Aluno;
import repository.AlunoRepository;

import java.util.List;

public class AlunoService {

    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public boolean add(Aluno aluno){
        return repository.add(aluno);
    }

    public List<Aluno> getAll(){
        return repository.getAll();
    }
}
