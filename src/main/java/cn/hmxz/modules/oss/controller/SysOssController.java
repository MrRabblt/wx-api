package cn.hmxz.modules.oss.controller;

import cn.hmxz.common.utils.file.FileUploadUtils;
import cn.hmxz.modules.lit.config.BlackConfig;
import cn.hmxz.modules.lit.config.ServerConfig;
import cn.hmxz.modules.lit.entity.io.response.BlackHorseResponse;
import com.alibaba.fastjson.JSON;
import cn.hmxz.common.exception.RRException;
import cn.hmxz.common.utils.ConfigConstant;
import cn.hmxz.common.utils.Constant;
import cn.hmxz.common.utils.PageUtils;
import cn.hmxz.common.utils.R;
import cn.hmxz.common.validator.ValidatorUtils;
import cn.hmxz.common.validator.group.AliyunGroup;
import cn.hmxz.common.validator.group.QcloudGroup;
import cn.hmxz.common.validator.group.QiniuGroup;
import cn.hmxz.modules.oss.cloud.CloudStorageConfig;
import cn.hmxz.modules.oss.entity.SysOssEntity;
import cn.hmxz.modules.oss.service.SysOssService;
import cn.hmxz.modules.sys.service.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * 文件上传
 * @author liangjiang
 */
@RestController
@RequestMapping("sys/oss")
@Api(tags = {"对象存储/文件上传"})
public class SysOssController {
    @Autowired
    private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private ServerConfig serverConfig;
    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;

    /**
     * 列表
     */
    @ApiOperation(value = "文件列表",notes = "对象存储管理的文件")
    @GetMapping("/list")
    @RequiresPermissions("sys:oss:all")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysOssService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 云存储配置信息
     */
    @GetMapping("/config")
    @RequiresPermissions("sys:oss:all")
    @ApiOperation(value = "云存储配置信息",notes = "首次使用前先管理后台新增配置")
    public R config() {
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


    /**
     * 保存云存储配置信息
     */
    @PostMapping("/saveConfig")
    @RequiresPermissions("sys:oss:all")
    @ApiOperation(value = "保存云存储配置信息")
    public R saveConfig(@RequestBody CloudStorageConfig config) {
        //校验类型
        ValidatorUtils.validateEntity(config);

        if (config.getType() == Constant.CloudService.QINIU.getValue()) {
            //校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        } else if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
            //校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        } else if (config.getType() == Constant.CloudService.QCLOUD.getValue()) {
            //校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        }

        sysConfigService.updateValueByKey(KEY, JSON.toJSONString(config));

        return R.ok();
    }


    /**
     * 上传文件
     */
    @PostMapping("/upload")
    @RequiresPermissions("sys:oss:all")
    @ApiOperation(value = "上传文件到OSS")
    public BlackHorseResponse upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        try {
            // 上传文件路径
            String filePath = BlackConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            HashMap<String, Object> result = new HashMap<>();
            result.put("fileName", fileName);
            result.put("url", url);

            //保存文件信息
            SysOssEntity ossEntity = new SysOssEntity();
            ossEntity.setUrl(url);
            ossEntity.setCreateDate(new Date());
            sysOssService.save(ossEntity);
            return BlackHorseResponse.buildSuccess(result);
        } catch (Exception e) {
            return BlackHorseResponse.buildFailure(e.getMessage());
        }
    }


    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("sys:oss:all")
    @ApiOperation(value = "删除文件",notes = "只删除记录，云端文件不会删除")
    public R delete(@RequestBody Long[] ids) {
        sysOssService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
