package com.example.guswn_000.a170330class;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
            //여기까지 토스트 이제부터 대화샂아
            case R.id.button5:
                AlertDialog.Builder dlg = new AlertDialog.Builder(this); // 얘는 모든 함수가 대화상자의 객체로 리턴됨
                dlg.setTitle("제목")
                        .setMessage("내용")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "확인을 눌렀습니다", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show(); //이렇게해도된다 null 부분에는 이벤트 달 수 있다. 위에온클릭리스너처럼
                break;
            case R.id.button6:
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(this); // 얘는 모든 함수가 대화상자의 객체로 리턴됨
                String data[] = {"치킨","피자"};//목록 배열만드러줘야함
                dlg2.setTitle("제목")
                        .setSingleChoiceItems(data, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        }) // 여기에도 이벤트를 달 수 있다 여기서 뭐가선택됐는지 저장해줘야함 이때 저장하는변수는 전역변수로
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Toast.makeText(MainActivity.this, "확인을 눌렀습니다", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show(); //이렇게해도된다 null 부분에는 이벤트 달 수 있다. 위에온클릭리스너처럼
                break;
            case R.id.button7:
                AlertDialog.Builder dlg3 = new AlertDialog.Builder(this); // 얘는 모든 함수가 대화상자의 객체로 리턴됨
                final String data2[] = {"치킨","피자","참방","알촌"};//목록 배열만드러줘야함
                final boolean checked[] = {true,false,true,true}; //치킨 o 피자x 선택x 참방o 알촌o 이 정보는 이벤트를 걸어서 매번 바꿔줘야함
                dlg3.setTitle("제목")
                        .setMultiChoiceItems(data2, checked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked)
                            {
//                                if(checked[which] = isChecked)//checked는 전역변수화시키려고 final. 아니면아예전역변수로설정
//                                {
//                                    Toast.makeText(MainActivity.this, data2[which]+"가 선택되었습니다", Toast.LENGTH_SHORT).show();
//                                }
                            }
                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Toast.makeText(MainActivity.this, "확인을 눌렀습니다", Toast.LENGTH_SHORT).show();
                            }//누가 선택이 됐는지?
                        })
                        .show(); //이렇게해도된다 null 부분에는 이벤트 달 수 있다. 위에온클릭리스너처럼

                break;
            case R.id.button8:
                View view2 = View.inflate(this,R.layout.dlglayout,null);
                final EditText dt = (EditText)view2.findViewById(R.id.editText3);
                AlertDialog.Builder dlg4 = new AlertDialog.Builder(this); // 얘는 모든 함수가 대화상자의 객체로 리턴됨
                dlg4.setTitle("제목")
                        .setView(view2)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Toast.makeText(MainActivity.this, dt.getText().toString() , Toast.LENGTH_SHORT).show();//에딧택스트받아서 토스트
                            }
                        })
                        .show();
                break;
        }
    }
}
