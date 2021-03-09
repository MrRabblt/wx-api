package cn.hmxz.modules.wx.dao;

import cn.hmxz.modules.wx.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.annotation.Async;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface ArticleMapper extends BaseMapper<Article> {
    @Async
    void addOpenCount(int id);
}
