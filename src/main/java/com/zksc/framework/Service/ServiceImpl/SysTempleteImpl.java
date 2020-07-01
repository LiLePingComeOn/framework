package com.zksc.framework.Service.ServiceImpl;

import com.zksc.framework.Entity.SysTemplete;
import com.zksc.framework.Mapper.SysTempleteMapper;
import com.zksc.framework.Service.SysTempleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysTempleteImpl implements  SysTempleteService {

    @Autowired
    private SysTempleteMapper templeteMapper;

    @Override
    public List<SysTemplete> getTempleteList(String frameworkTyp) {
        return templeteMapper.getTempleteList(frameworkTyp);
    }
}
