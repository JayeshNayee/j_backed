package com.srore.mainStore;

public class mainStore {
	
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public mainStore(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public mainStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "mainStore [id=" + id + ", name=" + name + "]";
	}
	

}
