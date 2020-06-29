package demo.resourcebundle;

import java.util.ResourceBundle;

public class ResourceBundleTest {

	public static void main(String[] args) {
		
		ResourceBundle rd = ResourceBundle.getBundle("ex03.pyrmont.connector.http" + ".LocalStrings");
		System.out.println(rd.getString("httpConnector.alreadyInitialized"));
	}

}
