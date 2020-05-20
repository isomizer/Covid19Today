package special.topic.covid19today.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import special.topic.covid19today.R;

public class DashboardFragment extends Fragment {

    RadioGroup rg;
    Button btnTable,btnGraph;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        rg = root.findViewById(R.id.radios);
        btnTable = root.findViewById(R.id.radioButtonTable);
        btnGraph = root.findViewById(R.id.radioButtonGraph);

        btnGraph.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SelectFragment(new GraphFragment());
            }
        });
        btnTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectFragment(new TableFragment());
            }
        });
        return root;
    }

    public void SelectFragment(Fragment fragment) {
        fragmentManager =  getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }


}
