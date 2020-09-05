package com.poc.userrolemap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.poc.userrolemap.model.*;
import com.poc.userrolemap.services.RoleMapServices;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoleMapController {

    @Autowired
    private RoleMapServices roleMapServices;


    //Displaying all roles - TEST OK
    @RequestMapping("/userroles")
    public List<ACUserRoleXref> getAllMapRoles() throws JsonProcessingException {
        return roleMapServices.getAllMapRoles();
    }

    //Displaying all roles with roles details object - actual method - TEST OK
    @RequestMapping("/userrolestest")
    public List<UserRoles> getAllMapRolesTest(@RequestHeader("Authorization") String bearerToken) throws JsonProcessingException {
        return roleMapServices.getAllMapRolesTest(bearerToken);
    }

    //Displaying role ids and modules for the user - id  - need to test
    @RequestMapping("user/roles/modules/{id}")
    public UserRolesModules getUserRolesModules(@PathVariable Integer id, @RequestHeader("Authorization") String bearerToken) throws JsonProcessingException {

        ACUserRoleXrefId acUserRoleXrefId = new ACUserRoleXrefId();
        acUserRoleXrefId.setUserId(id);
        return roleMapServices.getAllUserMapRolesMapModules(id, bearerToken);
    }


    //Displaying role ids for the user - need to test and change uri - TEST OK
    @RequestMapping("role/user/{id}")
    public List<ACUserRoleXref> getRoleMap(@PathVariable Integer id){
        ACUserRoleXrefId acUserRoleXrefId = new ACUserRoleXrefId();
        acUserRoleXrefId.setUserId(id);
        return roleMapServices.getMapRoleId(id);
    }

    //Displaying role details for the user - need to test and change uri - TEST OK
    @RequestMapping("roledetails/users/{id}")
    public List<UserRoles> getRoleDetailsMap(@PathVariable Integer id, @RequestHeader("Authorization") String bearerToken) throws JsonProcessingException {
        ACUserRoleXrefId acUserRoleXrefId = new ACUserRoleXrefId();
        acUserRoleXrefId.setUserId(id);
        return roleMapServices.getMapRoledetails(id, bearerToken);
    }

    // Adding user to roles - mapping
    @RequestMapping(method = RequestMethod.POST, value = "/userroles")
    public void addRoleMap(@RequestBody ACUserRoleXref rolemap){
        System.out.println("inside add method ");
        roleMapServices.addMapRole(rolemap);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/userroles/{id}")
    public void updateRoleMap(@RequestBody ACUserRoleXref rolemap, @PathVariable Integer id){
        System.out.println("inside update method "+id);
        roleMapServices.updateMapRole(id, rolemap);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userroles/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public void deleteRoleMap(@RequestBody ACUserRoleXref rolemap, @PathVariable Integer id){
        System.out.println("rolemap... "+rolemap.getUserId()+" mapped role .. "+rolemap.getMappedRole()+" role id .. "+rolemap.getRoleId()+" ..user id.."+id);
        roleMapServices.deleteMapRole(id, rolemap);
    }

}
