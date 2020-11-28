//package com.adp3.repository.standalone.impl;
//
//
//import com.adp3.entity.standalone.Employee;
//import com.adp3.entity.standalone.Role;
//import com.adp3.repository.standalone.RoleRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.assertEquals;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class RoleRepositoryImpITest {
//    @Autowired
//    private static RoleRepository repository;
//    //private Role role = Role.buildRoleService("12345");
//
//    @Test
//    public void a_create() {
//        Role role = null;
//        assert false;
//        Role create = repository.save(role);
//        assertEquals(create.getempID(),role.getempID());
//        assertEquals(role.getempID(),role.getempID());
//
//    }
//    @Test
//    public void b_read() {
//
//       Role roleService;
//    }
//    @Test
//    public void testUpdate() {
//        Role roleService = new Role.Builder()
//                .setEmployee_id("12345")
//                .build();
//
//        assertEquals(roleService.getEmpID(),"12345");
//    }
//    @Test
//    public void c_delete() {
//
//        Employee role = null;
//        assert false;
//        repository.deleteById(role.getEmpID());
//    }
//    @Test
//    public void d_getAll() {
//
//        Employee role = null;
//        assert false;
//        Assert.assertNotNull(role.getEmpID());
//    }
//}
