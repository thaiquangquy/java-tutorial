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
    public static void main(String[] args) {
        AdvancedMediaPlayer vlcPlayer = new VlcPlayer();
        vlcPlayer.playVlc("example1.vlc");

        AdvancedMediaPlayer mp4Player = new Mp4Player();
        mp4Player.playMp4("example2.mp4");
    }
}

public static String EvenPairs(String str) {
    String result = "false";
    HashMap<number, number> evenNum = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
        if (Character.isDigit(str[i])) {
            int d
            evenNum.put(i, )
        }
    }

    // code goes here
    int first_idx = 0;
    int last_idx = 0;
    while(first_idx <= last_idx && )
        return result;
}
