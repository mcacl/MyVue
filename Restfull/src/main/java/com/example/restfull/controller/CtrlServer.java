package com.example.restfull.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Map;

/**
 * 创建时间:2019/7/10
 * 创建人:pmc
 * 描述:
 */
@RestController
@RequestMapping(value = "/bdcInterface")
public class CtrlServer
{
    @RequestMapping(value = "/test")
    public ResponseEntity<?> test()
    {
        String res = "66666";
        ResponseEntity<?> responseEntity = new ResponseEntity<String>(res, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/landTransfer1")
    public ResponseEntity<?> tdzr1(@RequestBody Map<String, Object> param)
    {
        String title = "tdzr:";
        Iterator<Map.Entry<String, Object>> entry = param.entrySet().iterator();
        if (entry.hasNext())
        {
            Map.Entry<String, Object> stringEntry = entry.next();
            System.out.println(stringEntry.getValue());
        }
        String res = "{\"flag\":\"true\", \"message\":\"接收成功\"}";

        ResponseEntity<?> responseEntity = new ResponseEntity<String>(res, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/landTransfer")
    public ResponseEntity<?> tdzr(@RequestBody Object landTransferInfo)
    {
        String title = "tdzr:";
        System.out.println(title + landTransferInfo);
        String res = "{\"flag\":\"true\", \"message\":\"接收成功\"}";

        ResponseEntity<?> responseEntity = new ResponseEntity<String>(res, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/landMortgage")
    public ResponseEntity<?> tddy(@RequestBody() Object landMortgageInfo)
    {
        String title = "tddy:";
        System.out.println(title + landMortgageInfo);
        String res = "{\"flag\":\"true\", \"message\":\"接收成功\"}";

        ResponseEntity<?> responseEntity = new ResponseEntity<String>(res, HttpStatus.OK);
        return responseEntity;
    }
}
