package com.zksc.framework.Service.ServiceImpl;
import com.zksc.framework.Entity.SysResource;
import com.zksc.framework.Mapper.SysResourceMapper;
import com.zksc.framework.Service.SysResourceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @description 系统资源表
 * @date 2020-06-13
 */
@Service
public class SysResourceImpl implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    /**
     * 数据插入
     * @date 2020/06/13
     **/
    @Override
    public int insertSysResource(SysResource sysResource){
        return sysResourceMapper.insertSysResource(sysResource);
    }

    /**
     * 刪除
     * @date 2020/06/13
     **/
    @Override
    public int deleteSysResourceByResoureId(String resoureId){
        return sysResourceMapper.deleteSysResourceByResoureId(resoureId);
    }

    /**
     * 更新
     * @date 2020/06/13
     **/
    @Override
    public int updateSysResource(SysResource sysResource){
        return sysResourceMapper.updateSysResource(sysResource);
    }

    /**
     * 查询
     * @date 2020/06/13
     **/
    @Override
    public List<SysResource> selectSysResourceList(SysResource sysResource){
        return sysResourceMapper.selectSysResourceList(sysResource);
    }

    /*
     *根据id查询
     *@date 2020/06/13
     */
    public SysResource selectSysResourceByResoureId(String resoureId){
        return sysResourceMapper.selectSysResourceByResoureId(resoureId);
    }
}