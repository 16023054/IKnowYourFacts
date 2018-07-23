package sg.edu.rp.c346.iknowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btn;
    int reqCode = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vPager = (ViewPager) findViewById(R.id.view);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String fragment = prefs.getString("fragment", "");
        if (fragment != null ) {
            vPager.setCurrentItem(Integer.valueOf(fragment));
        }
        FragmentManager fm = getSupportFragmentManager();
        al = new ArrayList<Fragment>();
        al.add(new f1());
        al.add(new f2());
        al.add(new f3());
        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, 5);

                Intent intent = new Intent(MainActivity.this,
                        ScheduledNotificationReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        MainActivity.this, reqCode,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)
                        getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        pendingIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.previous){
            if (vPager.getCurrentItem()>0){
                int previousPage = vPager.getCurrentItem()-1;
                vPager.setCurrentItem(previousPage, true);
            }
        }else if(id==R.id.random){
            int min = 0;
            int max = 3;
            Random r = new Random();
            int i1 = r.nextInt(max - min + 1) + min;
            vPager.setCurrentItem(i1,true);
        }else{
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem()<max-1){
                int nextPage = vPager.getCurrentItem()+1;
                vPager.setCurrentItem(nextPage, true);
            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("fragment", ""+vPager.getCurrentItem());
        editor.commit();
    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("fragment", ""+vPager.getCurrentItem());
        editor.commit();
    }
    @Override
    protected void onStop(){
        super.onStop();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("fragment", ""+vPager.getCurrentItem());
        editor.commit();
    }
    @Override
    protected void onResume(){
        super.onResume();
        vPager = (ViewPager) findViewById(R.id.view);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String fragment = prefs.getString("fragment", "");
        if (fragment != null ) {
            vPager.setCurrentItem(Integer.valueOf(fragment));
        }
        FragmentManager fm = getSupportFragmentManager();
        al = new ArrayList<Fragment>();
        al.add(new f1());
        al.add(new f2());
        al.add(new f3());
        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, 5);

                Intent intent = new Intent(MainActivity.this,
                        ScheduledNotificationReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        MainActivity.this, reqCode,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)
                        getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        pendingIntent);
            }
        });
    }
}

