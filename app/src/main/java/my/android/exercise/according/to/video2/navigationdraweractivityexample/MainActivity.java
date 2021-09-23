package my.android.exercise.according.to.video2.navigationdraweractivityexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl=findViewById(R.id.drawerlayoutid);
        // for supporting the actionbar , showing icon etc
        t=new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);

        //for changing the toogle icon hamburger to backpress or viece versa
        dl.addDrawerListener(t);

        //for changing the state icon of toggle button [back press to hambergur icon]
        //for showing the hamburger icon
        t.syncState();

        //for showing upicon
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

// for performing the event of navigation drawer's item , it must have to be used a drawer action listener
//        each navigation item

        nv=findViewById(R.id.navviewid);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.accountid:
                        Toast.makeText(MainActivity.this, "Your Account", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.homeid:
                        Toast.makeText(MainActivity.this, "Home Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settingsid:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }
                //overall result it has no effect here but for getting without item
//        boolean result , it must be required.

                return true;


            }
        });

    }

    // this function for performing the toggle icon (hamburger icon and its associated
    // back press button)

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // conditional statement toggle icon action behavior
        if (t.onOptionsItemSelected(item)){
            return true;
        }
        //overall result it has no effect here but for getting without item
//        boolean result , it must be required.

        return super.onOptionsItemSelected(item);
    }
}