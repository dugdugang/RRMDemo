package com.test.rrmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.test.rrmdemo.utils.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        retrofitTest();
        RxBus.getInstance().subscribe(String.class, new Consumer<String>() {

            @Override
            public void accept(String s) throws Exception {
                Toast.makeText(MainActivity.this, "" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void retrofitTest() {
//        Subscription subscription= NetService.getNetApi()
//                .getBook("金瓶梅", null, "0", 1)
//                .subscribeOn(Schedulers.io())
//        Call<Book> call = NetService.getNetApi().getBook("金瓶梅", null, "0", 1);
//        call.enqueue(new Callback<Book>() {
//            @Override
//            public void onResponse(Call<Book> call, Response<Book> response) {
//                result.setText(response.body().toString() + "");
//            }
//
//            @Override
//            public void onFailure(Call<Book> call, Throwable t) {
//
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unSubcribe();
    }

    public void test(View view) {
        RxBus.getInstance().send("sss");

    }
}
