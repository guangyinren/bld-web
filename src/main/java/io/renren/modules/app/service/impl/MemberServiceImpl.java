package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.MemberDao;
import io.renren.modules.app.entity.MemberEntity;
import io.renren.modules.app.service.MemberService;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberEntity> page = this.selectPage(
                new Query<MemberEntity>(params).getPage(),
                new EntityWrapper<MemberEntity>()
        );

        return new PageUtils(page);
    }

}
