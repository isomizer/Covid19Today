package special.topic.covid19today.ui.dashboard;


import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import special.topic.covid19today.R;
import special.topic.covid19today.ui.home.HomeFetch;

public class GraphFragment extends Fragment {


    public static com.jjoe64.graphview.GraphView graph;

    private GraphViewModel mViewModel;

    public static GraphFragment newInstance() {
        return new GraphFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_graph, container, false);
        graph = root.findViewById(R.id.graph_1);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 2),
                new DataPoint(1, 3),
                new DataPoint(2, 5),
                new DataPoint(3, 7),
                new DataPoint(4, 8),
                new DataPoint(5, 14),
                new DataPoint(6, 19),
                new DataPoint(7, 25),
                new DataPoint(8, 32),
                new DataPoint(9, 33),
                new DataPoint(10, 34),
                new DataPoint(11, 35),
                new DataPoint(12, 37),
                new DataPoint(13, 40),
                new DataPoint(14, 41),
                new DataPoint(15, 42),
                new DataPoint(16, 43),
                new DataPoint(17, 47),
                new DataPoint(18, 48),
                new DataPoint(19, 50),
                new DataPoint(20, 53),
                new DataPoint(21, 59),
                new DataPoint(22, 70),
                new DataPoint(23, 75),
                new DataPoint(24, 82),
                new DataPoint(25, 144),
                new DataPoint(26, 147),
                new DataPoint(27, 177),
                new DataPoint(28, 212),
                new DataPoint(29, 272),
                new DataPoint(30, 322),
                new DataPoint(31, 411),
                new DataPoint(32, 599),
                new DataPoint(33, 721),
                new DataPoint(34, 827),
                new DataPoint(35, 934),
                new DataPoint(36, 1045),
                new DataPoint(37, 1136),
                new DataPoint(38, 1245),
                new DataPoint(39, 1388),
                new DataPoint(40, 1524),
                new DataPoint(41, 1651),
                new DataPoint(42, 1771),
                new DataPoint(43, 1875),
                new DataPoint(44, 1978),
                new DataPoint(45, 2067),
                new DataPoint(46, 2169),
                new DataPoint(47, 2220),
                new DataPoint(48, 2258),
                new DataPoint(49, 2369),
                new DataPoint(50, 2423),
                new DataPoint(51, 2473),
                new DataPoint(52, 2518),
                new DataPoint(53, 2551),
                new DataPoint(54, 2579),
                new DataPoint(55, 2613),
                new DataPoint(56, 2643),


        });
        graph.addSeries(series);
        return root;
//        return inflater.inflate(R.layout.fragment_graph, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GraphViewModel.class);
        // TODO: Use the ViewModel
    }


}
