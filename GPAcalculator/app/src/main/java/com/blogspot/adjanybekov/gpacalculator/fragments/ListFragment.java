package com.blogspot.adjanybekov.gpacalculator.fragments;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.adjanybekov.gpacalculator.R;
import com.blogspot.adjanybekov.gpacalculator.adapter.GpaAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Object> {

    RecyclerView recyclerView;
    GpaAdapter adapter;

    TextView grade;
    TextView course;
    TextView credits;

    private static final String DIALOG_TAG = "courseInfo";
    Button addCourse;


    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new GpaAdapter();
        getLoaderManager().initLoader(0,null,this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View v = inflater.inflate(R.layout.fragment_list, container,false); // pointer to the fragment list xml
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        addCourse = (Button) v.findViewById(R.id.idAddCourseButton);
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager ft = getActivity().getSupportFragmentManager();
                CourseDialogFragment dialog = new CourseDialogFragment();
                dialog.show(ft,DIALOG_TAG);
            }
        });




        return v;

    }

    @Override
    public Loader<Object> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Object> loader, Object data) {

    }

    @Override
    public void onLoaderReset(Loader<Object> loader) {

    }
}
