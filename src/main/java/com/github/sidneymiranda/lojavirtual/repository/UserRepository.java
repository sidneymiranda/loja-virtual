package com.github.sidneymiranda.lojavirtual.repository;

import com.github.sidneymiranda.lojavirtual.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {
    Optional<User> findUserByUsername(String username);
}
