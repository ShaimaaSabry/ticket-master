package shaimaa.ticketmaster.infrastructure.repositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shaimaa.ticketmaster.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
