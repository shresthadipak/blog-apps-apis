package com.apps.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceBadRequestException extends RuntimeException{
    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceBadRequestException(String resourceName, String fieldName, long fieldValue){
        super(String.format("%s is bad request to call this %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
