package pl.sternik.pb.sklep;

import java.util.Date;

public class Record extends Article implements Streamable {

	private long length;
	private String fileType;

	public long filesize() {
		return length;
	}

	public String fileType() {
		return fileType;
	}

	public byte[] nextPacket() {
		return null;
	}

	public Record(int id, String name, String description, double price, long length, String fileType){
		super(id, name, description, price, new Date());
		this.length = length;
		this.fileType = fileType;
	}

	public Record(long length, String fileType) {
		this.length = length;
		this.fileType = fileType;
	}
}
