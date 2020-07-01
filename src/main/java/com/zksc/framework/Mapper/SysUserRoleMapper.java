package com.zksc.framework.Mapper;
import java.util.List;
import java.util.Map;

import com.zksc.framework.Entity.SysUserRole;

/**
 * @description 用户角色对应表
 * @date 2020-06-13
 */
public interface SysUserRoleMapper {

    /**
     * 新增
     *
     * @date 2020/06/13
     **/
    public int insertSysUserRole(SysUserRole sysUserRole);

    /**
     * 根据主键删除
     *
     * @date 2020/06/13
     **/
    public int deleteSysUserRoleByUserRoleId(String userRoleId);

    /**
     * 更新
     *
     * @date 2020/06/13
     **/
    public int updateSysUserRole(SysUserRole sysUserRole);

    /**
     * 查询
     *
     * @date 2020/06/13
     **/
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole);

    /*
     *根据id查询
     *@date 2020/06/13
     */
    public SysUserRole selectSysUserRoleByUserRoleId(String userRoleId);


    /*
        通过role_id查询角色的权限
     */
    public List<Map<String, Object>> getRoleByUerId(String userId);

}
