package com.sda.scheduler2.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Grup")
public class Grup {
    @OneToMany(mappedBy="grup")
    private Set<User> user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grupID;

    private String grupName;

    public Integer getGrupID() {
        return grupID;
    }

    public void setGrupID(Integer grupID) {
        this.grupID = grupID;
    }

    public String getGrupName() {
        return grupName;
    }

    public void setGrupName(String grupName) {
        this.grupName = grupName;
    }
}
