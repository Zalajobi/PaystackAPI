package paystack.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import paystack.api.constants.BaseURL;
import paystack.api.core.ApiQuery;
import paystack.api.model.transaction.AuthorizationStatus;
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

    @GetMapping(value = TRANSACTION + "/export")
    private Map<String, Object> exportTransaction() {
        return apiQuery.getConnectAndQuery(TRANSACTION_API + "export");
    }

    @GetMapping(value = TRANSACTION + "/total")
    private Map<String, Object> totalTransactions() {
        return apiQuery.getConnectAndQuery(TRANSACTION_API + "totals");
    }

    @GetMapping(value = TRANSACTION + "/timeline")
    private Map<String, Object> transactionTimeline(@RequestParam(name = "id") String id) {
        return apiQuery.getConnectAndQuery(TRANSACTION_API + "timeline/" + id);
    }

    @GetMapping(value = TRANSACTION + "/all")
    private Map<String, Object> AllTransactions() {
        return apiQuery.getConnectAndQuery(TRANSACTION_API);
    }

    @PostMapping(value = AUTHORIZATION + "/confirm")
    private Map<String, Object> checkTransactionAuthorizationStatus(@ModelAttribute AuthorizationStatus status) {
        return apiQuery.connectAndQuery(status.asMap(), TRANSACTION_API + "check_authorization");
    }

    @PostMapping(value = AUTHORIZATION + "/charge")
    private Map<String, Object> chargeAuthorization(@ModelAttribute AuthorizationStatus status) {
        return apiQuery.connectAndQuery(status.asMap(), TRANSACTION_API + "charge_authorization");
    }

    @PostMapping(value = AUTHORIZATION + "/deactivate")
    private Map<String, Object> deactivateAuthorization(@ModelAttribute AuthorizationStatus status) {
        return apiQuery.connectAndQuery(status.asMap(), TRANSACTION_API + "deactivate_authorization");
    }
}
