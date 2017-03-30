package com.example.guswn_000.a170330class;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guswn_000 on 2017-03-30.
 */

public class Fragment1 extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //위에거 oncreate쓰면 자동으로뜸
        View fragview = inflater.inflate(R.layout.fragment1,container,false);

        TextView textview = (TextView)fragview.findViewById(R.id.textView);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이벤트 걸긔~
            }
        });
        return fragview;
    }
}
