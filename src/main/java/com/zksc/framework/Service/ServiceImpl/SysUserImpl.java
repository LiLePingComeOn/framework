package com.zksc.framework.Service.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.zksc.framework.Entity.SysUser;
import com.zksc.framework.Service.SysUserService;
import com.zksc.framework.Mapper.SysUserMapper;

/**
 * @description 用户表业务层处理
 * @date 2020-06-14
 */
@Service
public class SysUserImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 新增用户表
     * @param sysUser 用户表
     * @return 结果
     * @date 2020/06/14
     **/
    @Override
    public int insertSysUser(SysUser sysUser){
        return sysUserMapper.insertSysUser(sysUser);
    }

    /**
     * 根据主键删除用户表
     * @param userId 需要删除的主键
     * @return 结果
     * @date 2020/06/14
     **/
    @Override
    public int deleteSysUserByUserId(String userId){
        return sysUserMapper.deleteSysUserByUserId(userId);
    }

    /**
     * 根据主键批量删除用户表
     * @param userIds 需要删除的主键数组
     * @return 结果
     * @date 2020/06/14
     **/
    public int deleteSysUserByUserIds(String[] userIds){
        return sysUserMapper.deleteSysUserByUserIds(userIds);
    }
    /**
     * 更新用户表
     * @param 用户表 sysUser
     * @return 结果
     * @date 2020/06/14
     **/
    @Override
    public int updateSysUser(SysUser sysUser){
        return sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 查询用户表
     * @param 用户表 sysUser
     * @return 用户表集合
     * @date 2020/06/14
     **/
    @Override
    public List<SysUser> selectSysUserList(SysUser sysUser){
        return sysUserMapper.selectSysUserList(sysUser);
    }

    /*
     * 根据id查询用户表
     * @param 用户表主键
     * @return 用户表
     * @date 2020/06/14
     */
    public SysUser selectSysUserByUserId(String userId){
        return sysUserMapper.selectSysUserByUserId(userId);
    }
}