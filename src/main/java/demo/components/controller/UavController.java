package demo.components.controller;


import demo.components.domain.GeoPoint;
import demo.components.domain.Login;
import demo.components.domain.Weather;
import demo.components.repository.WeatherRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zemoso on 12/9/17.
 */

@RestController
public class UavController {

    private String accessToken;
    public String BaseUrl = "https://uavapi.z-apps.io/";
    public WeatherRepository repository = new WeatherRepository();
    private long expiresIn = Long.MAX_VALUE;

    @RequestMapping(value ="/profile" , method= RequestMethod.GET)
    public ResponseEntity getAuth(){
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("client_id","utm-telemetry");
        map.add("client_secret","utm-telemetry-secret");
        map.add("grant_type","password");
        map.add("username","pardhauas");
        map.add("password","Security123");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        String url = BaseUrl+"oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Login> response = restTemplate.postForEntity(url,request,Login.class);
        Login login = response.getBody();
        this.accessToken = login.getAccessToken();
        this.expiresIn = login.getExpiresIn();
        //System.out.println(login.getExpiresIn());
        return response;
    }

    @RequestMapping(value="/flightplans",method = RequestMethod.GET)
    public ResponseEntity getFlightPlans(){
        String url = BaseUrl+"flight_plans";
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization","Bearer "+accessToken);
        headers.add("Content-type","application/json");
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,request,String.class);
        System.out.println(response.getStatusCode());
        JSONObject obj = new JSONObject(response.getBody());
        //System.out.println(obj.toString());
        JSONArray array = obj.getJSONArray("objectsList");
        //System.out.println(array.length());
        return response;
    }

    @RequestMapping(value="/refresh",method = RequestMethod.GET)
    //@Scheduled(cron = expiresIn)
    public ResponseEntity refreshAuth(){
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        /*Map<String,String> map = new HashMap<String,String>();
        map.put("client_id","utm-telemetry");
        map.put("client_secret","utm-telemetry-secret");
        map.put("grant_type","refresh_token");
        map.put("refresh_token","b49cfb12-0706-4a3d-9734-3764c969315d");*/

        map.add("client_id","utm-telemetry");
        map.add("client_secret","utm-telemetry-secret");
        map.add("grant_type","refresh_token");
        map.add("refresh_token","b49cfb12-0706-4a3d-9734-3764c969315d");


        //HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map,headers);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = BaseUrl+"oauth/token";
        ResponseEntity<Login> response = restTemplate.postForEntity(url,request,Login.class);
        Login login = response.getBody();
        this.accessToken = login.getAccessToken();
        this.expiresIn = login.getExpiresIn();
        System.out.println(login.getExpiresIn());
        return response;
    }

    @RequestMapping(value = "/weather",method = RequestMethod.GET)
    public Weather getWeather(){
        return repository.getData("103_32W_48_36N_2017_07_16T09");
    }

    @RequestMapping(value = "/weather/id",method = RequestMethod.GET)
    public Weather getWeatherById(@RequestParam("lat") Double lati, @RequestParam("lon") Double longi,@RequestParam("date") String date)throws ParseException{
        GeoPoint geoPoint = repository.getPoint(lati,longi);
        Double lat = geoPoint.getLat();
        Double lon = geoPoint.getLon();
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder builder = new StringBuilder();
        String s = "";
        if(lon<0){
            lon = Math.abs(lon);
            s = df.format(lon);
            s = s.replace('.','_');
            builder.append(s);
            builder.append("W_");
        }else{
            s = df.format(lon);
            s = s.replace('.','_');
            builder.append(s);
            builder.append("E_");
        }

        if(lat<0){
            lat = Math.abs(lat);
            s = df.format(lat);
            s = s.replace('.','_');
            builder.append(s);
            builder.append("S_");
        }else {
            s = df.format(lat)  ;
            s = s.replace('.','_');
            builder.append(s);
            builder.append("N_");
        }

        builder.append(modifyDate(date));
        String id = builder.toString();
        //System.out.println(id);
        if(repository.getData(id).getId() == null){
            throw new NullPointerException("No weather data for the given date and time at the location");
        }
        else {
            return repository.getData(id);
        }
    }

    public String modifyDate(String s)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date datetime = sdf.parse(s);
        Calendar cal = Calendar.getInstance();
        cal.setTime(datetime);

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.MONTH,7);
        if(hour==23 || hour==0 || hour==1){
            cal.set(Calendar.HOUR_OF_DAY,0);
            if(hour==23){
                cal.set(Calendar.DAY_OF_MONTH,day+1);
            }
        }
        else if(hour==2 || hour==3 || hour==4){
            cal.set(Calendar.HOUR_OF_DAY,3);
        }else if(hour==5 || hour==6 || hour==7){
            cal.set(Calendar.HOUR_OF_DAY,6);
        }
        else if(hour==8 || hour==9 || hour==10){
            cal.set(Calendar.HOUR_OF_DAY,9);
        }
        else if(hour==11 || hour==12 || hour==13){
            cal.set(Calendar.HOUR_OF_DAY,12);
        }
        else if(hour==14 || hour==15 || hour==16){
            cal.set(Calendar.HOUR_OF_DAY,15);
        }
        else if(hour==17 || hour==18 || hour==19){
            cal.set(Calendar.HOUR_OF_DAY,18);
        }
        else if(hour==20 || hour==21 || hour==22){
            cal.set(Calendar.HOUR_OF_DAY,21);
        }
        String date = sdf.format(cal.getTime());
        date = date.substring(0,13);
        date = date.replace('-','_');
        return date;
    }

    @ExceptionHandler(ParseException.class)
    void handleParseException(HttpServletResponse response) throws Exception{
        response.sendError(HttpStatus.BAD_REQUEST.value(),"Please check the date format");
    }

    @ExceptionHandler(NullPointerException.class)
    void handleNullException(HttpServletResponse response)throws Exception {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}


