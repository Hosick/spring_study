package com.hosick.book.springboot.domain.posts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long> {

  @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
  List<Posts> findAllDesc();
}