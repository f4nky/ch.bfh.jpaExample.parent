package ch.bfh.jpaExample.model;

import javax.persistence.*;
import java.util.List;

// Klasse wird in der Persistence Unit
// als Entity erkannt
@Entity
public class Project {
    private Long id;
    private String title;
    private List<Task> tasks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}


