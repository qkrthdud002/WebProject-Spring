package com.spring.web.service;

import com.spring.web.domain.NameBookPost;

import java.util.List;

public interface NameBookService {
    public NameBookPost add(NameBookPost post);

    public List<NameBookPost> list();
}
