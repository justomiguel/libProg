package com.frre.test.archivos.labii.hilos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jvargas on 8/28/15.
 */
public class ProcesoLargo extends Thread {

    private static final String USER_AGENT = "Mozilla/5.0";

    @Override
    public void run() {
       try {
           String url = "http://www.google.com/search?q=mkyong";

           URL obj = new URL(url);
           HttpURLConnection con = (HttpURLConnection) obj.openConnection();

           // optional default is GET
           con.setRequestMethod("GET");

           //add request header
           con.setRequestProperty("User-Agent", USER_AGENT);

           int responseCode = con.getResponseCode();
           System.out.println("\nSending 'GET' request to URL : " + url);
           System.out.println("Response Code : " + responseCode);

           BufferedReader in = new BufferedReader(
                   new InputStreamReader(con.getInputStream()));
           String inputLine;
           StringBuffer response = new StringBuffer();

           while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
           }
           in.close();

           Thread.sleep(50000);
           //print result
           System.out.println(response.toString());
       } catch (Exception e){

       }
    }
}
