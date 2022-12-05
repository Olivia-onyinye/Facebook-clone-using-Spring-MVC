package com.example.thisweek7task.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_user",
      uniqueConstraints = @UniqueConstraint(
              name = "email_unique",
              columnNames = "user_email"
      )
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(name = "user_email",
            nullable = false
    )
    private String email;

    @Column(nullable = false, length = 15)
    private String gender;

    @Column(nullable = false, length = 25)
    private String password;

}
