package com.apps.blog.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
    private List<PostDto> content;
    private Integer pageNumber;
    private Integer pageSize;
    private String sortBy;
    private String sortOrder;
    private Long totalElements;
    private Integer totalPages;
    private boolean firstPage;
    private boolean lastPage;

}
