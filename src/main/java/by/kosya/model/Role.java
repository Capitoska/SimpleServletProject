package by.kosya.model;

public enum Role {
    USER("user", 1),
    ADMIN("admin", 2);


    public String getDisplay() {
        return display;
    }

    public Integer getId() {
        return id;
    }

    private String display;
    private Integer id;
    Role(String display, Integer id) {
    this.display = display;
    this.id = id;
    }
}
