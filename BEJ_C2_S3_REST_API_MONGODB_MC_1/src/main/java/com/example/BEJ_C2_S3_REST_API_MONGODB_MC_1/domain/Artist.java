package com.example.BEJ_C2_S3_REST_API_MONGODB_MC_1.domain;

public class Artist {

    private String artistId;
    private String artistName;

    public Artist() {
    }

    public Artist(String artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId='" + artistId + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}

