package taskA.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int avGrade;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String sex;
}
