package entity;

import java.util.Date;

/**
 * Created by zzy on 2017/9/14.
 */
public class NiuZa{
    //商品名称
    private String productname;
    //商品价格
    private double price;
    //商品购买链接
    private String buylink;
    //优惠券链接
    private String couponlink;
    //插入时间
    private Date insertdate;

    //更新时间
    private Date updatedate;

    @Override
    public String toString() {
        return "NiuZa{" +
                "productname='" + productname + '\'' +
                ", price=" + price +
                ", buylink='" + buylink + '\'' +
                ", couponlink='" + couponlink + '\'' +
                ", insertdate=" + insertdate +
                ", updatedate=" + updatedate +
                '}';
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getProductname() {
        return productname;
    }

    public String getBuylink() {
        return buylink;
    }

    public void setBuylink(String buylink) {
        this.buylink = buylink;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getCouponlink() {
        return couponlink;
    }

    public void setCouponlink(String couponlink) {
        this.couponlink = couponlink;
    }
}
