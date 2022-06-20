package repository;

import domain.Aluno;

import java.util.List;

public interface AlunoRepository {
    boolean add(Aluno aluno);
    List<Aluno> getAll();
    Aluno getById(long id);
    boolean edit(Aluno aluno);
    boolean remove(Aluno aluno);
}
