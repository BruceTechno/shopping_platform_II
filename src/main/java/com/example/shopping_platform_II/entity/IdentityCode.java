package com.example.shopping_platform_II.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "identity_code")
public class IdentityCode {
    @Id
    @Column(name ="code" )
    private int code;
    @Column(name = "identity")
    private String identity;
//=========================================================================================
    public IdentityCode() {
    }
//============================================================================================

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
