package com.hds.blog.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2018/8/20.
 */
@Api(tags = "用户信息接口")
@Controller
public class UserController {
    @ApiOperation(value = "获取用户姓名", notes = "根据用户ID获取用户姓名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "form")
    }
    )
    @ResponseBody
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName(String id){
        return "xxx";
    }
}
