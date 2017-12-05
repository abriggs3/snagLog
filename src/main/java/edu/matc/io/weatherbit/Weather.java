package edu.matc.io.weatherbit;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Weather{

	@JsonProperty("code")
	private String code;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("description")
	private String description;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"Weather{" + 
			"code = '" + code + '\'' + 
			",icon = '" + icon + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}