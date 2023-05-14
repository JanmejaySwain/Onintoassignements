package com.movies.payload;
public class SubTotalResponse {
    private String genre;
    private Long numVotesSubtotal;
    public SubTotalResponse(String genre, Long numVotesSubtotal) {
        this.genre = genre;
        this.numVotesSubtotal = numVotesSubtotal;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getNumVotesSubtotal() {
        return numVotesSubtotal;
    }

    public void setNumVotesSubtotal(Long numVotesSubtotal) {
        this.numVotesSubtotal = numVotesSubtotal;
    }

    @Override
    public String toString() {
        return "SubTotalResponse{" +
                "genre='" + genre + '\'' +
                ", numVotesSubtotal=" + numVotesSubtotal +
                '}';
    }
}
