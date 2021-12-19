package com.fadelJmartPK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fadelJmartPK.dbjson.JsonDBEngine;


/**
 * <h1>JMart Program<h1>
 *
 * @author Muhammad Fadel Akbar Putra
 * @version 11-09-2021
 */


@SpringBootApplication
public class Jmart
{
    public static void main(String[] args) {
        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}