package special.topic.covid19today.ui.dashboard;

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
import java.util.Iterator;

public class DashboardFetch extends AsyncTask<Void,Void,Void>  {
    private String pKey[] = new String[77];
    private String pData[];
    private String gKey[] = new String[77];
    private String gData[];
    private String nKey[] = new String[77];
    private String nData[];

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://covid19.th-stat.com/api/open/cases/sum");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String data = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject JO = new JSONObject(data);
            JSONObject JOp = new JSONObject(JO.getString("Province"));
            Iterator<String> pKeys = JOp.keys();
            int pCount = 0;
            while(pKeys.hasNext()) {
                pKey[pCount] = pKeys.next();
                pCount++;
            }
            pData = new String[pCount];
            for (int i=0; i<pCount; i++) {
                pData[i] = JOp.getString(pKey[i]);
            }

            JSONObject JOg = new JSONObject(JO.getString("Gender"));
            Iterator<String> gKeys = JOg.keys();
            int gCount = 0;
            while(gKeys.hasNext()) {
                gKey[gCount] = gKeys.next();
                gCount++;
            }
            gData = new String[gCount];
            for (int i=0; i<gCount; i++) {
                gData[i] = JOg.getString(gKey[i]);
            }

            JSONObject JOn = new JSONObject(JO.getString("Nation"));
            Iterator<String> nKeys = JOn.keys();
            int nCount = 0;
            while(nKeys.hasNext()) {
                nKey[nCount] = nKeys.next();
                nCount++;
            }
            nData = new String[nCount];
            for (int i=0; i<nCount; i++) {
                nData[i] = JOn.getString(nKey[i]);
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

        TableFragment.pKey = pKey;
        TableFragment.pData = pData;
        TableFragment.gKey = gKey;
        TableFragment.gData = gData;
        TableFragment.nKey = nKey;
        TableFragment.nData = nData;
    }
}
