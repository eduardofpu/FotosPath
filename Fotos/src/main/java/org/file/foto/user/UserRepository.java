package org.file.foto.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByEmail(String email);

	public List<UserEntity> findByEmailOrName(String email, String name);

}
