package edu.matc.io.weatherbit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Data item.
 */
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

    /**
     * Set sunrise.
     *
     * @param sunrise the sunrise
     */
    public void setSunrise(String sunrise){
		this.sunrise = sunrise;
	}

    /**
     * Get sunrise string.
     *
     * @return the string
     */
    public String getSunrise(){
		return sunrise;
	}

    /**
     * Set pod.
     *
     * @param pod the pod
     */
    public void setPod(String pod){
		this.pod = pod;
	}

    /**
     * Get pod string.
     *
     * @return the string
     */
    public String getPod(){
		return pod;
	}

    /**
     * Set pres.
     *
     * @param pres the pres
     */
    public void setPres(double pres){
		this.pres = pres;
	}

    /**
     * Get pres double.
     *
     * @return the double
     */
    public double getPres(){
		return pres;
	}

    /**
     * Set timezone.
     *
     * @param timezone the timezone
     */
    public void setTimezone(String timezone){
		this.timezone = timezone;
	}

    /**
     * Get timezone string.
     *
     * @return the string
     */
    public String getTimezone(){
		return timezone;
	}

    /**
     * Set ob time.
     *
     * @param obTime the ob time
     */
    public void setObTime(String obTime){
		this.obTime = obTime;
	}

    /**
     * Get ob time string.
     *
     * @return the string
     */
    public String getObTime(){
		return obTime;
	}

    /**
     * Set wind cdir.
     *
     * @param windCdir the wind cdir
     */
    public void setWindCdir(String windCdir){
		this.windCdir = windCdir;
	}

    /**
     * Get wind cdir string.
     *
     * @return the string
     */
    public String getWindCdir(){
		return windCdir;
	}

    /**
     * Set lon.
     *
     * @param lon the lon
     */
    public void setLon(double lon){
		this.lon = lon;
	}

    /**
     * Get lon double.
     *
     * @return the double
     */
    public double getLon(){
		return lon;
	}

    /**
     * Set clouds.
     *
     * @param clouds the clouds
     */
    public void setClouds(int clouds){
		this.clouds = clouds;
	}

    /**
     * Get clouds int.
     *
     * @return the int
     */
    public int getClouds(){
		return clouds;
	}

    /**
     * Set wind spd.
     *
     * @param windSpd the wind spd
     */
    public void setWindSpd(double windSpd){
		this.windSpd = windSpd;
	}

    /**
     * Get wind spd double.
     *
     * @return the double
     */
    public double getWindSpd(){
		return windSpd;
	}

    /**
     * Set h angle.
     *
     * @param hAngle the h angle
     */
    public void setHAngle(int hAngle){
		this.hAngle = hAngle;
	}

    /**
     * Get h angle int.
     *
     * @return the int
     */
    public int getHAngle(){
		return hAngle;
	}

    /**
     * Set city name.
     *
     * @param cityName the city name
     */
    public void setCityName(String cityName){
		this.cityName = cityName;
	}

    /**
     * Get city name string.
     *
     * @return the string
     */
    public String getCityName(){
		return cityName;
	}

    /**
     * Set datetime.
     *
     * @param datetime the datetime
     */
    public void setDatetime(String datetime){
		this.datetime = datetime;
	}

    /**
     * Get datetime string.
     *
     * @return the string
     */
    public String getDatetime(){
		return datetime;
	}

    /**
     * Set precip.
     *
     * @param precip the precip
     */
    public void setPrecip(Object precip){
		this.precip = precip;
	}

    /**
     * Get precip object.
     *
     * @return the object
     */
    public Object getPrecip(){
		return precip;
	}

    /**
     * Set weather.
     *
     * @param weather the weather
     */
    public void setWeather(Weather weather){
		this.weather = weather;
	}

    /**
     * Get weather weather.
     *
     * @return the weather
     */
    public Weather getWeather(){
		return weather;
	}

    /**
     * Set station.
     *
     * @param station the station
     */
    public void setStation(String station){
		this.station = station;
	}

    /**
     * Get station string.
     *
     * @return the string
     */
    public String getStation(){
		return station;
	}

    /**
     * Set elev angle.
     *
     * @param elevAngle the elev angle
     */
    public void setElevAngle(int elevAngle){
		this.elevAngle = elevAngle;
	}

    /**
     * Get elev angle int.
     *
     * @return the int
     */
    public int getElevAngle(){
		return elevAngle;
	}

    /**
     * Set lat.
     *
     * @param lat the lat
     */
    public void setLat(double lat){
		this.lat = lat;
	}

    /**
     * Get lat double.
     *
     * @return the double
     */
    public double getLat(){
		return lat;
	}

    /**
     * Set vis.
     *
     * @param vis the vis
     */
    public void setVis(int vis){
		this.vis = vis;
	}

    /**
     * Get vis int.
     *
     * @return the int
     */
    public int getVis(){
		return vis;
	}

    /**
     * Set uv.
     *
     * @param uv the uv
     */
    public void setUv(int uv){
		this.uv = uv;
	}

    /**
     * Get uv int.
     *
     * @return the int
     */
    public int getUv(){
		return uv;
	}

    /**
     * Set temp.
     *
     * @param temp the temp
     */
    public void setTemp(double temp){
		this.temp = temp;
	}

    /**
     * Get temp double.
     *
     * @return the double
     */
    public double getTemp(){
		return temp;
	}

    /**
     * Set dhi.
     *
     * @param dhi the dhi
     */
    public void setDhi(double dhi){
		this.dhi = dhi;
	}

    /**
     * Get dhi double.
     *
     * @return the double
     */
    public double getDhi(){
		return dhi;
	}

    /**
     * Set app temp.
     *
     * @param appTemp the app temp
     */
    public void setAppTemp(double appTemp){
		this.appTemp = appTemp;
	}

    /**
     * Get app temp double.
     *
     * @return the double
     */
    public double getAppTemp(){
		return appTemp;
	}

    /**
     * Set dewpt.
     *
     * @param dewpt the dewpt
     */
    public void setDewpt(double dewpt){
		this.dewpt = dewpt;
	}

    /**
     * Get dewpt double.
     *
     * @return the double
     */
    public double getDewpt(){
		return dewpt;
	}

    /**
     * Set wind dir.
     *
     * @param windDir the wind dir
     */
    public void setWindDir(int windDir){
		this.windDir = windDir;
	}

    /**
     * Get wind dir int.
     *
     * @return the int
     */
    public int getWindDir(){
		return windDir;
	}

    /**
     * Set country code.
     *
     * @param countryCode the country code
     */
    public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

    /**
     * Get country code string.
     *
     * @return the string
     */
    public String getCountryCode(){
		return countryCode;
	}

    /**
     * Set rh.
     *
     * @param rh the rh
     */
    public void setRh(int rh){
		this.rh = rh;
	}

    /**
     * Get rh int.
     *
     * @return the int
     */
    public int getRh(){
		return rh;
	}

    /**
     * Set slp.
     *
     * @param slp the slp
     */
    public void setSlp(double slp){
		this.slp = slp;
	}

    /**
     * Get slp double.
     *
     * @return the double
     */
    public double getSlp(){
		return slp;
	}

    /**
     * Set sunset.
     *
     * @param sunset the sunset
     */
    public void setSunset(String sunset){
		this.sunset = sunset;
	}

    /**
     * Get sunset string.
     *
     * @return the string
     */
    public String getSunset(){
		return sunset;
	}

    /**
     * Set state code.
     *
     * @param stateCode the state code
     */
    public void setStateCode(String stateCode){
		this.stateCode = stateCode;
	}

    /**
     * Get state code string.
     *
     * @return the string
     */
    public String getStateCode(){
		return stateCode;
	}

    /**
     * Set wind cdir full.
     *
     * @param windCdirFull the wind cdir full
     */
    public void setWindCdirFull(String windCdirFull){
		this.windCdirFull = windCdirFull;
	}

    /**
     * Get wind cdir full string.
     *
     * @return the string
     */
    public String getWindCdirFull(){
		return windCdirFull;
	}

    /**
     * Set ts.
     *
     * @param ts the ts
     */
    public void setTs(int ts){
		this.ts = ts;
	}

    /**
     * Get ts int.
     *
     * @return the int
     */
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