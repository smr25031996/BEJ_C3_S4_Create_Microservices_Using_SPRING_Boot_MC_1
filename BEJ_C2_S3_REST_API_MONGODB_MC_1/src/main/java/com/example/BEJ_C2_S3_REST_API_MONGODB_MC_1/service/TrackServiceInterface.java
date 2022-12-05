package com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.service;

import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackExistsAlready;
import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackNotExists;

import java.util.List;

public interface TrackServiceInterface {
    Track saveTrack(Track track) throws TrackExistsAlready;

    List<Track> getAllTracks();

    boolean deleteTrack(int trackId) throws TrackNotExists;

    List<Track> getTrackByRating(int rating);

    Track getTrackByTrackName(String trackName);

    List<Track> getTrackByArtistName(String artist);


}
