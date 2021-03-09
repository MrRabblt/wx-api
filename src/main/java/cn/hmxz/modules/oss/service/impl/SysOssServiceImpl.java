package cn.hmxz.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hmxz.modules.oss.dao.SysOssDao;
import cn.hmxz.modules.oss.entity.SysOssEntity;
import cn.hmxz.modules.oss.service.SysOssService;
import cn.hmxz.common.utils.PageUtils;
import cn.hmxz.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysOssEntity> page = this.page(
            new Query<SysOssEntity>().getPage(params)
        );

        return new PageUtils(page);
    }

}
