package com.example.reproductor;

public class ViewPagerItem {
    private int imageResource;
    private String title;

    public ViewPagerItem(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;
    }

    // Getters
    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    // Setters (opcional, si quieres modificar los valores)
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

