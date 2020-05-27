package special.topic.covid19today.ui.home;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeFetch extends AsyncTask<Void,Void,Void> {
    String[] data = new String[10];

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://covid19.th-stat.com/api/open/today");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            data[0] = "";
            while(line != null){
                line = bufferedReader.readLine();
                data[0] = data[0] + line;
            }

            JSONObject JO = new JSONObject(data[0]);

            data[1] = JO.getString("Confirmed");
            data[2] = JO.getString("Recovered");
            data[3] = JO.getString("Hospitalized");
            data[4] = JO.getString("Deaths");
            data[5] = JO.getString("NewConfirmed");
            data[6] = JO.getString("NewRecovered");
            data[7] = JO.getString("NewHospitalized");
            data[8] = JO.getString("NewDeaths");
            data[9] = JO.getString("UpdateDate");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        HomeFragment.textHead.setText("Covid-19 Thailand Status\n"+data[9]);
        HomeFragment.textConfirmed.setText("ยอดผู้ติดเชื้อ\n"+data[1]+"\n(เพิ่มขึ้น"+data[5]+")");
        HomeFragment.textRecovered.setText("ยอดผู้เข้ารักษา\n"+data[2]+"\n(เพิ่มขึ้น"+data[6]+")");
        HomeFragment.textHospitalized.setText("ยอดผู้รักษาหายแล้ว\n"+data[3]+"\n(เพิ่มขึ้น"+data[7]+")");
        HomeFragment.textDeaths.setText("ยอดผู้เสียชีวิต\n"+data[4]+"\n(เพิ่มขึ้น"+data[8]+")");
    }
}
