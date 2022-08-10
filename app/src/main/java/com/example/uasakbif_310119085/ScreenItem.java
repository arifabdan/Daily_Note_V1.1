package com.example.uasakbif_310119085;
//NIM : 10119085
//Nama : Arif Abdan Syakur
//Kelas : IF-3
public class ScreenItem {
    String screen_title, screen_desc, screen_swipe;

    public ScreenItem(String screen_title, String screen_desc, String screen_swipe) {
        this.screen_title = screen_title;
        this.screen_desc = screen_desc;
        this.screen_swipe = screen_swipe;
    }

    public void setScreen_title(String screen_title) {
        this.screen_title = screen_title;
    }

    public void setScreen_desc(String screen_desc) {
        this.screen_desc = screen_desc;
    }

    public void setScreen_swipe(String screen_swipe) {
        this.screen_swipe = screen_swipe;
    }

    public String getScreen_title() {
        return screen_title;
    }

    public String getScreen_desc() {
        return screen_desc;
    }

    public String getScreen_swipe() {
        return screen_swipe;
    }
}
