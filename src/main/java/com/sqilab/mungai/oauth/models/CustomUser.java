package com.sqilab.mungai.oauth.models;

import lombok.Data;

import javax.persistence.*;


/**
 * Created by mungai on 17/07/2017.
 */
@NamedQuery(name = "CustomeUser.stats",query = )
@Entity
@Table(name="USER_ACCOUNT")
public @Data class CustomUser {
    @Id
    @SequenceGenerator(name = "USER_ACCOUNT_SEQ_GEN",allocationSize = 1,sequenceName = "USER_ACCOUNT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER_ACCOUNT_SEQ_GEN")
    long id;
    @Column(unique = true)
    String username;
    String password;
    String firstName;
    String lastName;
    String location;
}
