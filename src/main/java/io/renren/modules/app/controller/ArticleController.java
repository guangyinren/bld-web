package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.app.entity.ArticleEntity;
import io.renren.modules.app.service.ArticleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 文章
 *
 * @author lhc
 * @email
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("app/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:article:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = articleService.queryPage(params);
        /*for(int i=0;i<page.getList().size();i++){
            ArticleEntity entity=(ArticleEntity)page.getList().get(i);
            if(StringUtils.isNotEmpty(entity.getUserId())){
                UserEntity userEntity = userService.selectById(entity.getUserId());
                ((ArticleEntity) page.getList().get(i)).setUserId(userEntity.getUsername());
            }
        }*/
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{articleId}")
    @RequiresPermissions("app:article:info")
    public R info(@PathVariable("articleId") String articleId) {
        ArticleEntity article = articleService.selectById(articleId);
        /*UserEntity userEntity = userService.selectById(article.getUserId());
        article.setUserId(userEntity.getUsername());*/
        return R.ok().put("article", article);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("app:article:save")
    public R save(@RequestBody ArticleEntity article) {
        articleService.insert(article);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:article:update")
    public R update(@RequestBody ArticleEntity article) {
        articleService.updateById(article);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:article:delete")
    public R delete(@RequestBody String[] articleIds) {
        articleService.deleteBatchIds(Arrays.asList(articleIds));

        return R.ok();
    }

}
