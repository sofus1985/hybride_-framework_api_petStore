package test_user;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPointsProperties;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.api.User;
import utilities.GenerateFakerData;

public class testUserProperties {






        User userPayload;
        private static final Logger logger = LogManager.getLogger(test_user.testUser.class); // Initialize Logger


        @BeforeClass
        public void setupDate(){
            userPayload = new User();
            userPayload.setId(GenerateFakerData.generateIdNumber().hashCode());
            userPayload.setUsername(GenerateFakerData.generateUserName());
            userPayload.setFirstName(GenerateFakerData.generateFirstName());
            userPayload.setLastName(GenerateFakerData.generateLastName());
            userPayload.setEmail(GenerateFakerData.generateEmail());
            userPayload.setPassword(GenerateFakerData.generatePassword());
            userPayload.setPhone(GenerateFakerData.generateCellPhone());

//       // Initialize logger here Use Log4j 2 for Logging:
//       logger = LogManager.getLogger(this.getClass());
//
//       /*
//              // Initialize logger here Use SLF4J with Log4j
//        logger = LogManager.getLogger(this.getClass());
//        */



            logger.info("************* Setup Data Completed **********");
            logger.debug("Generated User Payload: " + userPayload.toString());

        }

        @Test(priority = 1)
        public void testCreateUser(){
            Response response =  UserEndPointsProperties.createUser(userPayload);
            response.then().log().all();
            Assert.assertEquals(response.getStatusCode(),200);

//        // logs
//
//        logger.info("************* create user **********");
//        logger.debug("debugging");

            logger.info("************* Create User Test Executed **********");
            logger.debug("Response Status Code: " + response.getStatusCode());
        }


        @Test(priority = 2)
        public void testGetUser(){

            Response response = UserEndPointsProperties.readUser(this.userPayload.getUsername());
            response.then().log().all();
            Assert.assertEquals(response.getStatusCode(), 200);

//        // logs
//
//        logger.info("************* get user **********");
//        logger.debug("debugging");

            logger.info("************* Get User Test Executed **********");
            logger.debug("Response Status Code: " + response.getStatusCode());

        }


        @Test(priority = 3)
        public void testUpDateUser(){

            // update dat using payload
            userPayload.setFirstName(GenerateFakerData.generateFirstName());
            userPayload.setLastName(GenerateFakerData.generateLastName());
            userPayload.setEmail(GenerateFakerData.generateEmail());

            Response response = UserEndPointsProperties.upDateUser(this.userPayload.getUsername(), userPayload);
            // response.then().log().all();
            Assert.assertEquals(response.getStatusCode(), 200);

            // check data after update

            Response responseAfterUpDate = UserEndPointsProperties.readUser(this.userPayload.getUsername());
            Assert.assertEquals(responseAfterUpDate.getStatusCode(), 200);


//        // logs
//
//        logger.info("************* up date  user **********");
//        logger.debug("debugging");


            logger.info("************* Update User Test Executed **********");
            logger.debug("Response Status Code: " + response.getStatusCode());
            logger.debug("Updated User Payload: " + userPayload.toString());
        }


        @Test(priority = 4)
        public void testDeleteUser(){
            Response response = UserEndPointsProperties.deleteUser(this.userPayload.getUsername());
            Assert.assertEquals(response.getStatusCode(), 200);


//        // logs
//
//        logger.info("************* delete  user **********");
//        logger.debug("debugging");

            logger.info("************* Delete User Test Executed **********");
            logger.debug("Response Status Code: " + response.getStatusCode());
        }
}
