import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

public class DocGhiTep
{
    static ArrayList<HighlandsCoffee> orders=new ArrayList<HighlandsCoffee>();

    public static ArrayList<HighlandsCoffee> readFile(String path){
        ArrayList<HighlandsCoffee> orders=new ArrayList<HighlandsCoffee>();
        try{
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr =  new InputStreamReader(fis);
            BufferedReader bfr = new BufferedReader(isr);

            String line = bfr.readLine(); 
            
            while(line != null){
                String []arr= line.split(",");
                if(arr.length == 4 ){
                    HighlandsCoffee order = new HighlandsCoffee(arr[0],arr[1].trim(),arr[2].trim(),Double.parseDouble(arr[3].trim()));
                    orders.add(order);
                }
                line = bfr.readLine();
            }
            fis.close();
            isr.close();
            bfr.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return orders;
    }

    
}
