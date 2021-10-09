package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter @Getter
public class Member {

    @Id
    private Long id;

    private String name;

    private Integer age;

}
