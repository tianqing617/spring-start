package top.smartliu.domain;

import java.util.List;

public class Customer {
    private  int id;
    private String name;
    private String sex;
    private List<Order> orderList;
    private List<Role> RoleList;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Role> getRoleList() {
        return RoleList;
    }

    public void setRoleList(List<Role> roleList) {
        RoleList = roleList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", orderList=" + orderList +
                ", RoleList=" + RoleList +
                '}';
    }
}
