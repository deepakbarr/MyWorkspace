package com.workspace.demos;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by deepak.barr on 23/2/15.
 */

@Entity
@Table(name = "item", catalog = "demoDB", uniqueConstraints =
        @UniqueConstraint(columnNames = "item_name"))
public class Item {
    private String name;
    private long price;

    @Id
    @Column(name = "item_name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "item_price", nullable = false)
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
