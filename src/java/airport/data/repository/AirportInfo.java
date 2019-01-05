package airport.data.repository;
import java.sql.*;
import java.util.ArrayList;
import model.Airport;
public class AirportInfo {
    //static Object latlng[][];
    
        final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final static String DB_URL = "jdbc:mysql://localhost:3306/atc";

        //  Database credentials
        final static String USER = "root";
        final static String PASS = "";
        
    
    public static ArrayList getAllAirports()throws Exception{
        
        return JsonParser.getAirports();
    }
    public static Airport getAirport(String iata)throws Exception{
        Airport airport=new Airport();
        ArrayList airports=JsonParser.getAirports();
        for(Object apt : airports){
            airport=(Airport)apt;
            if(airport.getIata().equalsIgnoreCase(iata))
                return airport;
        }
        return airport;
    }
}
