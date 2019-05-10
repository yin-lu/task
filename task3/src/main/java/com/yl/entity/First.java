package com.yl.entity;

public class First {
    private Long id;

    private String name;

    private Integer state;

    private Long createAt;

    private Long updateAt;

    private String editor;

    public First(Long id, String name, Integer state, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public First() {
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        return "First{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }
}