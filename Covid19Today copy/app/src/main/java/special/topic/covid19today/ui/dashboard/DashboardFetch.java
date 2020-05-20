package special.topic.covid19today.ui.dashboard;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import special.topic.covid19today.ui.home.HomeFragment;

public class DashboardFetch extends AsyncTask<Void,Void,Void>  {
    String data;
    private String pKey[] = new String[77];
    private String pData[];
    private String c = TableFragment.chooseName;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://covid19.th-stat.com/api/open/cases/sum");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            data = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject JO = new JSONObject(data);
            JSONObject JOc = new JSONObject(JO.getString(c));
            Iterator<String> pKeys = JOc.keys();
            int pCount = 0;
            while(pKeys.hasNext()) {
                pKey[pCount] = pKeys.next();
                pCount++;
            }
            pData = new String[pCount];
            for (int i=0; i<pCount; i++) {
                pData[i]  = JOc.getString(pKey[i]);
            }



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

        TableFragment.data1 = c;
        TableFragment.key = pKey;
        TableFragment.data = pData;

    }
}
