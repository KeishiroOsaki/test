package jp.practice.sales;

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
	private static final String LIST = "list";


	//文言
	private static final String ADD_SUCCESS_MSG = "明細に追加しました";
	private static final String ADD_ERROR_MSG = "点数には1以上の数字を入力してください。";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/start")
	public String init(SalesForm form,Model model) {
		List<String> list = RecordManager.getItemListStr();
		model.addAttribute("ItemList",list);
		return INIT;
	}



	@RequestMapping(params = "add") //addに遷移しない。。
	public String add(Model model){
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



}
