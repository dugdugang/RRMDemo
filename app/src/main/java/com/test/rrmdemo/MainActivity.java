package com.test.rrmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.test.rrmdemo.entities.Book;
import com.test.rrmdemo.net.NetService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        retrofitTest();
    }



    private void retrofitTest() {
//        Subscription subscription= NetService.getNetApi()
//                .getBook("金瓶梅", null, "0", 1)
//                .subscribeOn(Schedulers.io())
        Call<Book> call = NetService.getNetApi().getBook("金瓶梅", null, "0", 1);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                result.setText(response.body().toString() + "");
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
