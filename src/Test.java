import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.sound.sampled.*;

public class Test {


    public static void main(String[] args) {

        //File audio = new File(path);
        String path = System.getProperty("user.dir") + File.separator + "audio.mp3";
        //Path path = Paths.get(System.getProperty("user.dir") + File.separator + "audio.mp3");


        final File file = new File(path);
        final AudioInputStream in;
        try {
            in = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
            AudioInputStream din = null;
            final AudioFormat baseFormat = in.getFormat();
            final AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false);

            System.out.println("Channels : " + baseFormat.getChannels());
            din = AudioSystem.getAudioInputStream(decodedFormat, in);
            rawplay(decodedFormat, din);
            in.close();
            System.out.println("Done");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void rawplay(final AudioFormat targetFormat, final AudioInputStream din) throws IOException, LineUnavailableException {
        final byte[] data = new byte[4096];
        final SourceDataLine line = getLine(targetFormat);
        if (line != null) {
            System.out.println("Entering ...");
            // Start
            line.start();
            int nBytesRead = 0, nBytesWritten = 0;
            while (nBytesRead != -1) {
                nBytesRead = din.read(data, 0, data.length);
                if (nBytesRead != -1) {
                    // LINE57, HOW CAN INTERPRET this data for VISUALIZATION.
                    nBytesWritten = line.write(data, 0, nBytesRead);
                    System.out.println("... -->" + data[0] + " bytesWritten:" + nBytesWritten);
                }
            } // End of while //
            System.out.println("Done ...");
            // Stop
            line.drain();
            line.stop();
            line.close();
            din.close();
        } // End of the if //
    }

    private static synchronized SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException {
        SourceDataLine res = null;
        final DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        res = (SourceDataLine) AudioSystem.getLine(info);
        res.open(audioFormat);
        return res;
    }

}
