package com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.service;

import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain.Track;
import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackExistsAlready;
import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.exception.TrackNotExists;
import com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService implements TrackServiceInterface {
    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackExistsAlready {
        if (trackRepository.findById(track.getTrackId()).isPresent()) {
            throw new TrackExistsAlready();
        }
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int trackId) throws TrackNotExists {
        if (trackRepository.findById(trackId).isEmpty()) {
            throw new TrackNotExists();
        }
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> getTrackByRating(int rating) {
        return trackRepository.findByTrackGreaterThan(rating);

    }

    @Override
    public Track getTrackByTrackName(String trackName) {
        return trackRepository.findByTrackName(trackName);
    }

    @Override
    public List<Track> getTrackByArtistName(String artist) {
        return trackRepository.findAllTrackArtistName(artist);
    }
}
