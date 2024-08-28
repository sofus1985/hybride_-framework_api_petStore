package test;

import api.endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.api.User;


public class TestUserDataDriven {

    User userPayload;



    @Test(priority = 1, dataProviderClass = data_provider.APIDataProvider.class, dataProvider = "Sheet1")
    public void testUserDataDriven(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph){




        userPayload.setId((int) Double.parseDouble(userID)); // Convert the userID to an integer
        userPayload.setUsername(userName);
        userPayload.setFirstName(fname);
        userPayload.setLastName(lname);
        userPayload.setEmail(useremail);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);

        Response response= UserEndPoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(),200);



    }

    @Test(priority=2, dataProviderClass = data_provider.APIDataProvider.class, dataProvider = "UserNames")
    public void testDeleteUserByName(String userName)
    {
        Response response=UserEndPoints.deleteUser(userName);
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
