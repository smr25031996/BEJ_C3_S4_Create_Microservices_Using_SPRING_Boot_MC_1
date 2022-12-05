package com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Track not Exists")
public class TrackNotExists extends Exception {

}
