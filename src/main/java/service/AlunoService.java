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

    public Aluno getById(long id){
        return repository.getById(id);
    }

    public boolean edit(Aluno aluno){
        return repository.edit(aluno);
    }
}
