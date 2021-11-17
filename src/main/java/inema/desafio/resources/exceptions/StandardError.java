package inema.desafio.resources.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private String msg;
	private Long timeStamp;
	private List<String> detalhe = new ArrayList<>();

	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	public StandardError(Integer status, String msg, Long timeStamp, String detalhe) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
		this.detalhe.add(detalhe);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public List<String> getDetalhe() {
		return detalhe;
	}

	public void addDetalhe(String detalhe) {
		this.detalhe.add(detalhe);
	}
	
	public void setDetalhe(List<String> detalhe) {
		this.detalhe = detalhe;
	}
}
