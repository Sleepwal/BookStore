package com.me.factory;

import com.me.dao.*;
import com.me.dao.impl.*;
import com.me.domain.AutoImg;

public class DaoFactory {
    public DaoFactory() { }

    public static UserDao getUserDAOInstance() { return new UserDaoImpl(); }
    public static OrderDao getOrderDAOInstance() {
        return new OrderDaoImpl();
    }
    public static OrderItemDao getOrderItemDAOInstance() { return new OrderItemDaoImpl(); }
    public static ProductDao getProductDAOInstance() {
        return new ProductDaoImp();
    }
    public static SalesDao getSalesDAOInstance() { return new SalesDaoImp(); }
    public static CartDao getCartDAOInstance() { return new CartDaoImp(); }
    public static NoticeDao getNoticeDAOInstance() { return new NoticeDaoImp(); }
    public static AutoImgDao getAutoImgDAOInstance() { return new AutoImgImp(); }

}
