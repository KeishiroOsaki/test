package jp.practice.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/system")
public class SalesSystemController {

	private static final String INIT = "init";
	private static final String ADD = "add";
	private static final String FIX = "fix";


	//明細に追加する
    private static List<Item> recordList = new ArrayList<>();


	//文言
	private static final String ADD_SUCCESS_MSG = "明細に追加しました";
	private static final String ADD_ERROR_MSG = "点数には1以上の数字を入力してください。";
	private static final String FIX_MSG = "以下のように売上登録しました。";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/start")
	public String init(SalesForm form,Model model) {
		List<String> list = RecordManager.getItemListStr();
		model.addAttribute("ItemList",list);
		return INIT;
	}



	@RequestMapping(params = "add")
	public String add(Model model){
		/*
		List<String> id = RecordManager.getItemListStr()；
		model.addAttribute("recordList", id);
		model.addAttribute("recordList",price);
		model.addAllAttributes("recordList",quantity);
		model.addAllAttributes("recordList",sum);Listに追加していきたい。。。*/
		return ADD;
	}



	@RequestMapping(params = "list")
	public String list(Model model){
		List<Item> list = RecordManager.getItemList();
		model.addAttribute("ItemList",list);
		return LIST;
	}




	/*@RequestMapping(params = "meisaiadd")
	public String add(SalesForm form,Model model) {
		model.addAttribute("s_message",ADD_SUCCESS_MSG);
		model.addAttribute("e_message",ADD_ERROR_MSG);
		return ADD;
	}*/

	@RequestMapping(params = "fix")
	public String fix(Model model){
		return FIX;
	}

	@RequestMapping(params = "init")
	public String syuryo(SalesForm form,Model model){
		List<String> list = RecordManager.getItemListStr();
		model.addAttribute("ItemList",list);
		return INIT;
	}

}
