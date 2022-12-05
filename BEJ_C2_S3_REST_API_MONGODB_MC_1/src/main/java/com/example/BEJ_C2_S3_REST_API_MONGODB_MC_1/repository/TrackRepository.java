package com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.repository;

import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track, Integer> {
    @Query("{trackRating : {$gt : ?0} }")
    List<Track> findByTrackGreaterThan(int rating);

    Track findByTrackName(String trackName);

    @Query("{'trackArtist.artistName':{$in:[?0]}}")
    List<Track> findAllTrackArtistName(String artistName);


}
