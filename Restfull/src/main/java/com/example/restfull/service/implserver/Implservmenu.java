package com.example.restfull.service.implserver;

import com.example.restfull.common.ComReturn;
import com.example.restfull.service.server.Servmenu;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 创建时间:2019/7/19
 * 创建人:pmc
 * 描述:
 */
@Service
public class Implservmenu implements Servmenu
{
    @Override
    public ResponseEntity<?> menuAdd()
    {
        return null;
    }

    @Override
    public ResponseEntity<?> menuGet()
    {
        String objects = "[{\"name\":\"菜单1\",\"menuid\":\"1\",\"icon\":\"ios-navigate\",\"data\":{\"component\":\"\"},\"childs\":[{\"name\":\"子菜单1-1\",\"menuid\":\"1-1\",\"icon\":\"ios-keypad\",\"component\":\"Test1\",\"data\":{},\"childs\":[]}]},{\"name\":\"菜单2\",\"menuid\":\"2\",\"icon\":\"ios-navigate\",\"data\":{\"component\":\"\"},\"childs\":[{\"name\":\"子菜单2-1\",\"menuid\":\"2-1\",\"icon\":\"ios-keypad\",\"component\":\"Test2\",\"data\":{},\"childs\":[]}]}]";
        return ComReturn.responseReturnOK(objects);
    }
}
