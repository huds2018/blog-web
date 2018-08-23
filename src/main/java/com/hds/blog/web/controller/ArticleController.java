package com.hds.blog.web.controller;

import com.hds.article.apiModel.ArticleRequest;
import com.hds.article.apiModel.BaseResponse;
import com.hds.article.model.Article;
import com.hds.article.service.ArticleService;
import com.hds.blog.util.BeanUtils;
import io.swagger.annotations.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by admin on 2018/8/16.
 */
@Api(tags = {"文章管理接口"})
@Controller
public class ArticleController {

    public ArticleService service = BeanUtils.getBean(ArticleService.class);

    @ApiOperation(value="首页", notes="首页")
    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "123";
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", value = "文章ID", required = true, dataType = "String", paramType = "form")
    }
    )
    @ResponseBody
    @RequestMapping(value = "/s", method = RequestMethod.POST)
    public String s(String a){
        return a;
    }

    @ApiOperation(value = "获取文章", notes = "根据文章ID获取指定文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "request", value = "文章查询通用实体", required = true, dataType = "ArticleRequest", paramType = "form")
    }
    )
    @ResponseBody
    @RequestMapping(value = "/getArticle", method = RequestMethod.POST)
    public BaseResponse queryArticle(@RequestBody ArticleRequest request){
        Article article = service.getArticleById(request);
        Map<String, Object> map = new HashedMap();
        map.put("aa",123);
        BaseResponse response = BaseResponse.response("OK", 200, article);
        return response;
    }


}
