package com.leslie.Taskmanager.ApiResponse;

import java.util.List;

public class SearchResponse<T> {

	private Long total;
	private List<T> data;
	private String message;
	
	
	public SearchResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchResponse(Long total, List<T> data, String message) {
		super();
		this.total = total;
		this.data = data;
		this.message = message;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
