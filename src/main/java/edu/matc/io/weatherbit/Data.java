package edu.matc.io.weatherbit;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("count")
	private int count;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"data = '" + data + '\'' + 
			",count = '" + count + '\'' + 
			"}";
		}
}