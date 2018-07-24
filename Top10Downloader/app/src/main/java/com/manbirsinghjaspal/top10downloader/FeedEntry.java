package com.manbirsinghjaspal.top10downloader;

public class FeedEntry {
    private String name;
    private String artist;
    private String summary;
    private String releaseDate;
    private String imagegURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImagegURL() {
        return imagegURL;
    }

    public void setImagegURL(String imagegURL) {
        this.imagegURL = imagegURL;
    }

    @Override
    public String toString() {
        return "name=" + name + '\n' +
                ", artist=" + artist + '\n' +
                ", releaseDate=" + releaseDate + '\n' +
                ", imagegURL=" + imagegURL + '\n' +
                '}';
    }
}
