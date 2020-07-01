package com.zksc.framework.Service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.zksc.framework.Entity.SysUserRole;
import com.zksc.framework.Service.SysUserRoleService;
import com.zksc.framework.Mapper.SysUserRoleMapper;

/**
 * @description 用户角色对应表
 * @date 2020-06-13
 */
@Service
public class SysUserRoleImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 数据插入
     * @date 2020/06/13
     **/
    @Override
    public int insertSysUserRole(SysUserRole sysUserRole){
        return sysUserRoleMapper.insertSysUserRole(sysUserRole);
    }

    /**
     * 刪除
     * @date 2020/06/13
     **/
    @Override
    public int deleteSysUserRoleByUserRoleId(String userRoleId){
        return sysUserRoleMapper.deleteSysUserRoleByUserRoleId(userRoleId);
    }

    /**
     * 更新
     * @date 2020/06/13
     **/
    @Override
    public int updateSysUserRole(SysUserRole sysUserRole){
        return sysUserRoleMapper.updateSysUserRole(sysUserRole);
    }

    /**
     * 查询
     * @date 2020/06/13
     **/
    @Override
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole){
        return sysUserRoleMapper.selectSysUserRoleList(sysUserRole);
    }

    /*
     *根据id查询
     *@date 2020/06/13
     */
    public SysUserRole selectSysUserRoleByUserRoleId(String userRoleId){
        return sysUserRoleMapper.selectSysUserRoleByUserRoleId(userRoleId);
    }

    @Override
    public List<Map<String, Object>> getRoleByUerId(String userId) {
        return sysUserRoleMapper.getRoleByUerId(userId);
    }

}