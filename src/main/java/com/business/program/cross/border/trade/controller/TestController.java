package com.business.program.cross.border.trade.controller;

import com.business.program.cross.border.trade.common.ResponseObject;
import com.business.program.cross.border.trade.service.interfaces.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("/add")

    public ResponseObject<Void> addData() {
        testService.addData2();
        return ResponseObject.success();
    }


}
