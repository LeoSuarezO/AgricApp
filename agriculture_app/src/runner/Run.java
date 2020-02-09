
package runner;

import java.io.IOException;

import org.json.simple.DeserializationException;

import controller.AppManager;

public class Run {
	
	public static void main(String[] args) throws DeserializationException, IOException {
		new AppManager();
	}
}
