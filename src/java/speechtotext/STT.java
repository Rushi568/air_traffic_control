package speechtotext;
import java.io.File;
 import net.sourceforge.javaflacencoder.FLACFileWriter;
 import com.darkprograms.speech.microphone.Microphone;
 import com.darkprograms.speech.recognizer.Recognizer;
 import com.darkprograms.speech.recognizer.GoogleResponse;

 /**
   * Jarvis Speech API Tutorial
   * @author Aaron Gokaslan (Skylion)
   *
   */
   public class  STT{
static File file = new File("testfile2.flac");
static Microphone mic;


public static void startRecordingFor(long milliseconds) {
	
	//Name your file whatever you want
	try {
                mic = new Microphone(FLACFileWriter.FLAC);
		mic.captureAudioToFile(file);
	} catch (Exception ex) {//Microphone not available or some other error.
		System.out.println("ERROR: Microphone is not availible.\nTry connecting microphone");
		ex.printStackTrace();
		//TODO Add your error Handling Here
	}
	/* User records the voice here. Microphone starts a separate thread so do whatever you want
	 * in the mean time. Show a recording icon or whatever.
	 */
	try {
		System.out.println("Recording...");
		Thread.sleep(milliseconds);//In our case, we'll just wait 5 seconds.
                    mic.close();
	} catch (InterruptedException ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
	}
	
	mic.close();//Ends recording and frees the resources
	System.out.println("Recording stopped.");
	
}

         ///
        
        
public static Response extractResponse(){
        Response resp=null;
	Recognizer recognizer = new Recognizer(Recognizer.Languages.ENGLISH_INDIA, "AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw"); //Specify your language here.
	//Recognizer recognizer = new Recognizer(Recognizer.Languages.ENGLISH_INDIA, "AIzaSyCWMkWixP-VWcXkiEa8oTsdfCSUR6--dnE"); //Specify your language here.
	//Although auto-detect is avalible, it is recommended you select your region for added accuracy.
	try {
		int maxNumOfResponses = 100;
		GoogleResponse response = recognizer.getRecognizedDataForFlac(file, maxNumOfResponses, (int)mic.getAudioFormat().getSampleRate());
		
                resp=new Response(response.getResponse(),response.getAllPossibleResponses(),response.getConfidence());
  
	} catch (Exception ex) {
		// TODO Handle how to respond if Google cannot be contacted
		System.out.println("ERROR: Google cannot be contacted");
		ex.printStackTrace();
	}
	finally{
	file.deleteOnExit();//Deletes the file as it is no longer necessary.
	
        }
        return resp;
}

}