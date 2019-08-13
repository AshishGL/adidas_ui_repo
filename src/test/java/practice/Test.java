package practice;
import org.springframework.util.LinkedMultiValueMap;

import org.springframework.util.MultiValueMap;
import restutils.rest.client.RestClient;

public class Test {
	public static void main(String[] args) {

	RestClient restClient = RestClient.getInstance();
//1 PASS
	System.out.println(restClient.doGet("https://www.google.com/"));

	
		MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();
		
		
//2 PASS
		queryParam.add("opportunityId", "1-51OA214");
		
System.out.println(restClient.doGet("https://sharepv.gartner.com/alfresco/service/clientConnect/opportunity-attachments/count", queryParam));

//3	PASS		
		System.out.println(restClient.doGet("https://sharepv.gartner.com/alfresco/service/clientConnect/opportunity-attachments/count", queryParam, null));

}
	}