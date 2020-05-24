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

public class GraphFetch extends AsyncTask<Void,Void,Void> {
    String data;
    int c[];
    int r[];
    int d[];

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://covid19.th-stat.com/api/open/timeline");
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
            JSONArray JA = JO.getJSONArray("Data");
            c = new int[JA.length()];
            r = new int[JA.length()];
            d = new int[JA.length()];
            for(int i=0; i<JA.length(); i++) {
                JSONObject jo = JA.getJSONObject(i);
                c[i] = Integer.parseInt(jo.getString("Confirmed"));
                r[i] = Integer.parseInt(jo.getString("Recovered"));
                d[i] = Integer.parseInt(jo.getString("Deaths"));
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

        GraphFragment.cInt = c;
        GraphFragment.rInt = r;
        GraphFragment.dInt = d;

    }
}