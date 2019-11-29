package by.kosya.model;

public enum Role {
    USER("user", 1),
    ADMIN("admin", 2);

    public static Role getById(Role[] enums, int id) {
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getId() == id) {
                return enums[i];
            }
        }
        return null;
    }


    public String getDisplay() {
        return display;
    }

    public  Integer getId() {
        return id;
    }


    private String display;
    private Integer id;
    Role(String display, Integer id) {
    this.display = display;
    this.id = id;
    }
}
