package com.spring.web.repository;

import com.spring.web.entity.NameBookPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameBookRepository extends JpaRepository<NameBookPostEntity, Long> {
}
