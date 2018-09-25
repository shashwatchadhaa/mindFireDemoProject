package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileManager {

	
	
	
	
	
	private static FileInputStream fis;
	private static String configFilePath;
	private static String testCaseRepoPath;
	private static Properties testCaseP = new Properties();
	private static Properties properties = new Properties();
	
	
	public static void loadTestCaseRepository()
	{
	
		try {
			File file = new File(PropertiesFileManager.getTestCaseRepoPath());
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			
			testCaseP.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	
	
	
	
	
	
	public static String getTestCaseRepoPath() {
		return testCaseRepoPath;
	}








	public static void setTestCaseRepoPath(String testCaseRepoPath) {
		PropertiesFileManager.testCaseRepoPath = testCaseRepoPath;
	}








	public static String getConfigFilePath() {
		return configFilePath;
	}

	public static void setConfigFilePath(String path) {
		configFilePath = path;
	}

	public static void loadConfigProperties()
	{
	
		try {
			File file = new File(PropertiesFileManager.getConfigFilePath());
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	

	public static String getTestCaseProperty(String key)
	{
		return testCaseP.getProperty(key);
	}
	
	public static String getConfigProperty(String key)
	{
		return properties.getProperty(key);
	}
	
	
	
	
	
}
