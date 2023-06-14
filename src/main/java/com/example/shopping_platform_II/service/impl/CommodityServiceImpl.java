package com.example.shopping_platform_II.service.impl;

import com.example.shopping_platform_II.Util.Base64ToImage;
import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.entity.User;
import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.repository.UserDao;
import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;

import static com.example.shopping_platform_II.Util.Base64ToImage.Base64ToImg;


@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private UserDao userDao;

    @Override
    public AddCommodityResponse addCommodity(HttpSession session, AddCommodityRequest request) {

		/*
		 * 帳號密碼檢查
		 */
		String account = (String) session.getAttribute("account");
		
		String pwd = (String) session.getAttribute("pwd");
		
		String accountSell = (String) session.getAttribute("account");

		List<Commodity> goods = request.getReqCommodity();
		
		//----------------------------------------------------------------
		
		// 數據集合空值防呆
		if(CollectionUtils.isEmpty(goods)) {

			// RtnCode回傳錯誤
			return new AddCommodityResponse(RtnCode.CONTENT_EMPTY.getMessage());
		}
		
		// 登錄檢測
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			
			return new AddCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());

		}
		
//		List<Commodity> sqlGoods = commodityDao.findAll();
		
		
		// 上架前確認: 資料漏填, 與資料庫重複商品(確認number)
		for(Commodity item: goods) {
			
			if(item.getNumber() <= 0 || !StringUtils.hasText(item.getName()) || 
					!StringUtils.hasText(item.getCategory())||item.getInventory() <= 0||
					item.getPrice() <= 0 || !StringUtils.hasText(item.getAccountSell())) {
				
				return new AddCommodityResponse(RtnCode.CONTENT_EMPTY.getMessage());
			}
			

			
			/*
			 *  檢查現在商品架上是否有重複的編號
			 */
			Optional<Commodity> resNum = commodityDao.findById(item.getNumber());
			
			// 有結果: 找到重複編號
			if(resNum.isPresent() == true) {
				
				// 報錯(編號重複)
				return new AddCommodityResponse(RtnCode.NUMBER_ERROR.getMessage());
			}
			
//		 int result = commodityDao.addCommodityWhereNotExists(goods, accountSell);
//	        if (result == 0) {
//	            return new addCommodityResponse(RtnCode.DATA_DUPLICATE.getMessage());
//	        }
			
			
		}
		
		commodityDao.saveAll(goods);
		return new AddCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}
    	
    @Override
    public DeleteCommodityResponse deleteCommodity(HttpSession session, DeleteCommodityRequest request) {
    	
    	
    	int number = request.getNumber();
    	
		
		String account = (String) session.getAttribute("account");
		
		String pwd = (String) session.getAttribute("pwd");

		
		//----------------------------------//
		
		/*
		 * 帳號密碼驗證
		 */
		if(StringUtils.hasText(account) || !StringUtils.hasText(pwd)){
			
			return new DeleteCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());

		}
		
		// 商品編號為空值
		if(number <= 0) {
			
			return new DeleteCommodityResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		
		// 去資料庫找對應的編號
		Optional<Commodity> resNum = commodityDao.findById(number);

		// 找不到對應的產品編號: 回傳"NOT_FOUND"
		if(resNum == null) {
			
			return new DeleteCommodityResponse(RtnCode.NOT_FOUND.getMessage());
		}
		
		// 不能刪別人的商品
		if(!resNum.get().getAccountSell().equals(account)) {
			
			return new DeleteCommodityResponse(RtnCode.DELETE_OTHER_USER.getMessage());

		}
		

		
		// 刪除產品編號
		commodityDao.deleteById(number);
		
		return new DeleteCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}
    	

	@Override
	public UpdateCommodityResponse updateNameByNumber(HttpSession session, UpdateCommodityRequest request) {// todo
		// 名字要符合正規
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		String newName = request.getName();
		int commodityNumber = request.getCommodityNumber();

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UpdateCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		// todo (有需要嗎?)先看商品是否存在 有存在再改 沒存在就不改 done
		int result = commodityDao.updateNameByNumber(newName, commodityNumber);
		if (result == 0) {
			return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		return new UpdateCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UpdateCommodityResponse updateCategoryByNumber(HttpSession session, UpdateCommodityRequest request) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		String newCategory = request.getCategory();
		int commodityNumber = request.getCommodityNumber();

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UpdateCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		if (!StringUtils.hasText(newCategory)) {
			return new UpdateCommodityResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		int result = commodityDao.updateCategoryByNumber(newCategory, commodityNumber);
		if (result == 0) {
			return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		return new UpdateCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UpdateCommodityResponse updateInventoryByNumber(HttpSession session, UpdateCommodityRequest request) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		int newInventory = request.getInventory();
		int commodityNumber = request.getCommodityNumber();

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UpdateCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		if (newInventory < 0) {
			return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		int result = commodityDao.updateInventoryByNumber(newInventory, commodityNumber);
		if (result == 0) {
			return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		return new UpdateCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public UpdateCommodityResponse updatePriceByNumber(HttpSession session, UpdateCommodityRequest request) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		int newPrice = request.getPrice();
		int commodityNumber = request.getCommodityNumber();

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UpdateCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		if (newPrice < 0) {
			return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		int result = commodityDao.updatePriceByNumber(newPrice, commodityNumber);
		if (result == 0) {
			return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		return new UpdateCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public SearchCommodityResponse searchCommodityByName(SearchCommodityRequest request) {

		String name = request.getName();

		if (!StringUtils.hasText(name)) {
			return new SearchCommodityResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		List<Commodity> result = commodityDao.findByName(name);
		if (CollectionUtils.isEmpty(result)) {
			return new SearchCommodityResponse(RtnCode.NOT_FOUND.getMessage());
		}

		return new SearchCommodityResponse(RtnCode.SUCCESSFUL.getMessage(), result);
	}

	@Override
	public SearchCommodityResponse searchCommodityByCategory(HttpSession session, SearchCommodityRequest request) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		String category = request.getCategory();
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new SearchCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		if (!StringUtils.hasText(category)) {
			return new SearchCommodityResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		List<Commodity> result = commodityDao.findByCategory(category);
		if (CollectionUtils.isEmpty(result)) {
			return new SearchCommodityResponse(RtnCode.NOT_FOUND.getMessage());
		}

		return new SearchCommodityResponse(RtnCode.SUCCESSFUL.getMessage(), result);
	}

	@Override
	public DistinctSearchResponse distinctSearchCommodityByName(HttpSession session, SearchCommodityRequest request) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		String name = request.getName();
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new DistinctSearchResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		if (!StringUtils.hasText(name)) {
			return new DistinctSearchResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		List<DistinctSearchResponse> result = commodityDao.distinctSearchByName(name);
		if (CollectionUtils.isEmpty(result)) {
			return new DistinctSearchResponse(RtnCode.NOT_FOUND.getMessage());
		}
		return new DistinctSearchResponse(result, RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public DistinctSearchResponse distinctSearchCommodityByCategory(HttpSession session,SearchCommodityRequest request) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		String category = request.getCategory();
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new DistinctSearchResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		if (!StringUtils.hasText(category)) {
			return new DistinctSearchResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		List<DistinctSearchResponse> result = commodityDao.distinctSearchByName(category);
		if (CollectionUtils.isEmpty(result)) {
			return new DistinctSearchResponse(RtnCode.NOT_FOUND.getMessage());
		}
		return new DistinctSearchResponse(result, RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public GetCommodityInfo findCommodityForManage(HttpSession session) {
		String accountSell = (String) session.getAttribute("account");
		if (!StringUtils.hasText(accountSell)) {
			return new GetCommodityInfo(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		List<Commodity> res = commodityDao.findByAccountSell(accountSell);
		if (res == null) {
			return new GetCommodityInfo(RtnCode.NOT_FOUND.getMessage());
		}

		return new GetCommodityInfo(RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@Override
	public SearchCommodityResponse searchCommodityById(HttpSession session, SearchCommodityRequest request) {
		int number = request.getNumber();
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new SearchCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		Optional<Commodity> op = commodityDao.findById(number);
		if (op.get() == null) {
			return new SearchCommodityResponse(RtnCode.NOT_FOUND.getMessage());
		}

		return new SearchCommodityResponse(RtnCode.SUCCESSFUL.getMessage(), op.get());

	}


	@Override
	public DistinctSearchResponse distinctSearchCommodityByNameOrCategory(HttpSession session, SearchCommodityRequest request) {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");
		String keyword = request.getKeyword();
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new DistinctSearchResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		if (!StringUtils.hasText(keyword)) {
			return new DistinctSearchResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		List<DistinctSearchResponse> result = commodityDao.distinctSearchByName(keyword);
		if (CollectionUtils.isEmpty(result)) {
			return new DistinctSearchResponse(RtnCode.NOT_FOUND.getMessage());
		}
		return new DistinctSearchResponse(result, RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public AddCommodityResponse addImage(HttpSession session, AddImageRequest request) throws IOException {
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("pwd");

		int commodityNumber = request.getCommodityNumber();
		String img = request.getImg();

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AddCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}
		if (commodityNumber < 0) {
			return new AddCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		if (!StringUtils.hasText(img)){
			return new AddCommodityResponse(RtnCode.CANNOT_EMPTY.getMessage());//檔案上傳失敗 之類的
		}
		//抓到上傳的圖片的 uuid  => uuid直接會是圖片的檔名
		String imgFilePath = Base64ToImg(img);
		//以對應的商品代碼 抓到商品欄位以存取 imgFilePath進去
		Optional<Commodity> result = commodityDao.findById(commodityNumber);
		if (!result.isPresent()) {
			return new AddCommodityResponse(RtnCode.NOT_FOUND.getMessage());//沒有這個商品
		}
		//確認是不是自己的商品  =>不能存到別人的防呆
		if (!result.get().getAccountSell().equals(account)) {
			return new AddCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		int updateResult = commodityDao.updateImgPathByNumber(imgFilePath, commodityNumber);

		if (updateResult == 0) {
			return new AddCommodityResponse(RtnCode.DATA_ERROR.getMessage());
		}
		return new AddCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}
}
