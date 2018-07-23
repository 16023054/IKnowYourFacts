package sg.edu.rp.c346.iknowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class f1 extends Fragment {
    Button f1;

    public f1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FrameLayout mRelativeLayout = (FrameLayout) inflater.inflate(R.layout.fragment_f1,
                container, false);
        Button mButton = (Button) mRelativeLayout.findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = 1;
                int max = 3;
                Random r = new Random();
                int i1 = r.nextInt(max - min + 1) + min;
                if(i1 == 1) {
                    mRelativeLayout.setBackgroundColor(Color.WHITE);
                }
                else if(i1 == 2){
                    mRelativeLayout.setBackgroundColor(Color.BLUE);
                }else{
                    mRelativeLayout.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        // after you've done all your manipulation, return your layout to be shown
        return mRelativeLayout;
    }

}
