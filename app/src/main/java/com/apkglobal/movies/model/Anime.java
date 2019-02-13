package com.apkglobal.movies.model;

public class Anime
{
    private String name;
    private String description;
    private String rating;
    private int    noEpisode;
    private String categories;
    private String studio;
    private String img_url;

    public Anime()
    {
    }

    public Anime(String name, String description, String rating,
                 int noEpisode, String categories, String studio, String img_url)
    {
        this.name           = name;
        this.description    = description;
        this.rating         = rating;
        this.noEpisode      = noEpisode;
        this.categories     = categories;
        this.studio         = studio;
        this.img_url        = img_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public int getNoEpisode() {
        return noEpisode;
    }

    public String getCategories() {
        return categories;
    }

    public String getStudio() {
        return studio;
    }

    public String getImg_url() {
        return img_url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setNoEpisode(int noEpisode) {
        this.noEpisode = noEpisode;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
