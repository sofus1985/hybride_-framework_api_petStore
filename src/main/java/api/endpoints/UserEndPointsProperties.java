package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.api.User;
import java.util.ResourceBundle;
import static io.restassured.RestAssured.given;

public class UserEndPointsProperties {

    public static  ResourceBundle getURL(){
        ResourceBundle routes = ResourceBundle.getBundle("routes"); // load from properties file
        return routes;
    }


    public static Response createUser(User payload){

      String postUrl = getURL().getString("post_url");

        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(postUrl);

        return response;

    }
    public static Response readUser(String username){

        String getUrl = getURL().getString("get_url");

        Response response =  given()
                .pathParam("username", username)

                .when()
                .get(getUrl);

        return response;

    }


    public static Response upDateUser(String username, User payload){

        String upDateUrl = getURL().getString("update_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)

                .when()
                .put(upDateUrl);

        return response;



    }


    public static Response deleteUser(String username){

        String deleteUrl = getURL().getString("delete_url");

        Response response =  given()
                .pathParam("username", username)

                .when()
                .delete(deleteUrl);


        return response;

    }
}
