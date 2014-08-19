package kicisoft.effectpedalfile.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import kicisoft.effectpedalfile.LoadSetupActivity_;
import kicisoft.effectpedalfile.MainActivity;
import kicisoft.effectpedalfile.R;
import kicisoft.effectpedalfile.EffectDetailsActivity_;

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
        EffectDetailsActivity_.intent(getActivity()).start();
    }

    @Click
    void loadSetupButton(){
        ((MainActivity)getActivity()).toggleMenu();
        LoadSetupActivity_.intent(getActivity()).start();
    }

    @Click
    void optionsButton(){
        ((MainActivity)getActivity()).toggleMenu();
    }

}
