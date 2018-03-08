package pl.sternik.pb.sklep;

public interface Streamable extends Downloadable {

    public byte[] nextPacket();
}
