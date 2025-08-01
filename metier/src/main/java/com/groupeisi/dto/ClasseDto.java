package com.groupeisi.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClasseDto implements Serializable {

    @XmlElement(name = "idClasse", required = true)
    private Integer id; // Changement de Long à Integer

    @XmlElement(name = "className", required = true)
    private String className;

    @XmlElement(name = "description", required = true)
    private String description;

    public ClasseDto() {
        super();
    }

    // Le constructeur a été mis à jour pour utiliser Integer pour l'id
    public ClasseDto(Integer id, String className, String description) {
        super();
        this.id = id;
        this.className = className;
        this.description = description;
    }

    // Getters / Setters mis à jour pour utiliser Integer pour l'id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}