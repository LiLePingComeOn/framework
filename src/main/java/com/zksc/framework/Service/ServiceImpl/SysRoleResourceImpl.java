package com.zksc.framework.Service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.zksc.framework.Entity.SysRoleResource;
import com.zksc.framework.Service.SysRoleResourceService;
import com.zksc.framework.Mapper.SysRoleResourceMapper;

/**
 * @description 角色权限表
 * @date 2020-06-13
 */
@Service
public class SysRoleResourceImpl implements SysRoleResourceService {

    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    /**
     * 数据插入
     * @date 2020/06/13
     **/
    @Override
    public int insertSysRoleResource(SysRoleResource sysRoleResource){
        return sysRoleResourceMapper.insertSysRoleResource(sysRoleResource);
    }

    /**
     * 刪除
     * @date 2020/06/13
     **/
    @Override
    public int deleteSysRoleResourceByRoleResourceId(String roleResourceId){
        return sysRoleResourceMapper.deleteSysRoleResourceByRoleResourceId(roleResourceId);
    }

    /**
     * 更新
     * @date 2020/06/13
     **/
    @Override
    public int updateSysRoleResource(SysRoleResource sysRoleResource){
        return sysRoleResourceMapper.updateSysRoleResource(sysRoleResource);
    }

    /**
     * 查询
     * @date 2020/06/13
     **/
    @Override
    public List<SysRoleResource> selectSysRoleResourceList(SysRoleResource sysRoleResource){
        return sysRoleResourceMapper.selectSysRoleResourceList(sysRoleResource);
    }

    /*
     *根据id查询
     *@date 2020/06/13
     */
    public SysRoleResource selectSysRoleResourceByRoleResourceId(String roleResourceId){
        return sysRoleResourceMapper.selectSysRoleResourceByRoleResourceId(roleResourceId);
    }

    @Override
    public List<Map<String, Object>> getResourceByRoleId(String roleId) {
        return sysRoleResourceMapper.getResourceByRoleId(roleId);
    }
}