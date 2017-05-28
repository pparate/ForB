package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() 
	{
		File src = new File("C:\\WorkSpace\\com.MyFrame1.hybrid\\Configuration\\Config.properties");
		
		try{
			
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
		}
	}
	
	public String getURL()
	{
		String url = pro.getProperty("url");
		
		return url;
	}
	

	public String getChromePath()
	{
		String chrome = pro.getProperty("chromePath");
		
		return chrome;
	}
	

	public String getIEPath()
	{
		String ie = pro.getProperty("IEPath");
		
		return ie;
	}

}
