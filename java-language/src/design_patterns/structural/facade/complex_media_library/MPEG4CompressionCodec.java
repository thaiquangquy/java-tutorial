package design_patterns.structural.facade.complex_media_library;

public class MPEG4CompressionCodec implements Codec {
    public String type = "mp4";

    public String getType() {
        return type;
    }
}
