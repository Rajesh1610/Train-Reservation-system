package com.demo.train.reservation.model;

public class Train {
	
	private int trainNo;
	private boolean ac;
	private int capacity;
	
	
	public Train(int trainNo, boolean ac, int capacity) {
		super();
		this.trainNo = trainNo;
		this.ac = ac;
		this.capacity = capacity;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Train [trainNo=" + trainNo + ", ac=" + ac + ", capacity=" + capacity + "]";
	}
	
	
	

}
