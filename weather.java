
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class weather {
   
    public static void main(String[] args) throws Exception {
      //Shout Out to Open-meteo for there free and open source weather api 
      // https://open-meteo.com/en/docs
        String apiEndpoint = "https://api.open-meteo.com/v1/forecast?latitude=41.76&longitude=-88.32&hourly=temperature_2m&forecast_days=1&timezone=America%2FChicago";

        URL url = new URL(apiEndpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String allTemp = response.toString();
        String result = "";
        int temp3 = 0;
        for (int i = 0; i < allTemp.length() - 14; i++) {
            if (allTemp.substring(i, i + 14).equals("temperature_2m")) {
                temp3++;
            }
            if (temp3 == 2) {
                result = allTemp.substring(i + 18, allTemp.length() - 3);
                break;
            }
        }
 
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
        LocalDateTime now = LocalDateTime.now();  
        int countofcomma = 0;
        String temperature = "";
     
        for (int i = 0; i < result.length(); i++){
            if(result.substring(i,i+1).equals(",")){
                countofcomma++;
            }
            if(countofcomma==Integer.parseInt(dtf.format(now))){
                int temp = 0;
                int j = i+1;
               while(!(result.substring(j,j+1).equals(","))){
                j++;
                temp++;
               }
               temperature = result.substring(i+1,i+temp+1);
               break;
            }
        }
        System.out.println("temperature "+temperature);
    }
}
