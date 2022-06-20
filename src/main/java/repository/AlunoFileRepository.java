package repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Aluno;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AlunoFileRepository implements AlunoRepository{

    Path path = Paths.get("resources","alunos.json");

    private void checkPath(){
        try {
            if (!Files.exists(path)) {
                if (!Files.isDirectory(Paths.get("resources"))) {
                    Files.createDirectory(Path.of("resources"));
                    Files.createFile(Path.of("resources", "alunos.json"));
                }
                if (!Files.exists((path))) {
                    Files.createFile(Path.of("resources", "alunos.json"));
                }
                String s = "[]";
                Files.write(Path.of("resources", "alunos.json"),s.getBytes(StandardCharsets.UTF_8));
            }
        } catch (java.io.IOException e){
            e.printStackTrace();
        }
    }

    private boolean writeToJson(Collection<Aluno> alunos){
        ObjectMapper objectMapper = new ObjectMapper();
        String s;
        try {
            s = objectMapper.writeValueAsString(alunos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
        try {
            Files.write(path,s.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(Aluno aluno) {
        List<Aluno> alunosList = getAll();
        TreeSet<Aluno> alunos = new TreeSet<>();
        alunos.addAll(alunosList);
        alunos.add(aluno);

        checkPath();
        return writeToJson(alunos);
    }

    @Override
    public List<Aluno> getAll() {
        checkPath();
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(
                    mapper.readValue(Paths.get("resources", "alunos.json").toFile(),
                    Aluno[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
            return Arrays.asList();
        }
    }

    @Override
    public Aluno getById(long id) {
        checkPath();
        List<Aluno> all = getAll();
        return all.get((int)id - 1);
    }

    @Override
    public boolean edit(Aluno aluno) {
        checkPath();
        if(!remove(aluno)) return false;
        return add(aluno);

    }

    public boolean remove(Aluno aluno) {
        checkPath();

        List<Aluno> alunosList = getAll();
        TreeSet<Aluno> alunos = new TreeSet<>();
        alunos.addAll(alunosList);
        alunos.remove(aluno);
        return writeToJson(alunos);
    }


}


