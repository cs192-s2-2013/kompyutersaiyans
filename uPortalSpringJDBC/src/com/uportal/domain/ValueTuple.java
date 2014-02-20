package com.uportal.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueTuple {
	public int value;
	public String label;
	public String telInfo;
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
	
	public void setTelInfo(String info){
		this.telInfo = info;
	}
	
	public String getTelInfo(){
		return telInfo;
	}
	
	public void setForeign(int foreign){
		this.foreign = foreign;
	}
	
	public int getForeign(){
		return foreign;
	}
	
	
}
