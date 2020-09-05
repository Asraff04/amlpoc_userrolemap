package com.poc.userrolemap.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.userrolemap.model.*;
import com.poc.userrolemap.repository.RoleMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleMapServices {

    @Autowired
    private RoleMapRepository roleMapRepository;

    //private AC_Users userDetails;

    @Autowired
    private RestTemplate restTemplate;

    public List<AcUsersList> getUser(String userIds, String Bearer) throws JsonProcessingException {
        AC_Users userDetails = new AC_Users();
        List<Integer> usersArrayList = new ArrayList<>();
        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, Bearer);
        //Create a new HttpEntity
         final HttpEntity<String> entity = new HttpEntity<String>(headers);

        String fooResourceUrl = "http://localhost:8080/users/_list/";
        System.out.println("url >>>"+fooResourceUrl+userIds);
        ResponseEntity<ACUserListResponse> response = restTemplate.exchange(fooResourceUrl+userIds, HttpMethod.GET, entity, ACUserListResponse.class );
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("user id>>> "+response.getBody().getAcUsersList().get(0).getUserId());

        usersArrayList =  response.getBody().getAcUsersList().stream().map(x-> x.getUserId()).
                collect(Collectors.toList());
        userDetails.setUserId(response.getBody().getAcUsersList().get(0).getUserId());
        userDetails.setUsername(response.getBody().getAcUsersList().get(0).getUsername());

        return response.getBody().getAcUsersList();
    }

    public List<AcRolesList> getRoles(String roleIds, String Bearer)  throws JsonProcessingException{
        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, Bearer);
        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        String fooResourceUrl = "http://localhost:8081/roles/_list/";
        System.out.println("url >>>"+fooResourceUrl+roleIds);
//        ResponseEntity<ACRolesListResponse> response = restTemplate.getForEntity(fooResourceUrl+roleIds, ACRolesListResponse.class);
        ResponseEntity<ACRolesListResponse> response = restTemplate.exchange(fooResourceUrl+roleIds, HttpMethod.GET, entity, ACRolesListResponse.class );

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Role Name>>> " +response.getBody().getAcRolesList().get(0).getRoleName());
        return response.getBody().getAcRolesList();
    }

    //To get the module details for the role id -- need to test
    public List<RoleModule> getRoleModules(String roleIds, String Bearer)  throws JsonProcessingException{
        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, Bearer);
        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        RoleModuleList roleModuleList = new RoleModuleList();
        List<RoleModule> moduleRoles = roleModuleList.getRoleModuleList();
        String fooResourceUrl = "http://localhost:8083/mapmodules/rolestest/_list/";
        System.out.println("url >>>"+fooResourceUrl+roleIds);
//        ResponseEntity<RoleModuleListResponse> response = restTemplate.getForEntity(fooResourceUrl+roleIds, RoleModuleListResponse.class);
        ResponseEntity<RoleModuleListResponse> response = restTemplate.exchange(fooResourceUrl+roleIds, HttpMethod.GET, entity, RoleModuleListResponse.class );
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("module size..."+response.getBody().getRoleModuleList().size());
        return response.getBody().getRoleModuleList();

    }

    //Method is obsolete - can be used without token for testing
    public List<AcUsersList> getUser(String userIds) throws JsonProcessingException {
        AC_Users userDetails = new AC_Users();
        List<Integer> usersArrayList = new ArrayList<>();
        final HttpHeaders headers = new HttpHeaders();
//        headers.set("User-Agent", "eltabo");
//        headers.set(HttpHeaders.AUTHORIZATION, Bearer);
        //Create a new HttpEntity
//        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        String fooResourceUrl = "http://localhost:8080/users/_list/";
        System.out.println("url >>>"+fooResourceUrl+userIds);
        ResponseEntity<ACUserListResponse> response = restTemplate.getForEntity(fooResourceUrl+userIds,  ACUserListResponse.class );
//        ResponseEntity<AC_Users> usersDetails = restTemplate.getForEntity(fooResourceUrl+userIds, AC_Users.class);
//        AC_Users usersDetails = restTemplate.getForObject(fooResourceUrl + userIds, AC_Users.class);
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("user id>>> "+response.getBody().getAcUsersList().get(0).getUserId());
//        JsonNode root = mapper.readTree(response.getBody().getAcUsersList().get(0));

        usersArrayList =  response.getBody().getAcUsersList().stream().map(x-> x.getUserId()).
                collect(Collectors.toList());
//        System.out.println("user List>>> "+response.getBody().getAcUsersList().stream().map(x-> x.getUserId()).
//                    collect(Collectors.toList()));
        System.out.println("user Details >>"+userDetails);
        userDetails.setUserId(response.getBody().getAcUsersList().get(0).getUserId());
        userDetails.setUsername(response.getBody().getAcUsersList().get(0).getUsername());

        return response.getBody().getAcUsersList();
    }
    // List of All roles for role mapping - to be removed
