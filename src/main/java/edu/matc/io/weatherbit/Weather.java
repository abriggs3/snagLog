package edu.matc.io.weatherbit;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Weather.
 */
@Generated("com.robohorse.robopojogenerator")
public class Weather{

	@JsonProperty("code")
	private String code;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("description")
	private String description;

    /**
     * Set code.
     *
     * @param code the code
     */
    public void setCode(String code){
		this.code = code;
	}

    /**
     * Get code string.
     *
     * @return the string
     */
    public String getCode(){
		return code;
	}

    /**
     * Set icon.
     *
     * @param icon the icon
     */
    public void setIcon(String icon){
		this.icon = icon;
	}

    /**
     * Get icon string.
     *
     * @return the string
     */
    public String getIcon(){
		return icon;
	}

    /**
     * Set description.
     *
     * @param description the description
     */
    public void setDescription(String description){
		this.description = description;
	}

    /**
     * Get description string.
     *
     * @return the string
     */
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