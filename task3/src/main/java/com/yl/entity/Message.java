package com.yl.entity;

public class Message {
    private Long id;

    private Long articleId;

    private String nick;

    private Integer state;

    private Long createAt;

    private Long updateAt;

    private String editor;

    public Message(Long id, Long articleId, String nick, Integer state, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.articleId = articleId;
        this.nick = nick;
        this.state = state;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public Message() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
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
        return "Message{" +
                "id=" + id +
                ", articleId='" + articleId + '\'' +
                ", nick='" + nick + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }
}