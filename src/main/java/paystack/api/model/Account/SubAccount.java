package paystack.api.model.Account;

import java.util.HashMap;

public class SubAccount {
    private String business_name;
    private String settlement_bank;
    private String account_number;
    private float percentage_charge;
    private String description;
    private String primary_contact_email;
    private String primary_contact_name;
    private String primary_contact_phone;

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getSettlement_bank() {
        return settlement_bank;
    }

    public void setSettlement_bank(String settlement_bank) {
        this.settlement_bank = settlement_bank;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public float getPercentage_charge() {
        return percentage_charge;
    }

    public void setPercentage_charge(float percentage_charge) {
        this.percentage_charge = percentage_charge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimary_contact_email() {
        return primary_contact_email;
    }

    public void setPrimary_contact_email(String primary_contact_email) {
        this.primary_contact_email = primary_contact_email;
    }

    public String getPrimary_contact_name() {
        return primary_contact_name;
    }

    public void setPrimary_contact_name(String primary_contact_name) {
        this.primary_contact_name = primary_contact_name;
    }

    public String getPrimary_contact_phone() {
        return primary_contact_phone;
    }

    public void setPrimary_contact_phone(String primary_contact_phone) {
        this.primary_contact_phone = primary_contact_phone;
    }

    public HashMap<String, Object> asMap() {
        HashMap<String, Object> query = new HashMap<>();

        query.put("business_name", getBusiness_name());
        query.put("settlement_bank", getSettlement_bank());
        query.put("account_number", getAccount_number());
        query.put("percentage_charge", getPercentage_charge());
        query.put("description", getDescription());
        query.put("primary_contact_email", getPrimary_contact_email());
        query.put("primary_contact_name", getPrimary_contact_name());
        query.put("primary_contact_phone", getPrimary_contact_phone());

        return query;
    }
}
