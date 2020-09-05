package com.poc.userrolemap.repository;

import com.poc.userrolemap.model.ACUserRoleXrefId;
import com.poc.userrolemap.model.ACUserRoleXref;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleMapRepository extends CrudRepository<ACUserRoleXref, ACUserRoleXrefId> {
//   List<AC_User_Role_Xref> AC_User_Role_XrefBy = findByUserId(Integer id);
   public List<ACUserRoleXref> findByUserId(Integer userId);
}

