package io.renren.modules.app.apicontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.renren.common.base.AbstractController;
import io.renren.common.utils.MapUtils;
import io.renren.common.utils.R;
import io.renren.modules.app.entity.LiteratureActivityEntity;
import io.renren.modules.app.service.LiteratureActivityService;



/**
 * 文学活动表
 *
 * @author lhc
 * @email 
 * @date 2018-06-30 00:00:27
 */
@RestController
@RequestMapping("api/literatureactivity")
public class LiteratureActivityApiController extends AbstractController{
    @Autowired
    private LiteratureActivityService literatureActivityService;
    
    /**
     * 获取当前进行中的文学活动
     * @return
     */
    @RequestMapping("/queryNowLiterature")
    public R queryMyArticle(){
    	LiteratureActivityEntity entity=new LiteratureActivityEntity();
    	entity.setStatus("1");
    	List<LiteratureActivityEntity> list = literatureActivityService.selectList(new EntityWrapper<LiteratureActivityEntity>(entity));
        return R.ok().put("list", list);
    }
    
    /**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(String sponsorName) {
		if (StringUtils.isEmpty(sponsorName)) {
			return R.error(1,"主题名称不能为空");
		}
		List<MapUtils> maps=new ArrayList<>();
		List<LiteratureActivityEntity> list = literatureActivityService.selectList(new EntityWrapper<LiteratureActivityEntity>().eq("sponsor_name", sponsorName).orderBy("create_time", false));
		for(LiteratureActivityEntity entity:list) {
			MapUtils map=new MapUtils();
			map.put("literatureActivityId", entity.getLiteratureActivityId());
			map.put("title", entity.getTitle());
			maps.add(map);
		}
		return R.ok().put("list", maps);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info")
	public R info(String literatureActivityId) {
		if (StringUtils.isEmpty(literatureActivityId)) {
			return R.error(1,"活动id不能为空");
		}
		LiteratureActivityEntity literatureActivity = literatureActivityService.selectById(literatureActivityId);
		return R.ok().put("literatureActivity", literatureActivity);
	}

}
