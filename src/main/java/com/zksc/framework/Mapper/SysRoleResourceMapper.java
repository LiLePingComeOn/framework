package com.zksc.framework.Mapper;
import java.util.List;
import java.util.Map;

import com.zksc.framework.Entity.SysRoleResource;
/**
 * @description 角色权限表
 * @date 2020-06-13
 */
public interface SysRoleResourceMapper {

    /**
     * 新增
     * @date 2020/06/13
     **/
    public int insertSysRoleResource(SysRoleResource sysRoleResource);

    /**
     * 根据主键删除
     * @date 2020/06/13
     **/
    public int deleteSysRoleResourceByRoleResourceId(String roleResourceId);

    /**
     * 更新
     * @date 2020/06/13
     **/
    public int updateSysRoleResource(SysRoleResource sysRoleResource);

    /**
     * 查询
     * @date 2020/06/13
     **/
    public List<SysRoleResource> selectSysRoleResourceList(SysRoleResource sysRoleResource);

    /*
     *根据id查询
     *@date 2020/06/13
     */
    public SysRoleResource selectSysRoleResourceByRoleResourceId(String roleResourceId);

    /*
        通过role_id查询角色的权限
     */
    public List<Map<String, Object>> getResourceByRoleId(String roleId);

}
