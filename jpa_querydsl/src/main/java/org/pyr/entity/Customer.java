package org.pyr.entity;

import javax.persistence.*;

@Entity
@Table(name = "cst_customer")
public class Customer {

    @Id //声明主键的配置
    @GeneratedValue(strategy = GenerationType.IDENTITY) //:配置主键的生成策略: .IDENTITY ：自增，mysql
    @Column(name = "cust_id") // 配置属性和字段的映射关系  name：数据库表中字段的名称
    private Long custId; //客户的主键

    @Column(name = "cust_name")
    private String custName;//客户名称

    @Column(name = "address")
    private String address;//地址

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
