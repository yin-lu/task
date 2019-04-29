package com.yl.pojo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
     * 按照报名表
     * 建立的学生
     * 实体类
     */
    public class Student {
        private int id;
        @NotBlank(message = "姓名不能为空")
        private String name;
        @NotNull(message = "学号不能为空")
        private int number;
        @NotNull(message = "qq不能为空")
        private int qq;
        @NotBlank(message = "修真类型不能为空")
        private String subject;
        @NotNull(message = "入学时间不能为空")
        private long joinTime;
        @NotBlank(message = "学校不能为空")
        private String school;
        @NotBlank(message = "愿望不能为空")
        private String wish;
        @NotBlank(message = "师兄不能为空")
        private String instructor;
        @NotBlank(message = "渠道不能为空")
        private String knowFrom;
        @NotNull(message = "创建时间不能为空")
        private long createAt;
        @NotNull(message = "更新时间不能为空")
        private long updateAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getQq() {
            return qq;
        }

        public void setQq(int qq) {
            this.qq = qq;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public long getJoinTime() {
            return joinTime;
        }

        public void setJoinTime(long joinTime) {
            this.joinTime = joinTime;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getWish() {
            return wish;
        }

        public void setWish(String wish) {
            this.wish = wish;
        }

        public String getInstructor() {
            return instructor;
        }

        public void setInstructor(String instructor) {
            this.instructor = instructor;
        }

        public String getKnowFrom() {
            return knowFrom;
        }

        public void setKnowFrom(String knowFrom) {
            this.knowFrom = knowFrom;
        }

        public long getCreateAt() {
            return createAt;
        }

        public void setCreateAt(long createAt) {
            this.createAt = createAt;
        }

        public long getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(long updateAt) {
            this.updateAt = updateAt;
        }
        public String toString() {
            return"Student[id="+id+",name="+name+",number="+number+",qq="+qq+",subject="+subject+",joinTime="+joinTime+", " +
                    "school="+school+",wish="+wish+",instructor="+instructor+",knowFrom="+knowFrom+",createAt="+createAt+",updateAt="+createAt+"]";
        }

    }


