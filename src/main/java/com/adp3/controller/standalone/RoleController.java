package com.adp3.controller.standalone;

//import com.adp3.entity.standalone.Employee;
import com.adp3.entity.standalone.Role;
import com.adp3.factory.standalone.RoleFactory;
//import com.adp3.service.demography.Imp.RoleServiceImp;
import com.adp3.service.standalone.RoleService;
import com.adp3.service.standalone.impl.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


/* Name: Sanele Ngwenya
   Student No.: 216019699
    Group: PT*/


@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/create")
    public Role create(@RequestBody Role Role) {
        Role role = RoleFactory.buildRoleService(Role.getRoleID());
        return roleService.create (role );
    }

    @GetMapping("/read/{ID}")
    public Role read(@PathVariable String ID) {
        return roleService.read(ID);
    }

    @PostMapping ("/update")
    public Role update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @GetMapping("/all")
    public Set<Role> getAll() {
        return roleService.getAll();
    }

    @DeleteMapping ("/delete/{ID}")
    public void delete(@PathVariable String ID) {
        roleService.delete(ID);
    }


}
