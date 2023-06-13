package com.example.shopping_platform_II.service.impl;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.entity.User;
import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.repository.UserDao;
import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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
    	
//        int number = (int) (Math.random() * 10000 + 1);
//        String name = request.getName();
//        String category = request.getCategory();
//        int inventory = request.getInventory();
//        int price = request.getPrice();
//        String accountSell = (String) session.getAttribute("account");
//
//        String account = (String) session.getAttribute("account");
//        String pwd = (String) session.getAttribute("pwd");
//
//        if (number < 0 || inventory < 0 || price < 0 || !StringUtils.hasText(name)
//                || !StringUtils.hasText(category) || !StringUtils.hasText(accountSell)) {
//            return new AddCommodityResponse(RtnCode.DATA_ERROR.getMessage());
//        }
    
//        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
//            return new AddCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
//        }
//        int result = commodityDao.addCommodityWhereNotExists(number, name, category, inventory, price, accountSell, number);
//        if (result == 0) {
//            return new AddCommodityResponse(RtnCode.DATA_DUPLICATE.getMessage());
//        }
//
//        return new AddCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
//    }

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
    	
    	
//        String account = (String) session.getAttribute("account");
//        String pwd = (String) session.getAttribute("pwd");
//        int commodityNumber = request.getNumber();
//
//        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
//            return new DeleteCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
//        }
//        if (commodityNumber < 0 ){
//            return new DeleteCommodityResponse(RtnCode.DATA_ERROR.getMessage());
//        }
//        Optional<Commodity> optionalCommodity = commodityDao.findById(commodityNumber);
//        if (!optionalCommodity.isPresent()){
//            return new DeleteCommodityResponse(RtnCode.NOT_FOUND.getMessage());
//        }
//        if (!optionalCommodity.get().getAccountSell().equals(account) ){
//            return new DeleteCommodityResponse("荳崎�ｽ蛻ｪ蛻･莠ｺ逧�");
//        }
//
//        //todo 邂｡逅�蜩｡荳咲畑蛻､譁ｷ蟆ｱ閭ｽ蛻ｪ髯､
//        //todo 螟壻ｸ�蛟虐tatus 蛻､譁ｷ 譏ｯ荳肴弍陲ｫ荳玖ｨゆｺ� 陲ｫ荳玖ｨょｰｱ荳崎�ｽ蛻ｪ髯､?
//        commodityDao.deleteById(commodityNumber);
//
//        return new DeleteCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
//    }

    @Override
    public UpdateCommodityResponse updateNameByNumber(HttpSession session, UpdateCommodityRequest request) {//todo 蜷榊ｭ苓ｦ∫ｬｦ蜷域ｭ｣隕�
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        String newName = request.getName();
        int commodityNumber = request.getCommodityNumber();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new UpdateCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        //todo (譛蛾怙隕∝落?)蜈育恚蝠�蜩∵弍蜷ｦ蟄伜惠 譛牙ｭ伜惠蜀肴隼 豐貞ｭ伜惠蟆ｱ荳肴隼 done
        int result = commodityDao.updateNameByNumber(newName, commodityNumber);
        if (result == 0){
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
        if (!StringUtils.hasText(newCategory)){
            return new UpdateCommodityResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        int result = commodityDao.updateCategoryByNumber(newCategory, commodityNumber);
        if (result == 0){
            return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
        }
        return new UpdateCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateCommodityResponse updateInventoryByNumber(HttpSession session, UpdateCommodityRequest request) {
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        int  newInventory = request.getInventory();
        int commodityNumber = request.getCommodityNumber();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new UpdateCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        if (newInventory < 0 ){
            return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
        }
        int result = commodityDao.updateInventoryByNumber(newInventory, commodityNumber);
        if (result == 0){
            return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
        }
        return new UpdateCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateCommodityResponse updatePriceByNumber(HttpSession session, UpdateCommodityRequest request) {
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        int  newPrice = request.getPrice();
        int commodityNumber = request.getCommodityNumber();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new UpdateCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        if (newPrice< 0 ){
            return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
        }
        int result = commodityDao.updatePriceByNumber(newPrice, commodityNumber);
        if (result == 0){
            return new UpdateCommodityResponse(RtnCode.DATA_ERROR.getMessage());
        }
        return new UpdateCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public SearchCommodityResponse searchCommodityByName(HttpSession session, SearchCommodityRequest request) {
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        String name = request.getName();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new SearchCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        if (!StringUtils.hasText(name)){
            return new SearchCommodityResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        List<Commodity> result = commodityDao.findByName(name);
        if (CollectionUtils.isEmpty(result)){
            return new SearchCommodityResponse(RtnCode.NOT_FOUND.getMessage());
        }

        return new SearchCommodityResponse(RtnCode.SUCCESSFUL.getMessage(),result);
    }

    @Override
    public SearchCommodityResponse searchCommodityByCategory(HttpSession session, SearchCommodityRequest request) {
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        String category = request.getCategory();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new SearchCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        if (!StringUtils.hasText(category)){
            return new SearchCommodityResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        List<Commodity> result = commodityDao.findByCategory(category);
        if (CollectionUtils.isEmpty(result)){
            return new SearchCommodityResponse(RtnCode.NOT_FOUND.getMessage());
        }

        return new SearchCommodityResponse(RtnCode.SUCCESSFUL.getMessage(),result);
    }

    @Override
    public DistinctSearchResponse distinctSearchCommodityByName(HttpSession session, SearchCommodityRequest request) {
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        String name = request.getName();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new DistinctSearchResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        if (!StringUtils.hasText(name)){
            return new DistinctSearchResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        List<DistinctSearchResponse> result = commodityDao.distinctSearchByName(name);
        if (CollectionUtils.isEmpty(result)){
            return new DistinctSearchResponse(RtnCode.NOT_FOUND.getMessage());
        }
        return new DistinctSearchResponse(result,RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public DistinctSearchResponse distinctSearchCommodityByCategory(HttpSession session, SearchCommodityRequest request) {
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        String category = request.getCategory();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new DistinctSearchResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        if (!StringUtils.hasText(category)){
            return new DistinctSearchResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        List<DistinctSearchResponse> result = commodityDao.distinctSearchByName(category);
        if (CollectionUtils.isEmpty(result)){
            return new DistinctSearchResponse(RtnCode.NOT_FOUND.getMessage());
        }
        return new DistinctSearchResponse(result,RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public DistinctSearchResponse distinctSearchCommodityByNameOrCategory(HttpSession session, SearchCommodityRequest request) {
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        String keyword = request.getKeyword();
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new DistinctSearchResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        if (!StringUtils.hasText(keyword)){
            return new DistinctSearchResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        List<DistinctSearchResponse> result = commodityDao.distinctSearchByName(keyword);
        if (CollectionUtils.isEmpty(result)){
            return new DistinctSearchResponse(RtnCode.NOT_FOUND.getMessage());
        }
        return new DistinctSearchResponse(result,RtnCode.SUCCESSFUL.getMessage());
    }
    //    public RtnCode checkLogin(String account , String pwd){
//        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)){
//            return RtnCode.PLEASE_LOGIN_FIRST;
//        }
//        User result = userDao.findByAccountAndPwd(account, pwd);
//        if (result == null){
//            return RtnCode.DATA_ERROR;
//        }
//        return RtnCode.SUCCESSFUL;
//    }
}
