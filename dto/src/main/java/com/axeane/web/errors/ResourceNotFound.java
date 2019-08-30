package com.axeane.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public ResourceNotFound() {
        super(URI.create(""), "Resource not found", Status.NOT_FOUND, "Resource not not found");


    }
}
