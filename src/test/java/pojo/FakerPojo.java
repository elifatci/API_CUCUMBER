package pojo;


import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FakerPojo {

    private int id;
    private String title;
    private String dueData;
    private boolean completed;

    public FakerPojo() {

    }

    public FakerPojo(int id, String title, String dueData, boolean completed) {
        this.id = id;
        this.title = title;
        this.dueData = dueData;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueData() {
        return dueData;
    }

    public void setDueData(String dueData) {
        this.dueData = dueData;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "FakerPojo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dueData='" + dueData + '\'' +
                ", completed=" + completed +
                '}';
    }
}
