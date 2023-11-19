package hn.uth.pm01restapi_alekspineda.Config;

public class ResApiMethods {

    //http://localhost/PM01/CreatePerson.php

    public static final String separador = "/";
    public static final String ipadress = "192.168.0.69";
    public static final String RestApi = "PM01";
    public static final String PostRouting = "CreatePerson.php";

    public static final String GetRouting = "ListPerson.php";

    //Endpoint
    public static final String EndpointPost = "http://" + ipadress + separador + RestApi + separador + PostRouting;

    public static final String EndpointGet = "http://" + ipadress + separador + RestApi + separador + GetRouting;


}
