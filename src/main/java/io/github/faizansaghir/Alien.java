package io.github.faizansaghir;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "alien")
@Table(name="alien")
public class Alien {

    @Id
    @Column(name = "aid")
    private int aid;

    private Name aname;
    @Column(name = "color")
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Name getAname() {
        return aname;
    }

    public void setAname(Name aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname=" + aname +
                ", color='" + color + '\'' +
                '}';
    }
}
