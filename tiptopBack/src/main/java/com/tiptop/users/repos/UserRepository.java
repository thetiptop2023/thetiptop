package com.tiptop.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tiptop.users.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	@Query(value = "SELECT u FROM User u WHERE u.user_id IN (SELECT t.user.user_id FROM Ticket t WHERE t.ticketNumber IS NOT NULL) ORDER BY RAND() LIMIT 1", nativeQuery = true)
	User findRandomUser();


}