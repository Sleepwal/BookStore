package com.me.domain;

public class Sales {
    private String name;
    private int buynum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    /*public List<Sales> search(String year, String month)
    {
        String sql = "SELECT products.name,SUM(orderitem.buynum) totalsalnum "
                + "FROM orders,products,orderItem "
                + "WHERE orders.id=orderItem.order_id "
                + "AND products.id=orderItem.product_id AND orders.paystate=1 "
                + "AND year(ordertime)= "+year+" and month(ordertime)="+month+" "
                + "GROUP BY products.name ORDER BY totalsalnum DESC";
        ResultSet rs = null;
        List<Sales> ps = new ArrayList<Sales>();

        *//*连接数据库进行多表条件查询，获得查询产品的名称及其销售数量（从高到低排序）结果集rs；*//*
        *//*循环遍历结果集，设置sales属性；（类似实验11中的searchAll方法）
        将sales添加到ps销售数量列表中；*//*
        try {
            rs = DbUtil.executeQuery(sql);
            while (rs.next()) {
                Sales sales = new Sales();
                sales.setName(rs.getString(1));
                sales.setBuynum(rs.getInt(2));

                ps.add(sales);
            }

            rs.close();
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;  *//*返回ps*//*
    }*/

}
