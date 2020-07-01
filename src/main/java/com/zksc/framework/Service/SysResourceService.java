package com.zksc.framework.Service;
import java.util.List;
import com.zksc.framework.Entity.SysResource;
/**
 * @description 系统资源表
 * @date 2020-06-13
 */
public interface SysResourceService {

    /**
     * 新增
     * @date 2020/06/13
     **/
    public int insertSysResource(SysResource sysResource);

    /**
     * 刪除
     * @date 2020/06/13
     **/
    public int deleteSysResourceByResoureId(String resoureId);

    /**
     * 更新
     * @date 2020/06/13
     **/
    public int updateSysResource(SysResource sysResource);

    /**
     * 查询
     * @date 2020/06/13
     **/
    public List<SysResource> selectSysResourceList(SysResource sysResource);

    /*
     *根据id查询
     *@date 2020/06/13
     */
    public SysResource selectSysResourceByResoureId(String resoureId);

}
