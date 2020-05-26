package special.topic.covid19today.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import special.topic.covid19today.R;

public class DashboardFragment extends Fragment {

    RadioGroup rg;
    Button btnTable, btnGraph;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        rg = root.findViewById(R.id.radios);
        btnTable = root.findViewById(R.id.radioButtonTable);
        btnGraph = root.findViewById(R.id.radioButtonGraph);

        SelectFragment(new TableFragment());

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

    private void SelectFragment(Fragment fragment) {
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }
}
