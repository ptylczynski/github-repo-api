package com.allegro.zad3v2;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class MainController {

    @Data
    public static class ErrorResponse {
        private String errorCode;
        private String message;
    }

    @Autowired
    private GitHubService gitHubService;

    @GetMapping(path = "/find/{githubProfile}",  produces = "application/json")
    public Collection<GitHubRepo> findUser(@PathVariable(name = "githubProfile") String profile) {
        return gitHubService.fetchRepos(profile);
    }

    @GetMapping(path = "/stars/{githubProfile}")
    public GitHubStars countStars(@PathVariable(name = "githubProfile") String profile) {
        return gitHubService.getStars(profile);
    }
}
