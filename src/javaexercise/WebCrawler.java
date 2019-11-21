package javaexercise;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
public class WebCrawler {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String url = s.nextLine();
		crawler(url);
	}
	
	public static void crawler(String startingUrl) {
		ArrayList<String> pendingUrls = new ArrayList<String>();
		ArrayList<String> traversedUrls = new ArrayList<String>();
		
		pendingUrls.add(startingUrl);
		while(!pendingUrls.isEmpty() && traversedUrls.size()<=100) {
			String urlString = pendingUrls.remove(0);
			
			if(!traversedUrls.contains(urlString)) {
				traversedUrls.add(urlString);
				System.out.println("Crawl: "+urlString);
				
				for(String s : getSubUrl(urlString)) {
					if(!pendingUrls.contains(s)) {
						pendingUrls.add(s);
					}
				}
			}
			
			
		}
	}
	
	public static ArrayList<String> getSubUrl(String urlString) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			URL url = new URL(urlString);
			Scanner input = new Scanner(url.openStream());
			int current = 0;
			while(input.hasNext()) {
				String line = input.nextLine();
				//	从line中找到http的索引位置，从current位置开始查找
				current = line.indexOf("http:", current);
				while(current>0) {
					//	一行中可能含有多个url
					int endIndex = line.indexOf("\"", current);
					if(endIndex>0) {
						result.add(line.substring(current, endIndex));
						current = line.indexOf("http:", endIndex);
					} else {
						current = -1;
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

}
