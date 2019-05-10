package com.yl.entity;

public class User {
    private Long id;

    private String name;

    private String password;

    private String role;

    private Long createAt;

    private Long updateAt;

    private String editor;

    public User(Long id, String name, String password, String role, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", role=" + role +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }
}