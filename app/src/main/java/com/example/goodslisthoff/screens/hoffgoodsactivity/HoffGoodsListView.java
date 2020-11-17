package com.example.goodslisthoff.screens.hoffgoodsactivity;

import com.example.goodslisthoff.model.GoodsInfo;
import com.example.goodslisthoff.model.Items;

import java.util.List;

public interface HoffGoodsListView {
    void showData(List<Items> items);
    void showError(Throwable e);
}
