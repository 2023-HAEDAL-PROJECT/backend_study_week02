package com.example.haedalweek2.repository;

import com.example.haedalweek2.domain.Todo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class TodoRepository {
    private final EntityManager em;

    public boolean create(String task){
        Todo new_todo = new Todo(task,false);

        try {
            em.persist(new_todo);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Todo> findTodo(){
        List<Todo> todoList;
        todoList = em.createQuery("SELECT t FROM Todo t", Todo.class)
                .getResultList();

        return todoList;
    }


}
