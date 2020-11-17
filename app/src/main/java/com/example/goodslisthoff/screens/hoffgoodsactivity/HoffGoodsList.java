package com.example.goodslisthoff.screens.hoffgoodsactivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodslisthoff.R;
import com.example.goodslisthoff.adapters.GoodsAdapter;
import com.example.goodslisthoff.model.GoodsInfo;
import com.example.goodslisthoff.model.Items;

import java.util.ArrayList;
import java.util.List;

public class HoffGoodsList extends AppCompatActivity implements HoffGoodsListView {
    private GoodsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoff_goods_list);
        HoffGoodsListPresenter mHoffGoodsListPresenter = new HoffGoodsListPresenter(this);
        RecyclerView mRecyclerViewGoods = findViewById(R.id.recycler_view_couches);
        mAdapter = new GoodsAdapter(new ArrayList<>());
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(HoffGoodsList.this, 2);
        mRecyclerViewGoods.setLayoutManager(layoutManager);
        mRecyclerViewGoods.setAdapter(mAdapter);
        mHoffGoodsListPresenter.loadData();
    }
    @Override
    public void showData(List<Items> items) {
        mAdapter = new GoodsAdapter(items);
        //mRecyclerViewGoods.setAdapter(mAdapter);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
    }

    }

