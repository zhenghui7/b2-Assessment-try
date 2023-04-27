package ibf2022.paf.assessment.server.models;

// TODO: Task 4

public class Task {
    private String description;
    private String priority;
    private String dueDate;

    public Task() {
    }

    public Task(String description, String priority, String dueDate) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task [description=" + description + ", priority=" + priority + ", dueDate=" + dueDate + "]";
    }

}
