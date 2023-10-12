package toDo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    private String description;
    private Date dueDate;
    private boolean completed;

    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "[" + (completed ? "X" : " ") + "] " + description + " (Due: " + dateFormat.format(dueDate) + ")";

    }
    
}
