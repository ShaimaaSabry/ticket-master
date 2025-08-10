package shaimaa.ticketmaster.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserSqlRepository extends JpaRepository<UserEntity, String> {
}
