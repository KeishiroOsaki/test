package jp.practice.sales;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	private static final String DELETE = "delete";
	// private static final String LIST = "LIST";

	// 明細に追加する
	// private static List<Item> recordList = new ArrayList<Item>();

	@Autowired
	HttpSession session;

	// 文言
	private static final String ADD_SUCCESS_MSG = "明細に追加しました";
	private static final String ADD_ERROR_MSG = "点数には1以上の数字を入力してください。";
	private static final String FIX_MSG = "以下のように売上登録しました。";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/start")
	public String init(SalesForm form, Model model) {
		List<String> list = RecordManager.getItemListStr();
		model.addAttribute("ItemList", list);
		return INIT;
	}

	@RequestMapping(params = "/add")
	public String add(SalesForm form, Model model) {
		// List<String> meisaiList = RecordManager.setItemList();
		/*
		 * model.addAttribute("name",form.getName()); //商品名
		 * model.addAttribute("quantity",form.getQuantity());//個数
		 */

		/* List<String> recordList = new ArrayList<String>(); */
		// recordList.add(form.getName(),form.getQuantity());

		// セッションからレコードリストを取り出し
		List<Item> recordList = (List<Item>) session.getAttribute("recordList");

		// Itemを格納
		Item tmpItem = RecordManager.getItemOf(form.getName());

		// getItemOfで例外処理してインスタンスにnullが入ってたら何もしないでほしいい20171005
		if (tmpItem.getName() == null) {

		} else {
			// ここまで

			tmpItem.setQuantity(form.getQuantity());
			tmpItem.setSubtotal(tmpItem.getPrice() * tmpItem.getQuantity());
			recordList.add(tmpItem);

			// レコードリストをセッションに格納
			// session.addAttribute("recordList",recordList);
			session.setAttribute("recordList", recordList);
		}

		return ADD;
	}

	/*
	 * private void If(boolean b) { // TODO 自動生成されたメソッド・スタブ
	 *
	 * }
	 */

	/*
	 * @RequestMapping(params = "/list") public String list(Model model){
	 * List<Item> list = RecordManager.getItemList();
	 * model.addAttribute("ItemList",list); return LIST; }
	 */

	/*
	 * @RequestMapping(params = "meisaiadd") public String add(SalesForm
	 * form,Model model) { model.addAttribute("s_message",ADD_SUCCESS_MSG);
	 * model.addAttribute("e_message",ADD_ERROR_MSG); return ADD; }
	 */

	@RequestMapping(params = "/fix")
	public String fix(Model model) {
		return FIX;
	}

	@RequestMapping(params = "/delete")
	public String delete(Model model) {
		// セッションからレコードリストを取り出し
		List<Item> recordList = (List<Item>) session.getAttribute("recordList");

		RecordManager.deleteItem(recordList);

		// レコードリストをセッションに格納
		session.setAttribute("recordList", recordList);

		return DELETE;
	}

	/*
	 * @RequestMapping(params = "/init") public String syuryo(SalesForm
	 * form,Model model){ List<String> list = RecordManager.getItemListStr();
	 * model.addAttribute("ItemList",list);
	 *
	 * //空のレコードリストをセッションに格納 List<Item> recordList = new ArrayList<Item>();
	 * session.setAttribute("recordList",recordList);
	 *
	 *
	 * return INIT; }
	 */

}
