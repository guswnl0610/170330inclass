package com.example.guswn_000.a170330class;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Toast gravtoast;
    Toast layouttst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);


    }

    public void myonclick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                Toast.makeText(this, "일반 메세지 창입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                gravtoast = Toast.makeText(this,"위치 지정 메세지 창입니다.",Toast.LENGTH_SHORT);
                gravtoast.setGravity(Gravity.LEFT|Gravity.TOP, 10, 20);
                gravtoast.show();
                break;
            case R.id.button3:
                //View view = View.inflate(getApplicationContext(),R.layout.mytoast,null); //토스트레이아웃을 객체화 시키는작업
                View view = getLayoutInflater().inflate(R.layout.mytoast,null); //위에거 안댐 이렇게해야댐
                TextView message = (TextView)view.findViewById(R.id.textView4);//view.이걸해야지 토스트레이아웃의 텍스트뷰를 객체화할수있다
                message.setText("레이아웃으로 만든 토스트");
                layouttst = new Toast(this);
                layouttst.setDuration(Toast.LENGTH_SHORT);
                layouttst.setGravity(Gravity.CENTER,0,100);
                layouttst.setView(view);
                layouttst.show();
                break;
            case R.id.button4:
                //Snackbar.make(v,"Message",1000).setAction("확인", null) // 이건 확인눌러도 아무것도 안함
                Snackbar.make(v,"Message",1000).setAction("확인", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //기능넣고싶으면 넣어라
                    }
                }).show();
                break;
        }
    }
}
