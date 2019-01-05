<%-- 
    Document   : send
    Created on : Mar 21, 2018, 2:57:39 PM
    Author     : Kali
--%>

<%@page import="test.application.Main"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%
String flightnumber=null;
String iata=null;
flightnumber=request.getParameter("flightnumber");
iata=request.getParameter("iata");
if(flightnumber!=null&&iata!=null){
    String flight="";
    int flag=0;
    for(char c : flightnumber.toCharArray()){
        if(flag==0){
            flight=flight+c;
            flag=1;
        }else
        flight=flight+"-"+c;
    }
    
    new Main(iata, flight);
    
    out.println(iata+" "+flight);
    
    
    
}

%>