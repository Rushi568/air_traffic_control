package decisionmaker;

/*
 Alfa, Bravo, Charlie, Delta, Echo, Foxtrot, Golf, Hotel, India, Juliett, Kilo, Lima, Mike, November, Oscar, Papa, Quebec, Romeo, Sierra, Tango, Uniform, Victor, Whiskey, X-ray, Yankee, Zulu

 */
import airport.data.repository.AirportInfo;
import com.darkprograms.speech.recognizer.GoogleResponse;
import command.processor.CommandProcessor;
import flightdata.controller.FlightInfo;
import java.util.ArrayList;

import model.Flight;

import model.weather.*;
import runwaydata.controller.RunwayInfo;
import speechtotext.Response;
import speechtotext.STT;
import texttospeech.TTS;
import weatherinfo.controller.WeatherInfo;

public class DecisionMaker {

    static TTS tts = new TTS();
    private String finaldecision;
    private String iata = null;
    private String flightnumber = null;
    private String modifiedflightnumber = null;
    Weather weather;
    Sky sky;
    Visibility visibility;
    Condition condition;
    String aptname;

    public DecisionMaker() throws NoAirportSpecifiedException, Exception {
        throw new NoAirportSpecifiedException();
    }

    public DecisionMaker(String iata) throws NullPointerException, Exception {
        if (iata == null) {
            throw new NullPointerException("\nThe IATA is null");
        }
        this.iata = iata;
        aptname = AirportInfo.getAirport(iata).getName();
        flightnumber = null;
        try {
            weather = WeatherInfo.getWeather(iata);
            sky = weather.getSky();
            visibility = sky.getVisibiity();
            condition = sky.getCondition();
        } catch (Exception ex) {
            visibility = null;
            condition = null;
            ex.printStackTrace();
        }

    }

    public DecisionMaker(String iata, String fno) throws NullPointerException, Exception {
        if (iata == null) {
            throw new NullPointerException("\nThe IATA is null");
        }
        aptname = AirportInfo.getAirport(iata).getName();
        this.flightnumber = fno;
        this.iata = iata;
        try {
            weather = WeatherInfo.getWeather(iata);
            sky = weather.getSky();
            visibility = sky.getVisibiity();
            condition = sky.getCondition();
        } catch (Exception ex) {
            visibility = null;
            condition = null;
            ex.printStackTrace();
        }

    }

    private void append(String command) {
        System.out.println(command);
        tts.speak(command);

    }

    public void make(String command) throws Exception {

        if (CommandProcessor.contains(command, "flight-number/flight/flight-num/flight-no/number/flightnumber")) {
            if (flightnumber == null) {
                this.flightnumber = CommandProcessor.getFlightNumber(command);
            }
            modifiedflightnumber = CommandProcessor.modifyFlightNumber(flightnumber);

            //***********************************************//
            //*************REQUEST FOR LANDING***************//
            //***********************************************//
            if (CommandProcessor.contains(command, "landing/land/lend/descending/descend")) {
                this.processLanding();
            } //***********************************************//
            //*************REQUEST FOR TAKEOFF***************//
            //***********************************************//
            else if (CommandProcessor.contains(command, "takeoff/take off/takeof/take of/ascending/ascend")) {
                this.processTakeoff();
            } //***********************************************//
            //*************REQUEST FOR TAXI******************//
            //***********************************************//
            else if (CommandProcessor.contains(command, "taxi/taxing/taxy/texi/texy/taxiying")) {
                this.processTaxi();
            } else if (CommandProcessor.contains(command, "ILS/ils/instrument-landing-system/ground/cround-control/cround/ground control")) {
                append("flight " + modifiedflightnumber + " you have been placed on I-L-R");
                this.processGroundControl();
            } else if (CommandProcessor.contains(command, "")) {
               
            } else {
                this.processCritical();
            }
        } else {
            new TTS().speak("Please repeat the command in proper syntax");
            Thread.sleep(2000);
            STT.startRecordingFor(15000);
            Response response = STT.extractResponse();
            String responsestring = response.getResponse();
            if (responsestring == null) {
                for (String s : response.getOtherPossibleResponses()) {
                    if (s != null) {
                        responsestring = s;
                    }
                }
            }
            System.out.println(responsestring);

            make(responsestring);
        }

    }

