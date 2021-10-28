package br.com.restapi.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponseApi implements Serializable {

	private static final long serialVersionUID = 3888409110486510582L;

	private Date timestmap;

	private String message;

	private String path;

	private String status;

	public ExceptionResponseApi(Date timestmap, String message, String details, String status) {
		super();
		this.timestmap = timestmap;
		this.message = message;
		this.path = details;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimestmap() {
		return timestmap;
	}

	public void setTimestmap(Date timestmap) {
		this.timestmap = timestmap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
