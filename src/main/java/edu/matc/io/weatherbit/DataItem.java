package edu.matc.io.weatherbit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@JsonIgnoreProperties(value = { "snow" })
@Generated("com.robohorse.robopojogenerator")
public class DataItem{

	@JsonProperty("sunrise")
	private String sunrise;

	@JsonProperty("pod")
	private String pod;

	@JsonProperty("pres")
	private double pres;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("ob_time")
	private String obTime;

	@JsonProperty("wind_cdir")
	private String windCdir;

	@JsonProperty("lon")
	private double lon;

	@JsonProperty("clouds")
	private int clouds;

	@JsonProperty("wind_spd")
	private double windSpd;

	@JsonProperty("h_angle")
	private int hAngle;

	@JsonProperty("city_name")
	private String cityName;

	@JsonProperty("datetime")
	private String datetime;

	@JsonProperty("precip")
	private Object precip;

	@JsonProperty("weather")
	private Weather weather;

	@JsonProperty("station")
	private String station;

	@JsonProperty("elev_angle")
	private int elevAngle;

	@JsonProperty("lat")
	private double lat;

	@JsonProperty("vis")
	private int vis;

	@JsonProperty("uv")
	private int uv;

	@JsonProperty("temp")
	private double temp;

	@JsonProperty("dhi")
	private double dhi;

	@JsonProperty("app_temp")
	private double appTemp;

	@JsonProperty("dewpt")
	private double dewpt;

	@JsonProperty("wind_dir")
	private int windDir;

	@JsonProperty("country_code")
	private String countryCode;

	@JsonProperty("rh")
	private int rh;

	@JsonProperty("slp")
	private double slp;

	@JsonProperty("sunset")
	private String sunset;

	@JsonProperty("state_code")
	private String stateCode;

	@JsonProperty("wind_cdir_full")
	private String windCdirFull;

	@JsonProperty("ts")
	private int ts;

	public void setSunrise(String sunrise){
		this.sunrise = sunrise;
	}

	public String getSunrise(){
		return sunrise;
	}

	public void setPod(String pod){
		this.pod = pod;
	}

	public String getPod(){
		return pod;
	}

	public void setPres(double pres){
		this.pres = pres;
	}

	public double getPres(){
		return pres;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setObTime(String obTime){
		this.obTime = obTime;
	}

	public String getObTime(){
		return obTime;
	}

	public void setWindCdir(String windCdir){
		this.windCdir = windCdir;
	}

	public String getWindCdir(){
		return windCdir;
	}

	public void setLon(double lon){
		this.lon = lon;
	}

	public double getLon(){
		return lon;
	}

	public void setClouds(int clouds){
		this.clouds = clouds;
	}

	public int getClouds(){
		return clouds;
	}

	public void setWindSpd(double windSpd){
		this.windSpd = windSpd;
	}

	public double getWindSpd(){
		return windSpd;
	}

	public void setHAngle(int hAngle){
		this.hAngle = hAngle;
	}

	public int getHAngle(){
		return hAngle;
	}

	public void setCityName(String cityName){
		this.cityName = cityName;
	}

	public String getCityName(){
		return cityName;
	}

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setPrecip(Object precip){
		this.precip = precip;
	}

	public Object getPrecip(){
		return precip;
	}

	public void setWeather(Weather weather){
		this.weather = weather;
	}

	public Weather getWeather(){
		return weather;
	}

	public void setStation(String station){
		this.station = station;
	}

	public String getStation(){
		return station;
	}

	public void setElevAngle(int elevAngle){
		this.elevAngle = elevAngle;
	}

	public int getElevAngle(){
		return elevAngle;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	public void setVis(int vis){
		this.vis = vis;
	}

	public int getVis(){
		return vis;
	}

	public void setUv(int uv){
		this.uv = uv;
	}

	public int getUv(){
		return uv;
	}

	public void setTemp(double temp){
		this.temp = temp;
	}

	public double getTemp(){
		return temp;
	}

	public void setDhi(double dhi){
		this.dhi = dhi;
	}

	public double getDhi(){
		return dhi;
	}

	public void setAppTemp(double appTemp){
		this.appTemp = appTemp;
	}

	public double getAppTemp(){
		return appTemp;
	}

	public void setDewpt(double dewpt){
		this.dewpt = dewpt;
	}

	public double getDewpt(){
		return dewpt;
	}

	public void setWindDir(int windDir){
		this.windDir = windDir;
	}

	public int getWindDir(){
		return windDir;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setRh(int rh){
		this.rh = rh;
	}

	public int getRh(){
		return rh;
	}

	public void setSlp(double slp){
		this.slp = slp;
	}

	public double getSlp(){
		return slp;
	}

	public void setSunset(String sunset){
		this.sunset = sunset;
	}

	public String getSunset(){
		return sunset;
	}

	public void setStateCode(String stateCode){
		this.stateCode = stateCode;
	}

	public String getStateCode(){
		return stateCode;
	}

	public void setWindCdirFull(String windCdirFull){
		this.windCdirFull = windCdirFull;
	}

	public String getWindCdirFull(){
		return windCdirFull;
	}

	public void setTs(int ts){
		this.ts = ts;
	}

	public int getTs(){
		return ts;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"sunrise = '" + sunrise + '\'' + 
			",pod = '" + pod + '\'' + 
			",pres = '" + pres + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",ob_time = '" + obTime + '\'' + 
			",wind_cdir = '" + windCdir + '\'' + 
			",lon = '" + lon + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",wind_spd = '" + windSpd + '\'' + 
			",h_angle = '" + hAngle + '\'' + 
			",city_name = '" + cityName + '\'' + 
			",datetime = '" + datetime + '\'' + 
			",precip = '" + precip + '\'' + 
			",weather = '" + weather + '\'' + 
			",station = '" + station + '\'' + 
			",elev_angle = '" + elevAngle + '\'' + 
			",lat = '" + lat + '\'' + 
			",vis = '" + vis + '\'' + 
			",uv = '" + uv + '\'' + 
			",temp = '" + temp + '\'' + 
			",dhi = '" + dhi + '\'' + 
			",app_temp = '" + appTemp + '\'' + 
			",dewpt = '" + dewpt + '\'' + 
			",wind_dir = '" + windDir + '\'' + 
			",country_code = '" + countryCode + '\'' + 
			",rh = '" + rh + '\'' + 
			",slp = '" + slp + '\'' + 
			",sunset = '" + sunset + '\'' + 
			",state_code = '" + stateCode + '\'' + 
			",wind_cdir_full = '" + windCdirFull + '\'' + 
			",ts = '" + ts + '\'' + 
			"}";
		}
}