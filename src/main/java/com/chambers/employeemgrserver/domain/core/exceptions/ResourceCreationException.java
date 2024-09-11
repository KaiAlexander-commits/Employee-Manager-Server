package com.chambers.employeemgrserver.domain.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceCreationException extends RuntimeException{
  public ResourceCreationException(String message) {
    super(message);
  }
}