import com.oracle.javafx.jmx.json.JSONException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FirstTest {

    @Test
    public void httpPostMethod() throws JSONException {

        //Base URL
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        //endpoints related to employees

        String createURL = "/create";

        String deleteUrl = "/delete/{id}";

        String getAllEmployeesUrl = "/employees";

        //API Body
        String apiBody = "{\"name\":\"Raghu233120\",\"salary\":\"600000\",\"age\":\"28\"}";

        given().log().all().header("Content-Type", "application/json").body(apiBody)
                .when().post(createURL)
                        .then().log().all().assertThat().statusCode(200);*/


       String response = "{\n" +
               "    \"status\": \"success\",\n" +
               "    \"data\": {\n" +
               "        \"name\": \"Raghu233120\",\n" +
               "        \"salary\": \"600000\",\n" +
               "        \"age\": \"28\",\n" +
               "        \"id\": 64\n" +
               "    }\n" +
               "}";

        JsonPath js = new JsonPath(response);
        int outputIdFromJSPath = js.getInt("data.id");
        String nameFromResponse = js.getString("data.name");
        System.out.println("Output for name is -> "+nameFromResponse);
        System.out.println("Output for id is -> "+ outputIdFromJSPath);*/


        /* Learning of JSON Array*/

        JsonPath js2 = new JsonPath(Payload.getCourseJson());
        int amount = js2.getInt("dashboard.purchaseAmount");
        int lengthOfArray = js2.getInt("courses.size()");
       // System.out.println(length);

        String [] top = {"Mann","Pooja","Avi","Minal"};

        for (int i =0;i<top.length;i++){
            System.out.println(top[i]);
        }

        for (int j=0;j< lengthOfArray;j++){
            System.out.println(js2.getString("courses["+j+"].title"));
        }



    }


}
