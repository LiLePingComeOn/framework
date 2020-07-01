package com.zksc.framework.Mapper;

import com.zksc.framework.Entity.SysTemplete;

import java.util.List;

public interface SysTempleteMapper {
    public List<SysTemplete> getTempleteList(String frameworkType);
}
