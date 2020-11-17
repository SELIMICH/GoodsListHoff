package com.example.goodslisthoff.screens.hoffgoodsactivity;

import com.example.goodslisthoff.model.GoodsInfo;
import com.example.goodslisthoff.service.CouchesService;
import com.example.goodslisthoff.service.RetrofitInstance;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HoffGoodsListPresenter {
    private final HoffGoodsListView mView;

    public HoffGoodsListPresenter(HoffGoodsListView view) {
        mView = view;
    }

   public void loadData() {

        CouchesService couchesService = RetrofitInstance.getService();
        couchesService.getCouches()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<GoodsInfo>() {
                    @Override
                    public void onSuccess(@NonNull GoodsInfo goodsInfo) {
                        mView.showData(goodsInfo.getCouches());
//                       Log.d("example", goodsInfo.getCouches().toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.showError(e);
                    }
                });

    }

}
