package special.topic.covid19today.ui.dashboard;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

import special.topic.covid19today.ExampleAdapter;
import special.topic.covid19today.ExampleItem;
import special.topic.covid19today.R;

public class TableFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutMangager;

    Button button;

    public String choose;

    private TableViewModel mViewModel;

    public static TableFragment newInstance() {
        return new TableFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        final View root = inflater.inflate(R.layout.fragment_table, container, false);

        View root2 = inflater.inflate(R.layout.fragment_dashboard, container, false);

                                choose = DashboardFragment.getChooseName();

                                ArrayList<ExampleItem> exampleList = new ArrayList<>();

                                if(choose.equals("area")) {
                                    Toast.makeText(getActivity().getApplicationContext(), choose, Toast.LENGTH_SHORT).show();
                                    exampleList.add(new ExampleItem(choose, "155"));
                                    exampleList.add(new ExampleItem("Nb", "1"));
                                    exampleList.add(new ExampleItem("aa", "122"));
                                    mRecyclerView = root.findViewById(R.id.recycler_view);
                                    mRecyclerView.setHasFixedSize(true);
                                    mLayoutMangager = new LinearLayoutManager(getActivity());
                                    mAdapter = new ExampleAdapter(exampleList);

                                    mRecyclerView.setLayoutManager(mLayoutMangager);
                                    mRecyclerView.setAdapter(mAdapter);
                                }
                                else if(choose.equals("gender")){

                                    exampleList.add(new ExampleItem(choose, "155"));
                                    exampleList.add(new ExampleItem("Nb", "15555555"));
                                    exampleList.add(new ExampleItem("aadddd", "122w"));
                                    mRecyclerView = root.findViewById(R.id.recycler_view);
                                    mRecyclerView.setHasFixedSize(true);
                                    mLayoutMangager = new LinearLayoutManager(getActivity());
                                    mAdapter = new ExampleAdapter(exampleList);

                                    mRecyclerView.setLayoutManager(mLayoutMangager);
                                    mRecyclerView.setAdapter(mAdapter);
                                }

        return root;

    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TableViewModel.class);
        // TODO: Use the ViewModel
    }

}
