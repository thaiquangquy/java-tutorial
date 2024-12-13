package design_patterns.structural.facade;

import design_patterns.structural.facade.facade.VideoConversionFacade;

public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        converter.convertVideo("youtubevideo.ogg", "mp4");
        converter.convertVideo("youtubevideo.mp4", "ogg");
    }
}
