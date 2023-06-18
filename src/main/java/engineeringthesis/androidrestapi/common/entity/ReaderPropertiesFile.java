package engineeringthesis.androidrestapi.common.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class ReaderPropertiesFile {

	Properties prop = null;

	public Properties readPropertiesFile(String fileName) throws IOException {

		try (InputStream input = ReaderPropertiesFile.class.getClassLoader()
				.getResourceAsStream("application.properties")) {
			prop = new Properties();
			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
			}
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
}
