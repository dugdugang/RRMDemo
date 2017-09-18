package com.test.rrmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.test.rrmdemo.entities.Book;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxjavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        test0();
    }

    private void rxjavaTest() {
        //Observer 即观察者，它决定事件触发的时候将有怎样的行为
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        //除了 Observer 接口之外，RxJava 还内置了一个实现了 Observer 的抽象类：Subscriber。 Subscriber 对 Observer 接口进行了一些扩展，但他们的基本使用方式是完全一样的：
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }

//            @Override
//            public void onStart() {
//
//            }
        };
//        subscriber.isUnsubscribed();
//        subscriber.unsubscribe();
//Observable 即被观察者，它决定什么时候触发事件以及触发怎样的事件。 RxJava 使用 create() 方法来创建一个 Observable ，并为它定义事件触发规则：
        // Observable observable=Observable
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("I");
                subscriber.onNext("A");
                subscriber.onCompleted();
            }
        });
        Observable observable1 = Observable.just("1", "2");
        String s[] = {"A", "B"};
        Observable observable2 = Observable.from(s);
        observable.subscribe(observer);
        Action1 action1 = new Action1() {
            @Override
            public void call(Object o) {

            }
        };
        Action1 action11 = new Action1() {
            @Override
            public void call(Object o) {


            }
        };
        Action0 action0 = new Action0() {
            @Override
            public void call() {

            }
        };
        observable2.subscribe(action1, action11, action0);
    }

    private void test0() {
        final String s[] = {"A", "B", "C", "D"};
        Observable.from(s).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("M-TAG", "" + s);
            }
        });

        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {

                    }
                });

        Observable.just("123")
                .map(new Func1<String, Book>() {
                    @Override
                    public Book call(String s) {
                        return null;
                    }
                }).subscribe(new Action1<Book>() {
            @Override
            public void call(Book book) {

            }
        });
        String stduent[]={"A","B","C"};
        Subscriber<String > subscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        Observable.from(stduent)
                .flatMap(new Func1<String, Observable<String >>() {
                    @Override
                    public Observable<String > call(String s) {
                        return null;
                    }
                }).subscribe(subscriber);
//        Observable.create(new Observable.OnSubscribe<String >() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("a");
//            }
//        }).lift(new Observable.Operator<String , Integer>() {
//            @Override
//            public Subscriber<? super Integer> call(Subscriber<? super String> subscriber) {
//                return new Subscriber<Integer>() {
//                };
//            }
//        });
    }


}
