/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.application;

import command.processor.CommandProcessor;
import decisionmaker.DecisionMaker;
import decisionmaker.NoAirportSpecifiedException;
import model.schedule.Schedule;
import schedule.controller.ScheduleInfo;
import speechtotext.Response;
import speechtotext.STT;
import texttospeech.TTS;

/**
 *
 * @author Kali
 */
public class Main {

    static TTS tts = new TTS();

    public Main(String iata, String flightnumber)throws Exception {
        tts.speak("Flight "+flightnumber+", present your request");
        STT.startRecordingFor(15000);
            Response response = STT.extractResponse();
            System.out.println("Confidence : " + response.getConfidence());
            String responsestring = response.getResponse();
            if (responsestring == null) {
                for (String s : response.getOtherPossibleResponses()) {
                    if (s != null) {
                        responsestring = s;
                    }
                }
            }
         System.out.println(responsestring);
       tts.speak("Flight, "+flightnumber+" ,wait for reply");
        DecisionMaker decision = new DecisionMaker(iata,flightnumber);
        //decision.make("hello atc delhi this is flight-number "+flightnumber+" requesting for ground control");
        
         decision.make(responsestring);
    }

    public static void main(String[] args) {
        try {
            DecisionMaker decision = new DecisionMaker("DEL");
//************************************************************************************************************//
//*******************************CODE TO CALL SPEECH TO TEXT MODULE*******************************************//
//************************************************************************************************************//

            STT.startRecordingFor(15000);
            Response response = STT.extractResponse();
            System.out.println("Confidence : " + response.getConfidence());
            String responsestring = response.getResponse();
            if (responsestring == null) {
                for (String s : response.getOtherPossibleResponses()) {
                    if (s != null) {
                        responsestring = s;
                    }
                }
            }
          decision.make(responsestring);
//************************************************************************************************************//
//**********************CODE TO CALL DECISION MAKER MODULE****************************************************//
//************************************************************************************************************//
            decision.make("hello atc delhi this is flight-number 9W 237 requesting for ground control");

//            
//************************************************************************************************************//
//**********************CODE TO CALL TEXT TO SPEECH MODULE****************************************************//
//************************************************************************************************************//
            //Thread.sleep(1000);
            //dec=decision.make("Hello ATC this is flightnumber 9W-2000 requesting for takeoff");
            //System.out.println(dec);
            //speak(dec);
            //Schedule schedule=ScheduleInfo.getSchedule("DEL");
            //System.out.println(schedule);
//************************************************************************************************************//
//********************************BASIC EXCEPTION HANDLING****************************************************//
//************************************************************************************************************//
//            Schedule s = ScheduleInfo.getSchedule("DEL");
//            System.out.println(s);
        } catch (NoAirportSpecifiedException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
