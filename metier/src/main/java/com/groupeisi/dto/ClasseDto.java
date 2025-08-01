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
    private Long id;

    @XmlElement(name = "className", required = true)
    private String className;

    @XmlElement(name = "description", required = true)
    private String description;

    // Optionnel : On peut aussi référencer le secteur par son id (Long sectorId) si besoin,
    // mais ici on reste simple et on ne met pas la relation entière.

    public ClasseDto() {
        super();
    }

    public ClasseDto(Long id, String className, String description) {
        super();
        this.id = id;
        this.className = className;
        this.description = description;
    }

    // Getters / Setters
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
}
