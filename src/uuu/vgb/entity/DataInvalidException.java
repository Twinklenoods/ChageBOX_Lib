package uuu.vgb.entity;

public class DataInvalidException extends RuntimeException{
	public DataInvalidException() {
		super();
	}
	public DataInvalidException(String msg) {
		super(msg);
	}
	public DataInvalidException(String msg ,Exception ex) {
		super(msg, ex);
	}
	
}
