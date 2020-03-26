package com.apror.ssf;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.apror.ssf.getjson.GetJson;
import com.apror.ssf.getjsonlibrary.R;

import java.util.concurrent.ExecutionException;

public class second extends AppCompatActivity  {


    Handler mHandler;
    private Thread mUiThread;

    String s1, s2, s3, s4, s5, s6, s7, s8, t1, t2, t3, t4, t5, t6, t7, t8, h1, h2, h3, h4, h5, h6, h7, h8, j1, j2, j3, j4, j5, j6, j7, j8;
    String str;
    int e;
    String a[] = {"http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V0", "http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V1", "http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V2", "http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V3",
            "http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V4", "http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V5", "http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V6",
            "http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V7", "http://blynk-cloud.com/J0ms_QqUQPWLauuHe9Ku_w8PGW-ifQXQ/get/V8"};
    String b[]={"http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V0","http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1","http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V2",
            "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V3","http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V4","http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V5"};
   // String b[]={"a","b","c","d","e","f"};
    String[] d = new String[10];

  
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        mHandler = new Handler();

       Thread thread=new Thread(){
           public void run(){
               try {
                   while (true){
                       TextView txt1 = (TextView) findViewById(R.id.dev_id);
                       TextView txt2 = (TextView) findViewById(R.id.temp1);
                       TextView txt3 = (TextView) findViewById(R.id.alt_cal);
                       TextView txt4 = (TextView) findViewById(R.id.alt_real);
                       TextView txt5 = (TextView) findViewById(R.id.temp2);
                       TextView txt6 = (TextView) findViewById(R.id.pressure);
                       TextView txt7 = (TextView) findViewById(R.id.hb);
                       TextView txt8 = (TextView) findViewById(R.id.bp);
                       //TextView txt9 = (TextView) findViewById(R.id.dev_id1);
                       TextView txt10 = (TextView) findViewById(R.id.temp11);
                       TextView txt11 = (TextView) findViewById(R.id.alt_cal1);
                       TextView txt12 = (TextView) findViewById(R.id.alt_real1);
                       TextView txt14 = (TextView) findViewById(R.id.pressure1);
                       TextView txt15 = (TextView) findViewById(R.id.hb1);
                       TextView txt16 = (TextView) findViewById(R.id.bp1);


                       s1 = new GetJson().AsString(a[0]);
                       //s1="[[2]]";
                       s2 = new GetJson().AsString(a[8]);
                       s3 = new GetJson().AsString(a[2]);
                       s4 = new GetJson().AsString(a[3]);
                       s5 = new GetJson().AsString(a[4]);
                       s6 = new GetJson().AsString(a[5]);
                       s7 = new GetJson().AsString(a[6]);
                       s8 = new GetJson().AsString(a[7]);
                       h1 = s1.substring(2, s1.length() - 2);
                       h2 = s2.substring(2, s2.length() - 2);
                       h3 = s3.substring(2, s3.length() - 2);
                       h4 = s4.substring(2, s4.length() - 2);
                       h5 = s5.substring(2, s5.length() - 2);
                       h6 = s6.substring(2, s6.length() - 2);
                       h7 = s7.substring(2, s7.length() - 2);
                       h8 = s8.substring(2, s8.length() - 2);
                       txt1.setText(h7);
                       txt2.setText(h3);
                       txt3.setText(h4);
                       txt4.setText(h5);
                       txt5.setText(h2);
                       txt6.setText(h6);
                       txt7.setText(h1);
                       txt8.setText(h8);

                    /*t1 = new GetJson().AsString(b[0]);
                    t2 = new GetJson().AsString(b[1]);
                    t3 = new GetJson().AsString(b[2]);
                    t4 = new GetJson().AsString(b[3]);
                    t5 = new GetJson().AsString(b[4]);
                    t6 = new GetJson().AsString(b[5]);
                    j1 = t1.substring(2, t1.length() - 2);
                    j2 = t2.substring(2, t2.length() - 2);
                    j3 = t3.substring(2, t3.length() - 2);
                    j4 = t4.substring(2, t4.length() - 2);
                    j5 = t5.substring(2, t5.length() - 2);
                    j6 = t6.substring(2, t5.length() - 4);

                    //j7 = s7.substring(2, t7.length() - 2);
                    // j8 = s8.substring(2, t8.length() - 2);

                    txt10.setText(j2);
                    txt11.setText(j3);
                    txt12.setText(j4);
                    txt14.setText(j5);
                    txt15.setText(j1);
                    txt16.setText(j6);*/
                    sleep(1000);
                   }
               } catch (InterruptedException e){
                   e.printStackTrace();
               } catch (ExecutionException ex) {
                   ex.printStackTrace();
               }
           }
       };
       thread.start();



    }





       /* String url_id = "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1";
        String url_tmp1 = "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1";
        String url_tmp2 = "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1";
        String url_altc = "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1";
        String url_altr = "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1";
        String url_pre = "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1";
        String url_hb = "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1";
        String url_bp = "http://blynk-cloud.com/POXbCBzJPIIea6mcj87aFSZxtsdc8FEY/get/V1";*/




}





