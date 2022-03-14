package org.designmode.structure.flyweight.cd_example;

/**
 *  外部状态UnSharedConcreteFlyWeight : title,year
 *  共享的ConcreteFlyweight : artist
 */
public class CD {
    private String title;

    private int year;

    private Artist artist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
