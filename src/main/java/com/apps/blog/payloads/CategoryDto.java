package com.apps.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;

    @NotBlank
    @Size(min = 3, message = "Category title must be more then 3 words")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "Category description must be more then 10 words")
    private String categoryDescription;
}