    ///*************************************************************************************************************//
    //***********************************FUNCTION SPECIFIC PRIVATE METHODS******************************************//
    //**************************************************************************************************************//
    private void processTakeoff() throws Exception {

        ArrayList flights = FlightInfo.getFlightsTakingoffOrLandingOnAirport(iata);

        System.out.println(flights.size());
        System.out.println("Condition : " + condition.getText());
        System.out.println("Visibility : " + visibility.getMi());
        System.out.println("Visibility : " + visibility.getKm());
        System.out.println("Visibility : " + visibility.getNmi());

        if (flights.size() > 1) {           //Airport has more than one flights ready for takeoff or landing
            if (this.hasEmptyRunway()) {    //If airport has an empty runway then clear for takeoff
                this.clearForTakeoff();
            } else {
                this.holdShortFor(10);      //else hold short flight for standard time i.e. 10 Minutes
            }
        } else if (flights.size() == 1) {       //Only one flight to takeoff or land
            flights.stream().forEach((flight) -> {
                Flight f = (Flight) flight;
                if (flightnumber.equalsIgnoreCase(f.getFlightnumber())) {   //check weather that flight is only that flight which is demanding clearence
                    this.clearForTakeoff();         //if yes then give clearence
                } else {
                    this.holdShortFor(10);          //else hold short flight for standard time i.e. 10 Minutes
                }
            });
        } else {                                        //If there are no flights on airport
            this.clearForTakeoff();                     //give clearence to that flight directly
        }

        if (visibility.getMi() == null) {

            append("Visibility not available");
            append("Switch to I-F-R");
            //System.out.println("In IF");

        } else if (Integer.parseInt(visibility.getMi()) >= 190) {
            System.out.println("In ELSE IF");
            append("Visibility is " + visibility.getMi());
        } else {
            System.out.println("In ELSE");
            append(" visibility is low");
            append("switch to V-F-R");
        }
        append("weather on airport is " + condition.getText());

    }

    private void processLanding() throws Exception {
        ArrayList flights = FlightInfo.getFlightsTakingoffOrLandingOnAirport(iata);

        System.out.println(flights.size());
        System.out.println("Condition : " + condition.getText());
        System.out.println("Visibility : " + visibility.getMi());
        System.out.println("Visibility : " + visibility.getKm());
        System.out.println("Visibility : " + visibility.getNmi());

        if (flights.size() > 1) {           //Airport has more than one flights ready for takeoff or landing
            if (this.hasEmptyRunway()) {    //If airport has an empty runway then clear for takeoff
                this.clearForLanding();
            } else {
                this.holdShortFor(10);      //else hold short flight for standard time i.e. 10 Minutes
            }
        } else if (flights.size() == 1) {       //Only one flight to takeoff or land
            flights.stream().forEach((flight) -> {
                Flight f = (Flight) flight;
                if (flightnumber.equalsIgnoreCase(f.getFlightnumber())) {   //check weather that flight is only that flight which is demanding clearence
                    this.clearForLanding();//if yes then give clearence
                } else {
                    this.holdShortFor(10);          //else hold short flight for standard time i.e. 10 Minutes
                }
            });
        } else {                                        //If there are no flights on airport
            this.clearForLanding();//give clearence to that flight directly
        }

        if (visibility.getMi() == null) {

            append("Visibility not available");
            append("Switch to I-F-R");
            //System.out.println("In IF");

        } else if (Integer.parseInt(visibility.getMi()) >= 190) {
            System.out.println("In ELSE IF");
            append("Visibility is " + visibility.getMi());
        } else {
            System.out.println("In ELSE");
            append(" visibility is low");
            append("switch to V-F-R");
        }
        append("weather on airport is " + condition.getText());
        append("temperature is " + weather.getTemperature().getCelcius() + " Celcius");
    }

    private void processTaxi() throws Exception {

        if (hasEmptyRunway()) {
            append("Flight " + modifiedflightnumber + " ,you may proceed for taxi on runway " + getEmptyRunway());

        } else {

            append("flight " + modifiedflightnumber);
            holdShortFor(10);
        }
    }

