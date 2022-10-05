package com.spring.web.service;

import com.spring.web.domain.NameBookPost;
import com.spring.web.entity.NameBookPostEntity;
import com.spring.web.repository.NameBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value = "nameBookService")
public class NameBookServiceImpl implements NameBookService {

    private NameBookRepository nameBookRepository;

    @Autowired
    public void setNameBookRepository(NameBookRepository nameBookRepository) {
        this.nameBookRepository = nameBookRepository;
    }

    @Override
    public NameBookPost add(NameBookPost post) {
        NameBookPostEntity entity = new NameBookPostEntity();
        entity.setWriter(post.getWriter());
        entity.setContent(post.getContent());
        entity.setRegisterTime(new Date());

        nameBookRepository.save(entity);

        post.setIdx(entity.getIdx());

        return post;
    }
}
