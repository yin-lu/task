package com.yl.entity;

public class Second {
    private Long id;

    private String name;

    private Long firstId;

    private Integer state;

    private Long createAt;

    private Long updateAt;

    private String editor;

    public Second(Long id, String name, Long firstId, Integer state, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.name = name;
        this.firstId = firstId;
        this.state = state;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public Second() {
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

    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
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

    public String toString() {
        return "Second{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstId='" + firstId + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }
}