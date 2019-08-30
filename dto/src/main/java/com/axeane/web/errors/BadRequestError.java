package com.axeane.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestError extends AbstractThrowableProblem {

        private static final long serialVersionUID = 1L;

        public BadRequestError() {
            super(URI.create(""), "BadRequestError", Status.BAD_REQUEST, "bad request");


        }

    }
