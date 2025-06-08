package design_patterns.creational;

//Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

interface MediaPlayer {
    void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    public void playMp4(String fileName) {
        //do nothing
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        //do nothing
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

public class AdapterPattern {
    public void main(String[] args) {
        AdvancedMediaPlayer vlcPlayer = new VlcPlayer();
        vlcPlayer.playVlc("example1.vlc");

        AdvancedMediaPlayer mp4Player = new Mp4Player();
        mp4Player.playMp4("example2.mp4");
    }
}
