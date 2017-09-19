package com.test.rrmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxjavaActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        test0();
    }

    private void test0() {
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                Log.i("M-TAG", "send " + 1);
//                e.onNext(1);
//                Log.i("M-TAG", "send " + 2);
//                e.onNext(2);
//                Log.i("M-TAG", "send " + 3);
//                e.onNext(3);
//                Log.i("M-TAG", "send " + 4);
//                e.onNext(4);
//                Log.i("M-TAG", "send complete ");
//                e.onComplete();
//                Log.i("M-TAG", "send " + 5);
//                e.onNext(5);
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.i("M-TAG", "onSubscribe" + d.isDisposed());
//                        disposable = d;
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Integer integer) {
//                        Log.i("M-TAG", "receive " + integer);
////                        if (integer == 2) {
////                            disposable.dispose();
////                        }
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.i("M-TAG", "err");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.i("M-TAG", "receive complete");
//                    }
//                });
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//
//            }
//        }).map(new Function<Integer, String>() {
//            @Override
//            public String apply(@NonNull Integer integer) throws Exception {
//                return "integer+1=" +
//                        "" + integer + 1 + "";
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i("M-TAG", "" + s);
//            }
//        });

        //zip合并事件

//        Observable.zip(getIntegerObservable(), getIStringObservable(), new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(@NonNull Integer integer, @NonNull String s) throws Exception {
//                return s + integer;
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i("M-TAG", "receive " + s);
//            }
//        });
//        //Concat对于单一的把两个发射器连接成一个发射器，虽然 zip 不能完成，但我们还是可以自力更生，官方提供的 concat 让我们的问题得到了完美解决。
//        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.i("M-TAG", "" + integer);
//                    }
//                });
        //FlatMap
        //concatMap 与 FlatMap 的唯一区别就是 concatMap 保证了顺序
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                e.onNext(2);
//                e.onNext(3);
//            }
//        }).concatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
//                ArrayList<String> list = new ArrayList<String>();
//                for (int i = 0; i < 3; i++) {
//                    list.add("I am value "+integer);
//                }
//                int delay= (int) (Math.random()*10+1);
//                return Observable.fromIterable(list).delay(delay, TimeUnit.MILLISECONDS);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i("M-TAG",""+s);
//            }
//        });
//        //distinct去重
//        Observable.just(1, 1, 12, 1, 5, 8)
//                .distinct()
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.i("M-TAG", "" + integer);
//                    }
//                });
//        //Filter 过滤
//        Observable.just(-1, -2, -10, 6, 9, 20)
//                .filter(new AppendOnlyLinkedArrayList.NonThrowingPredicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        return integer > 8;
//                    }
//                }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.i("M-TAG", "" + integer);
//            }
//        });
        //bufferbuffer 操作符接受两个参数，buffer(count,skip)，作用是将 Observable 中的数据按 skip (步长) 分成最大不超过 count 的 buffer ，然后生成一个  Observable
//    Observable.just(1,2,3,4,5)
//            .buffer(3,2)
//            .subscribe(new Consumer<List<Integer>>() {
//                @Override
//                public void accept(List<Integer> integers) throws Exception {
//                    Log.i("M-TAG","values size: "+integers.size());
//                    for (Integer integer:integers){
//                        Log.i("M-TAG","value "+integer);
//                    }
//                }
//            });
        //timer timer 相当于一个定时任务
//        Log.i("M-TAG",""+ format(System.currentTimeMillis()+""));
//        Observable.timer(2, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.i("M-TAG",""+ format(System.currentTimeMillis()+""));
//
//                    }
//                });
//        /
        // interval 操作符用于间隔时间执行某个操作
//        Log.i("M-TAG", "" + format(System.currentTimeMillis() + ""));
//
//        Disposable disposable = Observable.interval(3, 2, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.i("M-TAG", "" + format(System.currentTimeMillis() + ""));
//
//                    }
//                });
//        //doOnNext
//        Observable.just(1, 2, 3, 4)
//                .doOnNext(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.i("M-TAG", "save " + integer);
//                    }
//                }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.i("M-TAG", "" + integer);
//            }
//        });
//        //skip
//        Observable.just(1, 2, 3, 4, 5)
//                .skip(2)
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.i("M-TAG", "" + integer);
//                    }
//                });
//        //take，接受一个 long 型参数 count ，代表至多接收 count 个数据。
//        Flowable.fromArray(1,2,3,4,5)
//                .take(2)
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                    Log.i("M-TAG",""+integer);
//                    }
//                });
//        // Single 只会接收一个参数
//        Single.just(new Random().nextInt())
//                .subscribe(new SingleObserver<Integer>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(@NonNull Integer integer) {
//                        Log.i("M-TAG", "onSuccess" + integer);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.i("M-TAG", "onError " + e.toString());
//
//                    }
//                });
        //distinct 去重操作符，简单的作用就是去重。
        //  debounce 去除发送频率过快的项
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(1);
//                Thread.sleep(400);
//                e.onNext(2);
//                Thread.sleep(505);
//                e.onNext(3);
//                Thread.sleep(100);
//                e.onNext(4);
//                Thread.sleep(605);
//                e.onNext(5);
//                Thread.sleep(510);
//                e.onComplete();
//
//            }
//        }).debounce(500, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.i("M-TAG", "" + integer);
//                    }
//                });
//        //defer简单地时候就是每次订阅都会创建一个新的 Observable，并且如果没有被订阅，就不会产生新的 Observable。
//        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
//            @Override
//            public ObservableSource<? extends Integer> call() throws Exception {
//                return Observable.just(1, 2, 3);
//            }
//        });
//        observable.subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Log.i("M-TAG", "" + integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.i("M-TAG", "err");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i("M-TAG", "complete");
//            }
//        });
//        //last 操作符仅取出可观察到的最后一个值，或者是满足某些条件的最后一项。
//        Observable.just(1, 2, 3)
//                .last(2)
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.i("M-TAG", "" + integer);
//                    }
//                });
//        //merge 的作用是把多个 Observable 结合起来
//        Observable.merge(Observable.just(1, 2), Observable.just(3, 4, 5))
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.i("M-TAG", "" + integer);
//                    }
//                });
//        //reduce 操作符每次用一个方法处理一个值，可以有一个 seed 作为初始值
//        Observable.just(1, 2, 3)
//                .reduce(new BiFunction<Integer, Integer, Integer>() {
//                    @Override
//                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
//                        return integer + integer2;
//                    }
//                }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.i("M-TAG", "" + integer);
//            }
//        });
//        //scan 操作符作用和上面的 reduce 一致，唯一区别是 reduce 是个只追求结果的坏人，而  scan 会始终如一地把每一个步骤都输出。
//        Observable.just(1, 2, 3)
//                .scan(new BiFunction<Integer, Integer, Integer>() {
//                    @Override
//                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
//                        return integer + integer2;
//                    }
//                }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.i("M-TAG", "" + integer);
//            }
//        });
        //window按照实际划分窗口，将数据发送给不同的 Observable
        Observable.interval(1, TimeUnit.SECONDS)
                .take(15)
                .window(3,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Observable<Long>>() {
                    @Override
                    public void accept(Observable<Long> longObservable) throws Exception {
                        longObservable.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Long>() {
                                    @Override
                                    public void accept(Long aLong) throws Exception {
                                            Log.i("M-TAG",""+aLong);
                                    }
                                });
                    }
                });
    }

    public static String format(String value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(Long.valueOf(value));
    }

    private Observable<Integer> getIntegerObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                Log.e("M-TAG", "send " + 1);
                e.onNext(2);
                Log.e("M-TAG", "send " + 2);
                e.onNext(3);
                Log.e("M-TAG", "send " + 3);

            }
        });
    }

    private Observable<String> getIStringObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("A");
                Log.e("M-TAG", "send " + "A");
                e.onNext("B");
                Log.e("M-TAG", "send " + "B");
                e.onNext("C");
                Log.e("M-TAG", "send " + "C");
                e.onNext("D");
                Log.e("M-TAG", "send " + "D");
                e.onNext("E");
                Log.e("M-TAG", "send " + "E");

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
