package kicisoft.effectpedalfile.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import kicisoft.effectpedalfile.MainActivity;
import kicisoft.effectpedalfile.R;

/**
 * Created by Juan on 26/07/2014.
 * Fragment for main screen principal content.
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends Fragment{

    @ViewById
    TextView title, description;

    @AfterViews
    void init(){
    }

    @Click
    void menuButton(){
        ((MainActivity)getActivity()).toggleMenu();
    }
}
