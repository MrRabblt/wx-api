package cn.hmxz.modules.lit.service;

import cn.hmxz.modules.lit.entity.Advertisement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 广告表(Advertisement)表服务接口
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:02
 */
public interface AdvertisementService {

    /**
     * 通过ID查询单条数据
     *
     * @param adId 主键
     * @return 实例对象
     */
    Advertisement queryById(Long adId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Advertisement> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    Advertisement insert(Advertisement advertisement);

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    Advertisement update(Advertisement advertisement);

    /**
     * 通过主键删除数据
     *
     * @param adId 主键
     * @return 是否成功
     */
    boolean deleteById(Long adId);

    /**
     * 通过广告类型查询广告列表
     *
     * @param type type
     * @return 实例对象
     */
    List<Advertisement> queryByAdType(@Param("adType") String type);
}