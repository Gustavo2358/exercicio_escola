package repository;

import domain.Aluno;

import java.util.List;

public interface AlunoRepository {
    boolean add(Aluno aluno);
    List<Aluno> getAll();
}
