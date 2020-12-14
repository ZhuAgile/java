package com.zmy.spring.soundsystem;

/*import org.springframework.stereotype.Component;*/

/*@Component(value="lonelyHeartClub")*/
public class SgtPeppers implements CompactDisc{

    private String title = "Sgt. Pepper's Lonely Heats Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing" + title + " by " + artist);
    }
}