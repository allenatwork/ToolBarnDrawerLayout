package allen.fragmenttest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FragmentStack fragmentStack;
    private DrawerLayout mDrawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText("Hello from me other site");

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.drawer);

        setupDrawerContent(navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawer.addDrawerListener(actionBarDrawerToggle);

        fragmentStack = new FragmentStack(this, getSupportFragmentManager(), R.id.frame_content);
        Fragment fragment = fragmentStack.peek();
        if (fragment == null) fragmentStack.replace(new TestFragment1());


    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                secectDrawerItem(item);
                return true;
            }
        });
    }

    private void secectDrawerItem(MenuItem item) {
        item.setChecked(true);
        mDrawer.closeDrawers();
        switch (item.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentStack.replace(new TestFragment1());
                break;
            case R.id.nav_second_fragment:
                fragmentStack.replace(new TesFragment2());
                break;
            case R.id.nav_third_fragment:
                fragmentStack.replace(new TestFragment1());
                break;
            default:
                fragmentStack.replace(new TestFragment1());
        }


    }

    public FragmentStack getFragmentStack() {
        return fragmentStack;
    }

    public void syncActionBar(Fragment fragment) {

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
