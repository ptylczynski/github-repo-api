package com.allegro.zad3v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GitHubRepo {
    private Integer id;
    private String name;
    private Integer stargazers_count;
}
