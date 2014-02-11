package com.uportal.domain;

public class ValueTuple {
	public int value;
	public String label;
	public int foreign;
	
	public void setValue(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	
	public void setLabel(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
	
	public void setForeign(int foreign){
		this.foreign = foreign;
	}
	
	public int getForeign(){
		return foreign;
	}
	
	
}
