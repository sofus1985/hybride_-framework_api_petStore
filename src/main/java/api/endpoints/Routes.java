package api.endpoints;

public class Routes {
    /*
    swagger url --> https://petstore.swagger.io

    create use (post) : https://petstore.swagger.io/v2/user
    get user (get) : https://petstore.swagger.io/v2/user/{username}
    up date user (put): https://petstore.swagger.io/v2/user/{username}
    delete user (delete): https://petstore.swagger.io/v2/user/{username}
     */


    public static  String Base_url = "https://petstore.swagger.io";


    //user module
    public static String post_url = "https://petstore.swagger.io/v2/user";
    public static String get_url = "https://petstore.swagger.io/v2/user/{username}";
    public static String put_url = "https://petstore.swagger.io/v2/user/{username}";
    public static String delete_url = "https://petstore.swagger.io/v2/user/{username}";
}