//    public List<AcRolesList> getAllRoles()  throws JsonProcessingException{
//        String fooResourceUrl = "http://localhost:8081/roles";
//        System.out.println("url >>>"+fooResourceUrl);
//        ResponseEntity<ACRolesListResponse> response = restTemplate.getForEntity(fooResourceUrl, ACRolesListResponse.class);
////        ResponseEntity<AcRolesList> response = restTemplate.getForEntity(fooResourceUrl, AcRolesList.class);
//        ObjectMapper mapper = new ObjectMapper();
//        System.out.println("Role Name>>> " +response.getBody().getAcRolesList().get(0).getRoleId());
//        return response.getBody().getAcRolesList();
//    }

    //Method is obsolete - can be used without token for testing
    public List<AcRolesList> getRoles(String roleIds)  {
//        AC_Roles userDetails = new AC_Roles();
        String fooResourceUrl = "http://localhost:8081/roles/_list/";
        System.out.println("url >>>"+fooResourceUrl+roleIds);
        ResponseEntity<ACRolesListResponse> response = restTemplate.getForEntity(fooResourceUrl+roleIds, ACRolesListResponse.class);
//        AC_Roles rolesDetails = restTemplate.getForObject(fooResourceUrl + roleIds, AC_Roles.class);
        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(response.getBody());

        System.out.println("Role Name>>> " +response.getBody().getAcRolesList().get(0).getRoleName());


//        response = mapper.readValue(response.toString());
        return response.getBody().getAcRolesList();
    }

    //To get the module details for the role id -- need to test - //Method is obsolete - can be used without token for testing
    public List<RoleModule> getRoleModules(String roleIds)  throws JsonProcessingException{
        RoleModuleList roleModuleList = new RoleModuleList();
        List<RoleModule> moduleRoles = roleModuleList.getRoleModuleList();
        String fooResourceUrl = "http://localhost:8083/mapmodules/rolestest/_list/";
        System.out.println("url >>>"+fooResourceUrl+roleIds);
        ResponseEntity<RoleModuleListResponse> response = restTemplate.getForEntity(fooResourceUrl+roleIds, RoleModuleListResponse.class);
//        ResponseEntity<RoleModuleResponse> response = restTemplate.getForEntity(fooResourceUrl+roleIds, RoleModuleResponse.class);
        ObjectMapper mapper = new ObjectMapper();


//        roleModuleList = response.getBody()
        System.out.println("module size..."+response.getBody().getRoleModuleList().size());
        return response.getBody().getRoleModuleList();

    }


    public List<UserRoles> getAllMapRolesTest(String Bearer) throws JsonProcessingException {
//        getUser();
        List<ACUserRoleXref> mapRoles = new ArrayList<>();
        roleMapRepository.findAll()
                .forEach(mapRoles::add);
        System.out.println("User id "+ mapRoles.size());
        String userId = mapRoles.stream().map(x -> String.valueOf(x.getUserId())).collect(Collectors.joining(","));
        System.out.println("Userd second time "+userId);
        List<AcUsersList> usersLists = getUser(userId, Bearer);

         String roleId = mapRoles.stream().map( y -> String.valueOf(y.getRoleId())).collect(Collectors.joining(","));
         System.out.println("Role ids "+roleId);
         List<UserRoles> userRolesList = new ArrayList<>();

         List<AcRolesList> rolesLists = getRoles(roleId, Bearer);

           mapRoles.forEach(mapRole -> {
               UserRoles userRoles = new UserRoles();
               userRoles.setAcUsers(usersLists.stream().filter(user -> user.getUserId().equals(mapRole.getUserId()))
                       .findFirst().get());
               userRoles.setAc_roles(rolesLists.stream().filter(user -> user.getRoleId().equals(mapRole.getRoleId()))
                       .findFirst().get());
               userRolesList.add(userRoles);
           });
        return userRolesList;
    }


    // All mapped Roles
    public List<ACUserRoleXref> getAllMapRoles() {
        List<ACUserRoleXref> mapRoles = new ArrayList<>();
        roleMapRepository.findAll()
                .forEach(mapRoles::add);
        return mapRoles;
    }

    // Mapped Roles for the user - - need to test -id - user id - returning users, roles, modules response
    public UserRolesModules getAllUserMapRolesMapModules(Integer id, String Bearer) throws JsonProcessingException {
        List<ACUserRoleXref> mapRoles = new ArrayList<>();
        System.out.println("user id 1..."+id);
        roleMapRepository.findByUserId(id)
                .forEach(mapRoles::add);

        //Setting up user details

        List<AcUsersList> usersLists = getUser(id.toString(), Bearer);
//        userRolesModules.setAcUsers((AcUsersList) usersLists);


        List<UserRolesModules> userRolesModulesList = new ArrayList<>();
        //for each role id - retrieve mapped modules
       // System.out.println("user id 2..."+mapRoles.stream().map(y -> y.getRoleId().toString()));
        String roleId = mapRoles.stream().map( y -> String.valueOf(y.getRoleId())).collect(Collectors.joining(","));
        System.out.println("New Role ids "+roleId);
        List<AcRolesList> rolesLists = getRoles(roleId.toString(), Bearer);
        List<RoleModule> roleModuleResponses =  getRoleModules(roleId, Bearer);



        //setting up roles details
//        mapRoles.forEach(mapRole -> {
//        UserRolesModules userRolesModules = new UserRolesModules();
//            userRolesModules.setAcUsers((usersLists).get(0));
//            userRolesModules.setAc_roles( rolesLists.get(0));
//            userRolesModules.setRoleModuleList((roleModuleResponses));
//            userRolesModulesList.add(userRolesModules);
//        });



//            AcRolesList acRolesList = new AcRolesList();
//            List<RoleModule> acRolesListList = acRolesList.getRoleModuleList();
//        acRolesListList.setRoleModuleList(roleModuleResponses);
//                mapRoles.forEach(mapRole -> {
            UserRolesModules userRolesModules = new UserRolesModules();
            userRolesModules.setAcUsers(usersLists.get(0));
//            rolesLists.forEach(roles -> (
//                    roleModuleResponses.forEach(modules -> (
//                            if(roles.get)
//                            ));
//                    ));
            for (int i=0; i< rolesLists.size(); i++){
                for(int j=0; j< roleModuleResponses.size(); j++){
                    if(rolesLists.get(i).getRoleId().equals(roleModuleResponses.get(j).getRoleId())){
//                        rolesLists.get(i).setRoleModuleList(roleModuleResponses);
                        rolesLists.get(i).getRoleModuleList().add(roleModuleResponses.get(j));
                    }
                }


        }
            userRolesModules.setAcRolesLists(rolesLists);

//            userRolesModules.setRoleModuleList(roleModuleResponses);
//            acRolesList.setRoleModuleList(roleModuleResponses);
//            userRolesModules.setAcRolesLists(acRolesList);

//            userRolesModulesList.add(userRolesModules);
//        });


//        RoleModule roleModule = new RoleModule();
//        roleModule.setRoleId(roleModuleResponses.get(0).getRoleModuleList());
//        System.out.println("module names ..... "+roleModuleResponses.size()+"....."+roleModuleResponses.get(1).getRoleModuleList());
        System.out.println(roleModuleResponses.get(0).getModuleName());

        return userRolesModules;
    }

    public List<ACUserRoleXref> getMapRoleId(Integer id){
        return roleMapRepository.findByUserId(id);
    }

    //to get role details for the user id
    public List<UserRoles> getMapRoledetails(Integer id, String Bearer) throws JsonProcessingException {
        List<ACUserRoleXref> mapRoles = new ArrayList<>();
        roleMapRepository.findByUserId(id)
                .forEach(mapRoles::add);
        String roleId = mapRoles.stream().map( y -> String.valueOf(y.getRoleId())).collect(Collectors.joining(","));
        System.out.println("Role ids "+roleId);
        List<AcRolesList> rolesLists = getRoles(roleId, Bearer);
        List<UserRoles> userRolesList = new ArrayList<>();
        mapRoles.forEach(mapRole -> {
            UserRoles userRoles = new UserRoles();
            userRoles.setAc_roles(rolesLists.stream().filter(user -> user.getRoleId().equals(mapRole.getRoleId()))
                    .findFirst().get());
            userRolesList.add(userRoles);
        });
        return userRolesList;
    }

    public ACUserRoleXref addUserMapRole(ACUserRoleXref mapRoles){
        return roleMapRepository.save(mapRoles);
    }

    public ACUserRoleXref addMapRole(ACUserRoleXref mapRoles){
        return roleMapRepository.save(mapRoles);
    }

    public void updateMapRole(Integer id, ACUserRoleXref mapRoles){
        roleMapRepository.save(mapRoles);
    }

    public void deleteMapRole(Integer id, ACUserRoleXref mapRoles){
        roleMapRepository.delete(mapRoles);
    }
}
