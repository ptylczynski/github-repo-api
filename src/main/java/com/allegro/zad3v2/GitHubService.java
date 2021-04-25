package com.allegro.zad3v2;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GitHubService {
    private WebClient webClient;
    private final String API_URL = "https://api.github.com/";

    @PostConstruct
    private void Init() {
        webClient = WebClient.create(API_URL);
    }

    public Collection<GitHubRepo> fetchRepos(String userName) {
        int i = 1;
        Collection<GitHubRepo> total = new ArrayList<>();
        List<GitHubRepo> repo = new ArrayList<>();
        while(true) {
            final Integer ii = i;
            repo = webClient.get()
                    .uri(uriBuilder ->
                            uriBuilder
                                    .path("users/" + userName + "/repos")
                                    .queryParam("page", ii)
                                    .queryParam("per_page", 100)
                                    .build()
                    )
                    .retrieve()
                    .bodyToFlux(GitHubRepo.class).collectList().block();
            if(repo.size() == 0) {
                break;
            }

            i++;
            total.addAll(repo);
        }
        return total;
    }

    public GitHubStars getStars(String userName) {
        Collection<GitHubRepo> fetch = fetchRepos(userName);
        Integer count = 0;
        for (GitHubRepo i: fetch) { count += i.getStargazers_count(); }
        return GitHubStars.builder().starCount(count).name(userName).build();
    }
}
