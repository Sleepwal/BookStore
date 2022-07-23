package com.me.factory;

import com.me.service.*;
import com.me.service.impl.*;

public class ServiceFactory {
	public static IUserService getUserServicenstance() {
		return new UserServiceImpl();
	}
	public static IProductService getIProductServiceInstance(){ return new ProductServiceImpl(); }
	public static ICartService getCartServiceInstance() { return new CartServiceImp(); }
	public static INoticeService getNoticeServiceInstance() { return new NoticeServiceImpl(); }
	public static IAutoImgService getAutoImgServiceInstance() { return new AutoImgServiceImp(); }
	public static IOrderService getOrderServiceInstance() { return new OrderServiceImp(); }
	public static IOrderItemService getOrderItemServiceInstance() { return new OrderItemServiceImp(); }
	public static ISalesService getSalesServiceInstance() { return new SalesServiceImp(); }

}
