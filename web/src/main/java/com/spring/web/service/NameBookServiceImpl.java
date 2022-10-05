package com.spring.web.service;

import com.spring.web.domain.NameBookPost;
import com.spring.web.entity.NameBookPostEntity;
import com.spring.web.repository.NameBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<NameBookPost> list() {
        List<NameBookPostEntity> entities =  nameBookRepository.findAll();

        List<NameBookPost> result = new ArrayList<>();
        for(NameBookPostEntity item : entities) {
            NameBookPost post = new NameBookPost();
            post.setIdx(item.getIdx());
            post.setWriter(item.getWriter());
            post.setContent((item.getContent()));

            result.add(post);
        }

        return result;
    }
}
