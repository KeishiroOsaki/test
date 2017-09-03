package jp.practice.sales;

/**
 * 売上明細1件分のデータを保持するクラス
 */
public class Item {

    /** 商品id */
    private String id;
    /** 商品名 */
    private String name;
    /** 単価 */
    private int price;
    /** 個数 */
    private int quantity;
    /** 小計 */
    private int subtotal;

    /**
	 * コンストラクターです。
     * @param id 商品id
     * @param name 商品名
     * @param price 単価
     * @param quantity 個数
     * @param subtotal 小計
     */
    public Item(String id, String name, int price, int quantity, int subtotal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

}
//Copyright 2015 FUJITSU APPLICATIONS LIMITED
