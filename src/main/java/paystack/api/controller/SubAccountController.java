package paystack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import paystack.api.constants.BaseURL;
import paystack.api.core.ApiQuery;
import paystack.api.model.Account.SubAccount;

import java.util.Map;

@RestController
public class SubAccountController extends BaseURL {

    @Autowired
    @Qualifier(value = "apiQuery")
    private ApiQuery apiQuery;

    @GetMapping(value = SUB_ACCOUNT + "/fetch")
    private Map<String, Object> fetchAccount(@RequestParam(name = "id") String id) {
        return apiQuery.getConnectAndQuery(SUB_ACCOUNT_API + id);
    }

    @GetMapping(value = SUB_ACCOUNT + "/all")
    private Map<String, Object> allAccount() {
        return apiQuery.getConnectAndQuery(SUB_ACCOUNT_API);
    }

    @PostMapping(value = SUB_ACCOUNT + "/create")
    private Map<String, Object> createSubAccount(@RequestBody SubAccount subAccount) {
        return apiQuery.connectAndQuery(subAccount.asMap(), SUB_ACCOUNT_API);
    }

    @PutMapping(value = SUB_ACCOUNT + "/update")
    private Map<String, Object> updateSubAccount(@ModelAttribute SubAccount subAccount, @RequestParam(name = "id") String id) {
        return apiQuery.connectAndQueryWithPut(subAccount.asMap(), SUB_ACCOUNT_API + id);
    }
}
