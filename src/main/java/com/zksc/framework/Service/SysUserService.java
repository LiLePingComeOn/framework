package com.zksc.framework.Service;

import java.util.List;
import com.zksc.framework.Entity.SysUser;
/**
 * @description 用户表Service接口
 * @date 2020-06-14
 */
public interface SysUserService {

    /**
     * 新增用户表
     * @param sysUser 用户表
     * @return 结果
     * @date 2020/06/14
     **/
    public int insertSysUser(SysUser sysUser);

    /**
     * 根据主键删除用户表
     * @param userId 需要删除的主键
     * @return 结果
     * @date 2020/06/14
     **/
    public int deleteSysUserByUserId(String userId);

    /**
     * 根据主键批量删除用户表
     * @param userIds 需要删除的主键数组
     * @return 结果
     * @date 2020/06/14
     **/
    public int deleteSysUserByUserIds(String[] userIds);

    /**
     * 更新用户表
     * @param 用户表 sysUser
     * @return 结果
     * @date 2020/06/14
     **/
    public int updateSysUser(SysUser sysUser);

    /**
     * 查询用户表
     * @param 用户表 sysUser
     * @return 用户表集合
     * @date 2020/06/14
     **/
    public List<SysUser> selectSysUserList(SysUser sysUser);

    /*
     * 根据id查询用户表
     * @param 用户表主键
     * @return 用户表
     * @date 2020/06/14
     */
    public SysUser selectSysUserByUserId(String userId);

}