    private void processGroundControl() throws Exception {
        append("Flight " + modifiedflightnumber + ", you have been placed on I-L-S");
        Thread.sleep(8000);
        continueTaxi();
        Thread.sleep(9000);
        exitRunway();
        Thread.sleep(10000);
        crossRunway(3);
        Thread.sleep(15000);
        greetFlight();
        Thread.sleep(12000);
        standBy(RunwayInfo.getEmptyAerobridge());

    }

    private void greetFlight() throws Exception {

        append("Welcome to " + aptname);
        Thread.sleep(5000);
        append("weather on " + aptname + " is " + condition.getText());
        Thread.sleep(9000);
        append("temperature is " + weather.getTemperature().getCelcius() + " degree Celcius");
    }

    private void checkFlightIntention() throws Exception {
        append("Flight " + modifiedflightnumber + ", please mention your intention");
    }

    private void holdShortFor(int minutes) {
        append("Flight " + modifiedflightnumber + ", please hold short for " + minutes + " minutes");
    }

    private void processCritical() throws Exception {
        append("Flight" + modifiedflightnumber + ", control is passing to human");
        passControlToHuman();
    }

    private void passControlToHuman() {
        append("Control passed to human");
    }

    private void continueTaxiOn(int runwaynumber) throws Exception {

        append("Flight " + modifiedflightnumber + ", continue taxi and proceed on runway  " + runwaynumber);

    }

    private void continueTaxi() throws Exception {
        append("Flight " + modifiedflightnumber + ", continue taxi and proceed further");
    }

    private void crossRunway(int runwaynumber) throws Exception {
        append("Flight " + modifiedflightnumber + ", cross runway " + runwaynumber + " and continue taxi and proceed further");
    }

    private void giveWayToFlight() throws Exception {

        append("Flight " + modifiedflightnumber + ", give way to the other flight and hold short for 5 minutes");

    }

    private void holdPosition() throws Exception {
        append("Flight " + modifiedflightnumber + ", hold your position");
    }

    private void pushbackApproved() throws Exception {
        append("Flight " + modifiedflightnumber + ", your pushback has been approved, push back car will soon take you to the runway");
    }

    private void contactOtherFrequency() throws Exception {
        append("Flight " + modifiedflightnumber + ", please contact another frequency you are not in range of our area");

    }

    private void standBy(int aeroBridge) throws Exception {
        append("Flight " + modifiedflightnumber + ", please stand by aero bridge number " + aeroBridge);

    }

    private void clearForTakeoff() {
        append("Flight, " + modifiedflightnumber + ", you can takeoff from runway " + getEmptyRunway());
    }

    private void clearForLanding() {
        append("Flight, " + modifiedflightnumber + ", you can land on runway " + getEmptyRunway());
    }

    private void cancelTakeoffClearence() throws Exception {
        holdPosition();
        append(" your takeoff clearence has been cancelled due to some reasons");
        holdShortFor(5);
        append(" and the contact a-t-c");

    }

    private void lineUpAndWait() throws Exception {

        holdShortFor(4);
        append(" you have been placed on hold");
    }

    private void backTaxi() throws Exception {

        append("Flight " + modifiedflightnumber + " please taxi back to your position as soon as possible");
    }

    private void exitRunway() throws Exception {

        append("Flight " + modifiedflightnumber + ", please exit runway");
        standBy(RunwayInfo.getEmptyAerobridge());

    }

    private void denyEntry() throws Exception {
        append("Flight " + modifiedflightnumber + ", you are not allowed to land on this airport");

    }

    private void resendLastMessage() throws Exception {
        append("Flight " + modifiedflightnumber + ", please resend last message in proper format");

    }

    private void goAroundFor(String minutes) throws Exception {
        append("Flight " + modifiedflightnumber + ", go around for " + minutes + " minutes, the runway is busy");
    }

    private void request360() throws Exception {
        append("Flight " + modifiedflightnumber + " ,you are requested to do a 3-60, the runway is busy");
    }

    private int getEmptyRunway() {
        return RunwayInfo.getAnyEmptyRunway(iata);
    }

    private boolean hasEmptyRunway() {

        return RunwayInfo.hasAnyEmptyRunway(iata);
    }

}
