package ouc.cs.oceanfish.service;

import ouc.cs.oceanfish.dao.GoodsDao;
import ouc.cs.oceanfish.po.Goods;



public class AdminService {
    private GoodsDao goodsDao = new GoodsDao();

    public void pass(boolean pass,Goods goods){
        if(pass){
            goods.setSoldStatus("passed");
            goodsDao.updateGoods(goods.getId(),goods);
        }else{
            goodsDao.deleteGoods(goods.getId());
        }
    }


}
