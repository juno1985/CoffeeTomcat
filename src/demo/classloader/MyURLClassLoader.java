package demo.classloader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class MyURLClassLoader {
	
	public static final String WEB_ROOT =
		    System.getProperty("user.dir") + File.separator  + "webroot";

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		File file = new File(WEB_ROOT);
		String canonicalPath = file.getCanonicalPath();
	
		URL url = new URL("file", null, canonicalPath + File.separator);
		
		String repo = url.toString();
		
		URL[] url_arr = new URL[1];
		URLStreamHandler streamHandler = null;
		url_arr[0] = new URL(null, repo, streamHandler);
		
		URLClassLoader classLoader = new URLClassLoader(url_arr);
		
		Class<?> myclass = classLoader.loadClass("DivTest");
		
		Div divTest = (Div) myclass.newInstance();
		divTest.calculate(4, 2);
		
	    
	    System.out.println(Div.class.getClassLoader().hashCode());
	    System.out.println(MyURLClassLoader.class.getClassLoader().hashCode());
	    
		
	}

}
