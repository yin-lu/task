package com.yl.entity;

public class Studio {
    private Long id;

    private String name;

    private String picture;

    private String text;

    private Integer state;

    private Long createAt;

    private Long updateAt;

    private String editor;

    public Studio(Long id, String name, String picture, String text, Integer state, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.text = text;
        this.state = state;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public Studio() {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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
        return "Studio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture=" + picture +
                ", text=" + text +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }
}