import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javafx.scene.media.MediaPlayer;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class SoundPlayer {

	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException {		
		
		
		 try {
		        File srcFile = new File("Allah1.wav");
		        FileInputStream in = new FileInputStream(srcFile);
		        ObjectOutputStream output =  new ObjectOutputStream(new FileOutputStream("gilad-OutPut.bin"));
		        byte[] buf = new byte[80000];
		        short[] shortArr = new short[buf.length/2];
		        in.read(buf);
		        for (int i = 0; i <buf.length/2 ; i++)
		        {
		            output.writeShort( (short)( ( buf[i*2] & 0xff )|( buf[i*2 + 1] << 8 ) ) );
		            shortArr[i] = ( (short)( ( buf[i*2] & 0xff )|( buf[i*2 + 1] << 8 ) ) );
		        }
   System.out.println(buf[5]+"  "+buf[10]+"  "+ buf[70]);
		        in.close();

		    } catch (Exception e) {
		        System.err.println(e);

		    }
		 
		// AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
		  //  	    new File("Allah1.wav"));
		/*Modification of sound file
		 * Doesn't work
		 */
		//source file
		/*final File file1 = new File("Allah.mp3");
		//destination file
		final File file2 = new File("Allah1.wav");
		final AudioInputStream in1 = AudioSystem.getAudioInputStream(file1);
		final AudioFormat inFormat =getOutFormat(in1.getFormat());
		//change the frequency of Audio format
		//get the target file audio stream using file format
		final AudioInputStream in2 = AudioSystem.getAudioInputStream(inFormat, in1);
		//write the audio file in targeted pitch file
		AudioSystem.write(in2, AudioFileFormat.Type.WAVE, file2);*/
		
		
		//read sound file and play it
		
		/*JFrame frame=new JFrame();
		frame.setLocation(100,100);
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Canvas c =new Canvas();
		c.setBackground(Color.white);
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
	    Button play=new Button();
	    Button pause=new Button();
	    Button stop=new Button();
	    play.setVisible(true);
	    pause.setVisible(true);
	    stop.setVisible(true);
	    p.add(play);
	    p.add(pause);
	    p.add(stop);
		p.add(c);
		frame.add(p);
		frame.setVisible(true);
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        MediaPlayerFactory mpf = new MediaPlayerFactory();
        EmbeddedMediaPlayer emp=mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(frame));
        emp.setVideoSurface(mpf.newVideoSurface(c));
       // emp.toggleFullScreen();
        emp.setEnableMouseInputHandling(true);
        emp.setEnableKeyInputHandling(true);
        String file="Allah.mp3";
        emp.prepareMedia(file);
        emp.play();*/
        
	}

}
