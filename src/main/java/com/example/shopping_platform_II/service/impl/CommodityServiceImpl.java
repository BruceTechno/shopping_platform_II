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
        int number = (int) (Math.random() * 10000 + 1);
        String name = request.getName();
        String category = request.getCategory();
        int inventory = request.getInventory();
        int price = request.getPrice();
        String accountSell = (String) session.getAttribute("account");

        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");

        if (number < 0 || inventory < 0 || price < 0 || !StringUtils.hasText(name)
                || !StringUtils.hasText(category) || !StringUtils.hasText(accountSell)) {
            return new AddCommodityResponse(RtnCode.DATA_ERROR.getMessage());
        }
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new AddCommodityResponse("Plz login");
        }
        int result = commodityDao.addCommodityWhereNotExists(number, name, category, inventory, price, accountSell, number);
        if (result == 0) {
            return new AddCommodityResponse(RtnCode.DATA_DUPLICATE.getMessage());
        }
        //todo 賣家(account_sell)用session
        return new AddCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public DeleteCommodityResponse deleteCommodity(HttpSession session, DeleteCommodityRequest request) {
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        int commodityNumber = request.getCommodityNumber();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new DeleteCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        if (commodityNumber < 0 ){
            return new DeleteCommodityResponse(RtnCode.DATA_ERROR.getMessage());
        }
        Optional<Commodity> optionalCommodity = commodityDao.findById(commodityNumber);
        if (!optionalCommodity.isPresent()){
            return new DeleteCommodityResponse(RtnCode.NOT_FOUND.getMessage());
        }
        if (!optionalCommodity.get().getAccountSell().equals(account) ){
            return new DeleteCommodityResponse("不能刪別人的");
        }
        //todo 判斷是自己的帳號賣的東西才能刪除 done
        //todo 管理員不用判斷就能刪除
        //todo 多一個status 判斷 是不是被下訂了 被下訂就不能刪除?
        commodityDao.deleteById(commodityNumber);

        return new DeleteCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateCommodityResponse updateNameByNumber(HttpSession session, UpdateCommodityRequest request) {//todo 名字要符合正規
        String account = (String) session.getAttribute("account");
        String pwd = (String) session.getAttribute("pwd");
        String newName = request.getName();
        int commodityNumber = request.getCommodityNumber();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new UpdateCommodityResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        //todo (有需要嗎?)先看商品是否存在 有存在再改 沒存在就不改 done
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
        return null;
    }

    @Override
    public DistinctSearchResponse distinctSearchCommodityByNameOrCategory(HttpSession session, SearchCommodityRequest request) {
        return null;
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
