package kicisoft.effectpedalfile;

import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import kicisoft.effectpedalfile.fragment.LeftMenuFragment;
import kicisoft.effectpedalfile.fragment.LeftMenuFragment_;
import kicisoft.effectpedalfile.fragment.MainFragment;
import kicisoft.effectpedalfile.fragment.MainFragment_;

/**
 * Created by Juan on 26/07/2014.
 * Activity for main screen.
 */
@EActivity(R.layout.main_layout)
public class MainActivity extends FragmentActivity {
    @ViewById(R.id.drawer_layout)
    protected View drawerLayout;

    private LeftMenuFragment menuFragment;
    private MainFragment mainFragment;

    /**
     * Creates menu and main clean fragment.
     * Inserts fragments into sliding drawer layout.
     */
    private void initializeMenuAndMainFragments() {
        // Initialize fragments
        menuFragment = new LeftMenuFragment_();
        getSupportFragmentManager().beginTransaction().add(R.id.menu_fragment_container, menuFragment).commit();

        mainFragment = new MainFragment_();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment).commit();
    }

    @AfterViews
    public void init() {
        initializeMenuAndMainFragments();
    }

    /**
     * Toggle left menu.
     * If it's open get closed. And viceversa.
     */
    public void toggleMenu() {
        if (drawerLayout instanceof DrawerLayout) {
            DrawerLayout d = (DrawerLayout) drawerLayout;
            if (d.isDrawerOpen(Gravity.LEFT)) {
                d.closeDrawer(Gravity.LEFT);
            } else {
                d.openDrawer(Gravity.LEFT);
            }
        }
    }

    public void closeMenu() {
        if (drawerLayout instanceof DrawerLayout) {
            DrawerLayout d = (DrawerLayout) drawerLayout;
            if (d.isDrawerOpen(Gravity.LEFT)) {
                d.closeDrawer(Gravity.LEFT);
            }
        }
    }
}
