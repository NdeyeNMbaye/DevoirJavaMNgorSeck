package com.groupeisi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "classes")
public class ClasseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "description", length = 500)
    private String description;

    // Chaque classe appartient à un seul secteur
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", nullable = false)
    private SectorEntity sector;

    public ClasseEntity() {
    }

    public ClasseEntity(Long id, String className, String description, SectorEntity sector) {
        this.id = id;
        this.className = className;
        this.description = description;
        this.sector = sector;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SectorEntity getSector() {
        return sector;
    }

    public void setSector(SectorEntity sector) {
        this.sector = sector;
    }
}
