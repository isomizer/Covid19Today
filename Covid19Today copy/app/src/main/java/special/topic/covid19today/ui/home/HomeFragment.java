package special.topic.covid19today.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import special.topic.covid19today.R;

public class HomeFragment extends Fragment {

    public static TextView textConfirmed;
    public static TextView textRecovered;
    public static TextView textHospitalized;
    public static TextView textDeaths;
    public static TextView textHead;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textConfirmed = root.findViewById(R.id.text_home_1);
        textRecovered = root.findViewById(R.id.text_home_2);
        textHospitalized = root.findViewById(R.id.text_home_3);
        textDeaths = root.findViewById(R.id.text_home_4);
        textHead = root.findViewById(R.id.text_home_head);

        HomeFetch process = new HomeFetch();
        process.execute();

        return root;
    }
}
