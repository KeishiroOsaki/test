package jp.practice.sales;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品データ全体を保持するクラス
 */
public final class RecordManager {

    /** 商品データ */
    private static List<Item> list = new ArrayList<>();
    static {
        list.add(new Item("A00101", "油性ボールペン", 60, 0, 0));
        list.add(new Item("A00201", "極細ボールペン", 120, 0, 0));
        list.add(new Item("A00301", "蛍光ペン６色セット", 420, 0, 0));
        list.add(new Item("A00401", "シャープペンシル", 100, 0, 0));
        list.add(new Item("A00501", "鉛筆H（１ダース）", 400, 0, 0));
        list.add(new Item("B00101", "無線綴ノートA4", 100, 0, 0));
        list.add(new Item("B00201", "リングノートA4", 120, 0, 0));
        list.add(new Item("B00301", "領収書", 350, 0, 0));
        list.add(new Item("C00101", "はさみ（青）", 128, 0, 0));
        list.add(new Item("C00201", "ステープラー", 338, 0, 0));
        list.add(new Item("C00301", "２穴パンチ", 128, 0, 0));
        list.add(new Item("C00401", "ゼムクリップ", 98, 0, 0));
        list.add(new Item("C00501", "消しゴム", 58, 0, 0));
    }


    private RecordManager(){
    }

    /*　指定した名前のレコードを取得
     *
     * @ param name 商品名
     * @ return Item
     */
  //  public static Item selectItem(String name){

//    }

	public static List<Item> getItemList(){
		for(int i = 0 ; i < list.size(); i++){
			System.out.print(list.get(i));

		}
		return list;
	}

    /** レコードのリスト */
    private static List<Item> recordList = new ArrayList<>();

    public List<Item> getRecordList() {
        return recordList;
    }
    public void setRecordList(List<Item> recordList) {
        this.recordList = recordList;
    }
}
//Copyright 2015 FUJITSU APPLICATIONS LIMITED
