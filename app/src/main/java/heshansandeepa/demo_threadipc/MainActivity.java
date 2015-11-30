package heshansandeepa.demo_threadipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        final MyClass myClass = new MyClass();
        myClass.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClass.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("Heshan", Thread.currentThread().getName());
                    }
                });
            }
        });
    }

    class MyClass extends Thread {
        Handler handler;
        public MyClass() {

        }

        @Override
        public void run() {
            super.run();
            //capable of accpeting mutiple messages, Message Queue
            Looper.prepare();
            handler = new Handler();
            //pick each message and handle them
            Looper.loop();

        }
    }

}
