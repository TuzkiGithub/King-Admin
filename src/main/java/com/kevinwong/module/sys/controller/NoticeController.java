package com.kevinwong.module.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevinwong.module.sys.entity.NoticeEntity;
import com.kevinwong.module.sys.service.NoticeService;
import com.kevinwong.core.utils.PageUtils;
import com.kevinwong.core.utils.K;



/**
 * 通知表
 *
 * @author Eastascend <EastascendWang@gmail.com>
 * @date 2019-04-28 17:15:07
 */
@RestController
@RequestMapping("sys/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:notice:list")
    public K list(@RequestParam Map<String, Object> params){
        PageUtils page = noticeService.queryPage(params);

        return K.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{noticeId}")
    @RequiresPermissions("sys:notice:info")
    public K info(@PathVariable("noticeId") Long noticeId){
		NoticeEntity notice = noticeService.getById(noticeId);

        return K.ok().put("notice", notice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:notice:save")
    public K save(@RequestBody NoticeEntity notice){
		noticeService.save(notice);

        return K.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:notice:update")
    public K update(@RequestBody NoticeEntity notice){
		noticeService.updateById(notice);

        return K.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:notice:delete")
    public K delete(@RequestBody Long[] noticeIds){
		noticeService.removeByIds(Arrays.asList(noticeIds));

        return K.ok();
    }

}
