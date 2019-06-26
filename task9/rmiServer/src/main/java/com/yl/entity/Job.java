package com.yl.entity;

import java.io.Serializable;

public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String direction;

    private String name;

    private String intro;

    private String image;

    private Integer door;

    private Integer complexity;

    private String cycle;

    private Integer scarcity;

    private String one;

    private String two;

    private String three;

    private Integer number;

    private String hint;

    private Long createAt;

    private Long updateAt;

    public Job(Long id, String direction, String name, String intro, String image, Integer door, Integer complexity, String cycle, Integer scarcity, String one, String two, String three, Integer number, String hint, Long createAt, Long updateAt) {
        this.id = id;
        this.direction = direction;
        this.name = name;
        this.intro = intro;
        this.image = image;
        this.door = door;
        this.complexity = complexity;
        this.cycle = cycle;
        this.scarcity = scarcity;
        this.one = one;
        this.two = two;
        this.three = three;
        this.number = number;
        this.hint = hint;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Job() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getDoor() {
        return door;
    }

    public void setDoor(Integer door) {
        this.door = door;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle == null ? null : cycle.trim();
    }

    public Integer getScarcity() {
        return scarcity;
    }

    public void setScarcity(Integer scarcity) {
        this.scarcity = scarcity;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one == null ? null : one.trim();
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two == null ? null : two.trim();
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three == null ? null : three.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint == null ? null : hint.trim();
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

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ",direction=" + direction +
                ",name='" + name + '\'' +
                ",intro=" + intro +
                ",image=" +  image +
                ",door=" +  door +
                ",complexity ='" + complexity  + '\'' +
                ",cycle=" +cycle +
                ",scarcity=" +scarcity +
                ",one="+ one+
                ",two=" + two +
                ",three="+ three+
                ",number=" + number +
                ",hint=" + hint +
                ",createAt=" + createAt +
                ",updateAt=" + updateAt +

                '}';
    }
}