package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
//@Table(name = "USER")
public class Member {

    @Id
    private Long id;

    //@Column(name = "username")
    private String name;
}
