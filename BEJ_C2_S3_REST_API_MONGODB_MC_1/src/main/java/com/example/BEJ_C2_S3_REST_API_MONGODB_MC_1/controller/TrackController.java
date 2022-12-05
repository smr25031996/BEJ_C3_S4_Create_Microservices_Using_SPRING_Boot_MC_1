package com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.controller;

import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackExistsAlready;
import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackNotExists;
import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.service.TrackServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    private final TrackServiceInterface trackServiceInterface;

    @Autowired
    public TrackController(TrackServiceInterface trackServiceInterface) {
        this.trackServiceInterface = trackServiceInterface;
    }

    @PostMapping("/saveTrack")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackExistsAlready {
        try {
            return new ResponseEntity<>(trackServiceInterface.saveTrack(track), HttpStatus.ACCEPTED);

        } catch (TrackExistsAlready existsAlready) {
            return new ResponseEntity<>("Track already exists", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/getAllTracks")
    public ResponseEntity<?> getALllTracks() {
        return new ResponseEntity<>(trackServiceInterface.getAllTracks(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTrack/{trackId}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int trackId) throws TrackNotExists {
        try {
            return new ResponseEntity<>(trackServiceInterface.deleteTrack(trackId), HttpStatus.OK);

        } catch (TrackNotExists trackNotExists) {
            return new ResponseEntity<>("Track not Exists", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getTrackByRating/{rating}")
    public ResponseEntity<?> getTrackByRating(@PathVariable int rating) {
        return new ResponseEntity<>(trackServiceInterface.getTrackByRating(rating), HttpStatus.OK);
    }

    @GetMapping("/getTrackByName/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackName) {
        return new ResponseEntity<>(trackServiceInterface.getTrackByTrackName(trackName), HttpStatus.OK);
    }

    @GetMapping("/getTrackByTrackArtists/{artist}")
    public ResponseEntity<?> getTrackByTrackArtists(@PathVariable String artist) {
        return new ResponseEntity<>(trackServiceInterface.getTrackByArtistName(artist), HttpStatus.OK);
    }


}
