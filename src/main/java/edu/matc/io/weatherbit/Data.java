package edu.matc.io.weatherbit;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Data.
 */
@Generated("com.robohorse.robopojogenerator")
public class Data{

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("count")
	private int count;

    /**
     * Set data.
     *
     * @param data the data
     */
    public void setData(List<DataItem> data){
		this.data = data;
	}

    /**
     * Get data list.
     *
     * @return the list
     */
    public List<DataItem> getData(){
		return data;
	}

    /**
     * Set count.
     *
     * @param count the count
     */
    public void setCount(int count){
		this.count = count;
	}

    /**
     * Get count int.
     *
     * @return the int
     */
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