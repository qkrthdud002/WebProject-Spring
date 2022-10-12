package com.spring.web.repository;

import com.spring.web.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {

}
