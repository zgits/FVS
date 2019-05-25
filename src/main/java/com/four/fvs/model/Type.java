package com.four.fvs.model;

/**
 * @Author: zjf
 * @Date: 2019/5/21 13:39
 * @Description: 分类的实体类
 */
public class Type {

    private Integer id;//id

    private String name;//分类名字

    private Integer del;//删除标志 1 未删除，2 已删除

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", del=" + del +
                '}';
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
