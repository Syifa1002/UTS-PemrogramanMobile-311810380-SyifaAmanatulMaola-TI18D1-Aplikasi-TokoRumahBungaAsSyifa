package id.ac.pelitabangsa.uts_syifaamanatulmaola311810380;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    ListView lv;
    ArrayList al;
    ArrayAdapter aa;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        lv =  (ListView) v.findViewById(R.id.list);
        al = new ArrayList();
        aa = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_activated_1,al);
        lv.setAdapter(aa);
        al.add("Tanaman Hidup");
        al.add("Tanaman Pelastik");
        al.add("Bunga Taman");
        al.add("Bibit Tanaman Hias");
        al.add("Bibit Tanaman Sayuran");

        return v;

    }
}