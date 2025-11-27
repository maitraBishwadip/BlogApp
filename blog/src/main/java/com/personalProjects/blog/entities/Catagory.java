package com.personalProjects.blog.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "catagories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "catagory")
    private List<Post> posts = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Catagory catagory = (Catagory) o;
        return Objects.equals(id, catagory.id) && Objects.equals(name, catagory.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
