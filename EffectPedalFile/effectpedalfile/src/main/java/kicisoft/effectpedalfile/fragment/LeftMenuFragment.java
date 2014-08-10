package kicisoft.effectpedalfile.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import kicisoft.effectpedalfile.MainActivity;
import kicisoft.effectpedalfile.R;
import kicisoft.effectpedalfile.SetupDetailsActivity_;

/**
 * Created by Juan on 26/07/2014.
 * Fragment for main screen drawer menu.
 */
@EFragment(R.layout.fragment_left_menu)
public class LeftMenuFragment extends Fragment{
    @ViewById
    TextView newSetupButton, loadSetupButton, optionsButton;

    @AfterViews
    void init(){
    }

    @Click
    void newSetupButton(){
        ((MainActivity)getActivity()).toggleMenu();
    }

    @Click
    void loadSetupButton(){
        ((MainActivity)getActivity()).toggleMenu();
        SetupDetailsActivity_.intent(getActivity()).start();
    }

    @Click
    void optionsButton(){
        ((MainActivity)getActivity()).toggleMenu();
    }

}
