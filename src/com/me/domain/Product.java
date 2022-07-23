package com.me.domain;

public class Product {
    private String id;
    private String name;
    private double price;
    private String category;
    private int pnum;
    private String imgurl;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
  /*  public List<Product> searchAll(){
        DataSource dataSource = JDBCUtil.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from products";
        List<Product> productList;
        productList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Product>(Product.class));

        return productList;
    }*/

   /* public List<Product> searchAll(){
        List<Product> ps = new ArrayList<Product>();

        String SQLStr = "select * from products";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = DbUtil.executePreparedStatement(SQLStr);
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setCategory(rs.getString(4));
                p.setPnum(rs.getInt(5));
                p.setImgurl(rs.getString(6));
                p.setDescription(rs.getString(7));

                ps.add(p);
            }

            rs.close();
            pst.close();
            DbUtil.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return ps;
    }*/

    /*public boolean add(Product product){
        String id = UUID.randomUUID().toString();
        String name = product.getName();
        double price= product.getPrice();
        String category= product.getCategory();
        int pnum = product.getPnum();
        String imgurl = product.getImgurl();
        String description = product.getDescription();

        String SQLStr = "insert into products values(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = DbUtil.executePreparedStatement(SQLStr);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setDouble(3,price);
            ps.setString(4,category);
            ps.setInt(5,pnum);
            ps.setString(6,imgurl);
            ps.setString(7,description);

            if(ps.executeUpdate() != 0){
                DbUtil.close();
                return true;
            }

            ps.close();
            DbUtil.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }*/

    /*public boolean delete(String id){
        String SQLStr = "delete from products where id = '" + id + "'";
        if(DbUtil.executeUpdate(SQLStr) >= 1)
            return true;
        DbUtil.close();

        return false;
    }*/

    /*public Product search(String id){
        String SQLStr = "select * from products where id = '" + id + "'";
        ResultSet rs = DbUtil.executeQuery(SQLStr);
        Product p;

        try {
            if(rs.next()) {
                p = new Product();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setCategory(rs.getString(4));
                p.setPnum(rs.getInt(5));
                p.setImgurl(rs.getString(6));
                p.setDescription(rs.getString(7));
                return p;
            }

            rs.close();
            DbUtil.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }*/

    /*public boolean update(Product product){
        String id = product.getId();
        delete(id);

        String name = product.getName();
        double price= product.getPrice();
        String category= product.getCategory();
        int pnum = product.getPnum();
        String imgurl = product.getImgurl();
        String description = product.getDescription();

        String SQLStr = "insert into products values(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = DbUtil.executePreparedStatement(SQLStr);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setDouble(3,price);
            ps.setString(4,category);
            ps.setInt(5,pnum);
            ps.setString(6,imgurl);
            ps.setString(7,description);

            if(ps.executeUpdate() != 0){
                DbUtil.close();
                return true;
            }

            ps.close();
            DbUtil.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }*/

