package com.csair.entity;
import javax.persistence.*;

/**
 * Created by mac on 16/12/13.
 * 美丽说查询商品维护
 */
@Table(name = "mlssortgood")
@Entity
public class Mls_sortgood {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="addressurl")
    private String addressurl;
    @Column(name="type")
    private int type;//类型 1表示流行,2表示热销 3表示上新

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getAddressurl() {
        return addressurl;
    }

    public void setAddressurl(String addressurl) {
        this.addressurl = addressurl;
    }
}
