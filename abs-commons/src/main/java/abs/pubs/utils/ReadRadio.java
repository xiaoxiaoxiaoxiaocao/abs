package abs.pubs.utils;

import java.io.File;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

public class ReadRadio {
	public static int getDuration(File source) throws Exception{
		Encoder encoder = new Encoder();
		MultimediaInfo info = encoder.getInfo(source);
		int duration = (int) info.getDuration();
		return duration;
	}

}
