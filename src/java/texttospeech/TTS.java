package texttospeech;
import decisionmaker.DecisionMaker;
import decisionmaker.NoAirportSpecifiedException;
import marytts.signalproc.effects.JetPilotEffect;
import speechtotext.Response;
import speechtotext.STT;

public class TTS {
	static TextToSpeech tts;
    static{
        tts = new TextToSpeech();
		tts.setVoice("cmu-rms-hsmm");//MALE VOICE
		//tts.setVoice("cmu-slt-hsmm");//FEMALE VOICE
		//tts.setVoice("dfki-poppy-hsmm");//FEMALE VOICE
		
		JetPilotEffect jetPilotEffect = new JetPilotEffect(); //epic fun!!!
		jetPilotEffect.setParams("amount:10");
		tts.getMarytts().setAudioEffects(jetPilotEffect.getFullEffectAsString()); 
    }
    
    public void speak(String decision) {
		
                tts.speak(decision, 2.0f, false, true);
            
	}
	   
}
