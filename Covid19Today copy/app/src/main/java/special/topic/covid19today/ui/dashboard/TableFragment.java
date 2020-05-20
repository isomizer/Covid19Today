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

    public static String choose;

    public static String key[] = new String[77];
    public static String data[] = new String[77];

    public static String data1;
    public static String data2;

    private TableViewModel mViewModel;
    private static String chooseName;
    public static TableFragment newInstance() {
        return new TableFragment();
    }
    public static String getChooseName(){
        return chooseName;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_table, container, false);

        View root2 = inflater.inflate(R.layout.fragment_dashboard, container, false);

        choose = TableFragment.getChooseName();
        button = root.findViewById(R.id.button);
        button = root.findViewById(R.id.button);
        chooseName = "Province";
        button.setText(getChooseName());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(getActivity() , button);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        chooseName = ""+item.getTitle();
                        button.setText(getChooseName());

                        return true;
                    }
                });
                popupMenu.show();
            }
        });



        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        DashboardFetch process = new DashboardFetch();
        process.execute();



        Toast.makeText(getActivity().getApplicationContext(), chooseName, Toast.LENGTH_SHORT).show();
        for (int i=0; i < data.length; i++) {
            exampleList.add(new ExampleItem(key[i], data[i]));
        }
        mRecyclerView = root.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutMangager = new LinearLayoutManager(getActivity());
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutMangager);
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TableViewModel.class);
        // TODO: Use the ViewModel
    }

}
