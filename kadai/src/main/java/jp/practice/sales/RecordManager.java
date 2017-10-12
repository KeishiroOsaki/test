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

    //直接名前取ろうとおもった
	public static String getItemListaa(){
		String itemname = null;
		for(int i = 0 ; i < list.size(); i++){
			itemname = list.get(i).getName();
			System.out.println(itemname);
		}
		return itemname;
	}

	public static List<Item> getItemList(){
		for(int i = 0 ; i < list.size(); i++){
			System.out.print(list.get(i));

		}
		return list;
    }

    /** 指定された名前の商品のインスタンスを新規に生成 */ //例外ハンドリングつけた20171005
    public static Item getItemOf(String name) {

		//俺という存在が、forで回そうとした遺志を引き継ぐのだ
    			try{
					Item gotItem;
					
					for (Item item : list) {
						if (item.getName().equals(name)) {
							gotItem = item;
							break;
						}
					}
					if (gotItem == null) {
						gotItem = new Item(null,null,0,0,0);
					}
    				return new Item(gotItem.getId(), gotItem.getName(), gotItem.getPrice(), 0, 0);
    			}catch(Exception e){
    				return new Item(null,null,0,0,0);
				}
				return new Item(gotItem.getId(), gotItem.getName(), gotItem.getPrice(), 0, 0);
    			/*Item gotItem;
    			for(int i = 0; i <= list.size(); i++){
    				list.getName().equals(name).findFirst().get();
    			} ＊これはforで回そうとした残骸*/


    }


    /** 削除フラグがtrueのアイテムを削除 */
    public static void deleteItem(List<Item> recordList) {
        for (Item record : recordList){
        	//ヒットしたら削除
        	if (record.getRemoveFlg() == true) {
        		recordList.remove(record);
        		break;
        	}
        }
    }


	/** List<Item>をList<String>に変換するメソッド */
	public static List<String> getItemListStr() {
		List<String> itemNameList = new ArrayList<String>();
		for (Item item : list) {
			itemNameList.add(item.getName());
		}
		return itemNameList;
	}

}
//Copyright 2015 FUJITSU APPLICATIONS LIMITED
