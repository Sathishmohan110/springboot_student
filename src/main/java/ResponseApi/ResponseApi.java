package ResponseApi;

import org.springframework.stereotype.Component;

@Component
public class ResponseApi {
	private Object status;
	public ResponseApi(Object status, Object data, Object error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}
	private Object data;
	private Object error;
	public ResponseApi() {}
	public Object getStatus() {
		return status;
	}
	public void setStatus(Object status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	

}
