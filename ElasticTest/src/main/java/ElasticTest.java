import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.json.JSONObject;


public class ElasticTest {


private final String elasticUri;
private final String index;
private final String elasticPort;

    public ElasticTest (String elasticUri,String elasticPort, String index){
        this.elasticUri=elasticUri;
        this.index=index;
        this.elasticPort=elasticPort;

    }

    public boolean checkField(String field){

        try {

            String testUri = elasticUri + ":" + elasticPort + "/" + index + "/_search?q=_exists_:" + field;
            System.out.println(testUri);
            GetRequest request = Unirest.get(testUri);
            HttpResponse<JsonNode> jsonRequest = request.asJson();
            JsonNode body = jsonRequest.getBody();
            JSONObject bodyObject = body.getObject();
            JSONObject hits = bodyObject.getJSONObject("hits");
            int totalHits = hits.getInt("total");
            return totalHits > 0;
        }catch (UnirestException e){
            System.out.println("unable to parse response as json");
            return false;
        }catch (NullPointerException e){
            System.out.println("field: "+field+"not found");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
