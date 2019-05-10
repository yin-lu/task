package com.yl.entity;

public class Article {
    private Long id;

    private String name;

    private Long firstId;

    private Long secondId;

    private Integer state;

    private String intro;

    private String thumbnails;

    private String vedio;

    private String picture;

    private String introduction;

    private Long createAt;

    private Long updateAt;

    private String editor;

    public Article(Long id, String name, Long firstId, Long secondId, Integer state, String intro, String thumbnails, String vedio, String picture, String introduction, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.name = name;
        this.firstId = firstId;
        this.secondId = secondId;
        this.state = state;
        this.intro = intro;
        this.thumbnails = thumbnails;
        this.vedio = vedio;
        this.picture = picture;
        this.introduction = introduction;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public Article() {
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

    public Long getSecondId() {
        return secondId;
    }

    public void setSecondId(Long secondId) {
        this.secondId = secondId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails == null ? null : thumbnails.trim();
    }

    public String getVedio() {
        return vedio;
    }

    public void setVedio(String vedio) {
        this.vedio = vedio == null ? null : vedio.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
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
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstId=" + firstId +
                ", secondId=" + secondId +
                ", state='" + state + '\'' +
                ", intro=" + intro +
                ", thumbnails=" + thumbnails +
                ", vedio="+ vedio+
                ", picture=" + picture +
                ", introduction="+ introduction+
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }
}