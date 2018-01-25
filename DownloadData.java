import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadData implements Runnable
{
    String url;
    
    DownloadData(String url)
    {
        this.url=url;
    }

    //String url="https://dl.jatt.link/cdn9.jatt.link/dca7431aa4015819ded71839bd47e442/namzv/Naah-(Mr-Jatt.com).mp3";

    public void run() 
    {
        try {
              URL makeURL= new URL(url);

        HttpURLConnection httpURLConnection=(HttpURLConnection)makeURL.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.addRequestProperty("User-Agent", "Mozilla");
        httpURLConnection.setConnectTimeout(200000);
        httpURLConnection.setReadTimeout(300000);
        httpURLConnection.setDoOutput(true);
        System.out.println(httpURLConnection.getResponseCode());
    
        if( httpURLConnection.getResponseCode()==200)
        {
                System.out.println("Connected, getting data");
            BufferedInputStream br=new BufferedInputStream(httpURLConnection.getInputStream());
            byte[] buff=new byte[1024];
            int len=0;
            FileOutputStream fout = new FileOutputStream(new File("E:\\Java\\FileDownloaded.mp3"));;
            while( (len= br.read(buff)) != -1) 
            {         
                    fout.write(buff, 0, len);
                   // len=br.read(buff);   
            }
            
            fout.close();
            System.out.println("Downloading done");
            
        }
        else
        {
            System.out.println("Error no connection can be made");
        }
    }catch(Exception e){System.out.println("Check execption inside run "+e);}
 }
}