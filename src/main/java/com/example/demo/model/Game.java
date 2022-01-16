package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(length = 80, nullable = false)
    public String name;

    @Column(length = 30)
    public String system;

    @Column(length = 80)
    public String developer;

    @Column(nullable = false)
    public long uploader_id;

    @Column(nullable = false)
    public float price;

//    @Lob
    @Column(length = 250000)
    public String image;




//    @Lob
//    @Column
//    public byte[] picture;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public long getUploader_id() {
        return uploader_id;
    }

    public void setUploader_id(long uploader_id) {
        this.uploader_id = uploader_id;
    }

    //    public byte[] getPicture() {return picture;}
//    public void setPicture(byte[] picture) {this.picture = picture;}

    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}
    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}


}
