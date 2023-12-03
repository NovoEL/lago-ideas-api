package xyz.lagosoft.ideas.Projects.model;

import xyz.lagosoft.ideas.common.BaseEntityB;
import xyz.lagosoft.ideas.common.enumeration.StackType;

import jakarta.persistence.*;

@Entity
@Table(name = "stacks")
public class Stack extends BaseEntityB {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String slug;

    private StackType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public StackType getType() {
        return type;
    }

    public void setType(StackType type) {
        this.type = type;
    }
}
