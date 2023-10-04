package com.example.haedalweek2.repository;


import com.example.haedalweek2.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TodoRepository {
    private final JdbcTemplate jdbcTemplate;

    public TodoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean create(String task){
        Todo new_todo = new Todo(task,false);

        try {
            this.jdbcTemplate.update(
                    "insert into Todo (task, done) values (?, ?)",
                    task, false);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Todo> findTodo() {
        return jdbcTemplate.query("select * from Todo", (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getLong("id"));
            todo.setTask(rs.getString("task"));
            todo.setDone(rs.getBoolean("done"));
            return todo;
        });
    }

    public Todo findById(Long id) {
        return jdbcTemplate.queryForObject("select * from Todo where id = ?", new Object[]{id}, (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getLong("id"));
            todo.setTask(rs.getString("task"));
            todo.setDone(rs.getBoolean("done"));
            return todo;
        });
    }

    public void delete(Long id){
        this.jdbcTemplate.update(
                "delete from Todo where id = ?",
                id);
    }

    public void update(Long id){
        this.jdbcTemplate.update(
                "update Todo set done = ? where id = ?",
                true, id);

    }

}
