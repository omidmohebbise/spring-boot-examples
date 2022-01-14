package com.omidmohebbise.todoapp.identity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;

//@Entity
//@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
}
