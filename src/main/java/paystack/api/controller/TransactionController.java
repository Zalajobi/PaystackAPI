package paystack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import paystack.api.constants.BaseURL;
import paystack.api.core.ApiQuery;
import paystack.api.model.transaction.Initialize;

import java.util.Map;


@RestController
public class TransactionController extends BaseURL {

    @Autowired
    @Qualifier(value = "apiQuery")
    private ApiQuery apiQuery;


    @PostMapping(value = TRANSACTION + "/initialize")
    private Map<String, Object> initializeTransaction(@RequestBody Initialize transaction) {
        return apiQuery.connectAndQuery(transaction.asMap(), TRANSACTION_API + "/initialize");
    }

    @GetMapping(value = TRANSACTION + "/verify")
    private Map<String, Object> verifyTransaction(@RequestParam(name = "reference") String reference) {
        return apiQuery.getConnectAndQuery(TRANSACTION_API + "verify/" + reference);
    }

    @GetMapping(value = TRANSACTION + "/fetch")
    private Map<String, Object> fetchTransaction(@RequestParam(name = "id") String id) {
        return apiQuery.getConnectAndQuery(TRANSACTION_API + id);
    }
}
