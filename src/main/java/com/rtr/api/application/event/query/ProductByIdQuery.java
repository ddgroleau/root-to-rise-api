package com.rtr.api.application.event.query;

public class ProductByIdQuery implements Query{
    private int productId;

    public ProductByIdQuery(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
