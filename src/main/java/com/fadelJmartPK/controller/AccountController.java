package com.fadelJmartPK.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fadelJmartPK.Account;
import com.fadelJmartPK.Store;
import com.fadelJmartPK.dbjson.JsonAutowired;
import com.fadelJmartPK.dbjson.JsonTable;
import com.fadelJmartPK.dbjson.Serializable;

import ch.qos.logback.core.boolex.Matcher;


/**
 * The controller for any request with account class and implements BasicGetController.
 * this controller using rest controller to communicate
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 1.0
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>{
    public static final String REGEX_EMAIL = "^\\w+([\\.&`~-]?\\w+)*@\\w+([\\.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{7,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(value = Account.class,filepath = "akun.json")
    public static JsonTable<Account> accountTable;

    /**
     * This is /login controller to check the account validation
     * @param email passed from string request to check email on server data
     * @param password passed form string request to check pass on server data
     * @return Account class that store all public variable
     */

    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            password = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        for (Account data : accountTable){

            if(data.email.equals(email) && data.password.equals(password)){
                return data;
            }
        }
        return null;
    }

    /**
     * This is /Register controller to register an account
     * @param name pass name from string request to fill name parameter
     * @param email pass email from string request to fill email parameter
     * @param password pass password from string request to fill password parameter
     * @return Account class contains all public variable
     */
    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {

        boolean hasilEmail = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean hasilPassword = REGEX_PATTERN_PASSWORD.matcher(password).find();
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            password = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        if(!name.isBlank() && hasilEmail && hasilPassword && !accountTable.stream().anyMatch(account -> account.email.equals(email))){
            Account account =  new Account(name, email, password, 0);
            accountTable.add(account);
            return account;
        }
        return null;
    }

    /**
     *
     * @param id account id to identify whose account are requesting
     * @param name pass name from string request to fill name parameter
     * @param address pass address from string request to fill address parameter
     * @param phoneNumber pass phone number from string request to fill phone number parameter
     * @return Store class contains all
     */
    @PostMapping("/{id}/registerStore")
    Store register
            (
                    @RequestParam int id,
                    @RequestParam String name,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {
        for(Account data : accountTable){
            if (data.store == null && data.id == id){
                data.store = new Store(name,address,phoneNumber,0);
                return data.store;
            }
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    Boolean topup
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {
        for(Account data : accountTable){
            if(data.id == id) {
                data.balance += balance;
                return true;
            }
        }
        return false;
    }

    @Override
    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        return BasicGetController.super.getById(id);
    }

    @Override
    public JsonTable getJsonTable() {
        return accountTable;
    }

    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
}
