package ouc.cs.oceanfish.service;

import ouc.cs.oceanfish.dao.GoodsDao;
import ouc.cs.oceanfish.po.Goods;

/**
 * AdminService class
 *
 * @author qinhao
 * @date 2019/12/10
 */

public class AdminService {
    private GoodsDao goodsDao = new GoodsDao();

    /**
     * addGoods
     * @param goods the goods that you want to be added
     * @return result
     */
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    /**
     * deleteGoods
     * @param id the id that the object has
     * @return result
     */
    public int deleteGoods(int id) {
        return goodsDao.deleteGoods(id);
    }

    /**
     * updatGoods
     * @param id the object that yo want to update has
     * @param goods the object
     * @return result
     */
    public int updateGoods(int id, Goods goods) {
        return goodsDao.updateGoods(id, goods);
    }

    /**
     * findGoodsById
     * @param id the object that yo want to find has
     * @return goodsDao.findGoodsById(id)
     */
    public Goods findGoodsById(int id) {
       return goodsDao.findGoodsById(id);
    }
}
