package com.yl.entity;

public class Reply {
    private Long id;

    private String nick;

    private Long messageId;

    private String word;

    private Long createAt;

    private Long updateAt;

    private String editor;

    public Reply(Long id, String nick, Long messageId, String word, Long createAt, Long updateAt, String editor) {
        this.id = id;
        this.nick = nick;
        this.messageId = messageId;
        this.word = word;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.editor = editor;
    }

    public Reply() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
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
        return "Reply{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", messageId='" + messageId + '\'' +
                ", word=" + word +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", editor='" + editor + '\'' +
                '}';
    }
}