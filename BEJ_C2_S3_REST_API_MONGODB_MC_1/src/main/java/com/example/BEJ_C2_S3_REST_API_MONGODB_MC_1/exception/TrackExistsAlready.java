package com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Track with code already exists")
public class TrackExistsAlready extends Exception {

}
