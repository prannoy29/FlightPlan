package demo.components.controller;


import demo.components.domain.Login;
import demo.components.repository.WeatherRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zemoso on 12/9/17.
 */

@RestController
public class UavController {

    private String accessToken;
    public String BaseUrl = "https://uavapi.z-apps.io/";
    public WeatherRepository repository = new WeatherRepository();

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
        System.out.println(login.getExpiresIn());
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
        System.out.println(array.length());
        return response;
    }

    @RequestMapping(value="/refresh",method = RequestMethod.GET)
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
        System.out.println(login.getExpiresIn());
        return response;
    }

    
}
