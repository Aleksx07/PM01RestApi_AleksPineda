package hn.uth.pm01restapi_alekspineda.Config;

public class ResApiMethods {

    //http://localhost/PM01/CreatePerson.php

    public static final String separador = "/";
    public static final String ipadress = "192.168.0.52";
    public static final String RestApi = "PM01";
    public static final String PostRouting = "CreatePerson.php";

    //Endpoint
    public static final String EndpointPost = "http://" + ipadress + separador + RestApi + separador + PostRouting;


}
