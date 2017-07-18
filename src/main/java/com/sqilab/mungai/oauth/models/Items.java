package com.sqilab.mungai.oauth.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mungai on 17/07/2017.
 */
@Entity
@Table(name="CART_ITEMS")
public @Data class Items {
    @Id
    long itemId;
    String name;
}
