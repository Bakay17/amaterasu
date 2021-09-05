package org.example.model;

import lombok.*;

import java.sql.Timestamp;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel {
    private Integer id;
    private String name;
    private Date birthYear;
    private String gender;
    private Timestamp requestDateTime;
}
