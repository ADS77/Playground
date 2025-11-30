package ad.practice.playground.solution.oop.demo.universityManagementSystem.entity;

import ad.practice.playground.solution.oop.demo.universityManagementSystem.interfaces.Displayable;

public abstract class Person implements Displayable {
    protected String id;
    protected String name;
    protected String email;
    protected String phone;

    public Person(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    // Abstract methods - must be implemented by subclasses
    public abstract String getRole();
    public abstract boolean validateData();

    // Concrete methods - common implementation
    @Override
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }

    // Getters and Setters (Encapsulation)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

}
