package com.hosick.book.springboot.service.posts;

import com.hosick.book.springboot.domain.posts.Posts;
import com.hosick.book.springboot.domain.posts.PostsRepository;
import com.hosick.book.springboot.web.dto.PostsListResponseDto;
import com.hosick.book.springboot.web.dto.PostsResponseDto;
import com.hosick.book.springboot.web.dto.PostsSaveRequestDto;
import com.hosick.book.springboot.web.dto.PostsUpdateRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();

  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
    posts.update(requestDto.getTitle(), requestDto.getContent());

    return id;
  }

  public PostsResponseDto findById(Long id) {
    Posts entity = postsRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
    return new PostsResponseDto(entity);
  }

  @Transactional
  public List<PostsListResponseDto> findAllDesc() {
    return postsRepository.findAllDesc().stream()
        .map(PostsListResponseDto::new)
        .collect(Collectors.toList());
  }
}
