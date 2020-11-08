package com.omid.graphql.demographql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Query implements GraphQLQueryResolver , CommandLineRunner {
    @Autowired
    private PostDao postDao;

    public Post getRecentPost(Long id) {
        return postDao.getRecentPosts().get(0);
    }

    public List<Post> getRecentPosts() {
        return postDao.getRecentPosts();
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(postDao.getRecentPosts().get(0));
    }
}
