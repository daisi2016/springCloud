package com.htsec.boot.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htsec.boot.controller.bo.UserBo;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping(value="/users") 
public class UserController {
	// @ApiOperation(value="获取用户列表", notes="")
	 @RequestMapping(value="/", method=RequestMethod.GET) 
	    public List<UserBo> getUserList() { 
	        List<UserBo> r = new ArrayList<UserBo>(); 
	        for(int i=0;i<10;i++) {
	        	UserBo bo = new UserBo();
	        	bo.setId(Long.parseLong(""+i));
	        	bo.setName("name"+i);
	        	bo.setCode("code"+i);
	        	r.add(bo);
	        }
	        log.error("");
	        return r; 
	    }
	 	//@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
	    //@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	     @RequestMapping(value="/{id}", method=RequestMethod.GET) 
	    public UserBo getUser(@PathVariable Long id) { 
		 UserBo bo = new UserBo();
     	bo.setId(id);
     	bo.setName("name"+id);
     	bo.setCode("code"+id);
	        return bo; 
	    } 
	 	
	 	 //@ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	     //@ApiImplicitParams({
	         //    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
	        //     @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	    // })
	     @RequestMapping(value="/{id}", method=RequestMethod.PUT)
	     public String putUser(@PathVariable Long id, @RequestBody UserBo user) {
	 		 
	         return "success";
	     }

}
