package shaimaa.ticketmaster.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shaimaa.ticketmaster.domain.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "[user]")
class UserEntity {
    @Id
    private String id;

    @Column(name = "[firstName]")
    private String firstName;

    @Column(name = "[lastName]")
    private String lastName;

    private String email;

    static UserEntity from(User user) {
        return new UserEntity(
          user.getId(),
          null,
          null,
          null
        );
    }
}
