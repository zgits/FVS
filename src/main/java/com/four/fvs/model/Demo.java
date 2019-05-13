package com.four.fvs.model;

/**
 * @Author: zjf
 * @Date: 2019/5/13 23:07
 * @Description:
 */
public class Demo {
    private Integer id;

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
