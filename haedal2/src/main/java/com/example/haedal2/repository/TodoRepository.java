package com.example.haedal2.repository;

import com.example.haedal2.domain.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;


/*@Repository
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

    public Todo findById(Long id){
        TypedQuery<Todo> todo;
        todo = em.createQuery("select t from Todo t where t.id = :id", Todo.class);
        todo.setParameter("id", id);

        return todo.getSingleResult();
    }

    public void delete(Long id){
        Todo todo = findById(id);
        em.remove(todo);
    }


    public void update(Long id){
        Todo todo = findById(id);
        todo.setDone(!todo.isDone());
    }


}*/

@Repository
public class TodoRepository {
    private final JdbcTemplate jdbcTemplate;

    public TodoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }




    public boolean create(String task) {
        try{
            this.jdbcTemplate.update("insert into todo (task,done) values (?,false)",task);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public List<Todo> findTodo() {
        return jdbcTemplate.query("select * from todo", (resultSet, rowNum) ->
                new Todo(resultSet.getLong("id"),
                        resultSet.getString("task"),
                        resultSet.getBoolean("done"))
        );
    }
    public Todo findById(Long id) {
        return jdbcTemplate.queryForObject("select * from todo where id =? ", new Object[]{id}, (resultSet, rowNum) ->
                new Todo(resultSet.getLong("id"),
                        resultSet.getString("task"),
                        resultSet.getBoolean("done"))
        );
    }

    public void delete(Long id){
        this.jdbcTemplate.update("delete from todo where id = ?",id);
    }

    public void update(Long id){
        this.jdbcTemplate.update(
                "update todo set done = ? where id = ?",
                true, id);

    }

}