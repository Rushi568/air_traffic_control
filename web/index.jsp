<%-- 
    Document   : index.jsp
    Created on : Mar 16, 2018, 6:02:05 PM
    Author     : Kali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <script>
            setInterval(function () {
                $(document).ready(function () {

                    var d = new Date();
                    var time = d.toUTCString();
                    $("#utc").text(time);
                });
            }, 999);
        </script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/suggestion-box.css"/>
        <style>
            * {
                box-sizing: border-box;
            }

            body {
                margin: 0;
                font-family: Arial;
                font-size: 17px;
            }

            #myVideo {
                position: fixed;
                right: 0;
                bottom: 0;
                min-width: 100%; 
                min-height: 100%;
            }

            .content {
                position: fixed;
                top: 0;
                background: rgba(0, 0, 0, 0.5);
                color: #f1f1f1;
                width: 100%;
                padding: 20px;
                //padding-left: 400px;
            }

            #myBtn {
                width: 200px;
                font-size: 18px;
                padding: 10px;
                border: none;
                background: #000;
                color: #fff;
                cursor: pointer;
            }

            #myBtn:hover {
                background: #ddd;
                color: black;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
                <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/weather-icons/2.0.9/css/weather-icons.css"/>

        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="js/suggestion-box.js"></script>
        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 91%;
                opacity: 1;
                background-color:black; 
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
                opacity: 1;
                background-color: black;
            }
            body {
                font-family: "Lato", sans-serif;
            }

            .sidenav {
                height: 100%;
                width: 200px;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
                background-color: #111;
                overflow-x: hidden;
                padding-top: 20px;
                margin-top: 56px;
            }

            .sidenav a {
                padding: 6px 8px 6px 16px;
                text-decoration: none;
                font-size: 25px;
                color: #818181;
                display: block;
            }

            .sidenav a:hover {
                color: #f1f1f1;
            }

            .main {
                margin-left: 200px; /* Same as the width of the sidenav */
                font-size: 28px; /* Increased text to enable scrolling */
                padding: 0px 0px;
            }

            @media screen and (max-height: 450px) {
                .sidenav {padding-top: 15px;}
                .sidenav a {font-size: 18px;}
            }
            span{
                font-size: 10px;
                font-weight: bold;
                color: lightpink;
                text-align: right;
            }
            img{
                height: 30px;
                width: auto;
            };
            h4{

            }
        </style>
    </head>
    <body>

        <video autoplay muted loop id="myVideo">
            <source src="video/background1.mp4" type="video/mp4">
            Your browser does not support HTML5 video.
        </video>

        <div class="fluid">
            <!-- NAVBAR STARTS HERE  -->
            <nav class="navbar navbar-inverse" style="z-index: 999;">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#"></a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <li ></li>
                    </ul>
                </div>
            </nav>

            <script>
                $(document).ready(function () {
        //***************************************
        //CHANGE THIS BASE URL IF NEEDED        *
        var base_url="";//        *
        //***************************************
        
        $('#search').suggestionBox({
                        filter: true,
                        widthAdjustment: -8,
                        leftOffset: 4,
                        topOffset: 0
                    }).loadSuggestions('json/suggestion'+base_url+'.json');
                });
            </script>

            <div class="content">
                <form>

                    <div class="form-group" >
                        <div class="container">
                            <div class="row">

                                <h4 style="text-align: left;">Select Airport To Control</h4>


                                <div class="col-lg-5 col-lg-offset-3">
                                    <div class="form-group">

                                        <input type="text" id="search" class="form-control">
                                    </div>
                                </div>

                                <h4  id="utc" style="color:whitesmoke;text-transform: capitalize; text-align: right;"></h4>

                            </div>


                        </div>
                    </div>
                </form>


            </div>
        </div>

    </body>
</html>
