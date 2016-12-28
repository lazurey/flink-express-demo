package com.express.flink.examples;

public class ParcelTrack {

    private String parcelId;
    private String[] tracks;

    public ParcelTrack(String parcelId) {

    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    public void setTracks(String[] tracks) {
        this.tracks = tracks;
    }

    public String getParcelId() {
        return parcelId;
    }

    public String[] getTracks() {
        return tracks;
    }

    public void addTrack() {

    }

    @Override
    public String toString() {
        String text = "";
        for (String track: tracks) {
            text = text + "\n" + track;
        }
        return text;
    }

}
