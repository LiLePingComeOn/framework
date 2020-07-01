package com.zksc.framework.Realm;

import com.zksc.framework.Entity.SysRoleResource;
import com.zksc.framework.Entity.SysUser;
import com.zksc.framework.Entity.SysUserRole;
import com.zksc.framework.Service.SysRoleResourceService;
import com.zksc.framework.Service.SysUserRoleService;
import com.zksc.framework.Service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleResourceService sysRoleResourceService;


    /*
        执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userId = (String) principalCollection.iterator().next();
        System.out.println("userId is" + userId);

        Set<String> roleSet = new HashSet<>();
        Set<String> resourceSet = new HashSet<>();

        //查询角色列表
        List<Map<String, Object>> userRoleList = sysUserRoleService.getRoleByUerId(userId);

        //查询权限列表
        for (Map<String,Object> sysRoleMap : userRoleList) {

            roleSet.add(sysRoleMap.get("roleName").toString());
            List<Map<String, Object>> sysRoleResourceList = sysRoleResourceService.getResourceByRoleId(sysRoleMap.get("roleId").toString());

            for (Map<String,Object> sysRoleResourceMap : sysRoleResourceList) {
                resourceSet.add(sysRoleResourceMap.get("resourcePermission").toString());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleSet);
        simpleAuthorizationInfo.addStringPermissions(resourceSet);

        return simpleAuthorizationInfo;
    }

    /*
        执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String userName = usernamePasswordToken.getUsername();

        SysUser testUser = new SysUser();
        testUser.setUserName(userName);
        List<SysUser> sysUserList = sysUserService.selectSysUserList(testUser);

        if (sysUserList.size() == 0)
            return null;

        return new SimpleAuthenticationInfo(sysUserList.get(0).getUserId(), sysUserList.get(0).getUserPassword(), getName());
    }

    //重写getName，返回realm名称
    @Override
    public String getName(){
        return "myRealm";
    }
}
