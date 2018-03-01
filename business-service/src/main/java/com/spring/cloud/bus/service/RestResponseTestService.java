package com.spring.cloud.bus.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.bus.service.bo.RequestBo;
import com.spring.cloud.bus.service.bo.ResponseBo;
import com.spring.cloud.bus.service.bo.Result;

@RestController
@RequestMapping(value="/test")
public class RestResponseTestService {
	@ResponseBody
	@RequestMapping(value="/result1",method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseBo getresult(@RequestParam String name) {
		ResponseBo responseBo = new ResponseBo();
		Result result = new Result();
		responseBo.setCode("1");
		responseBo.setMsg("执行成功");
		result.setResultCode("1");
		result.setResultContent("business invok sucess");
		result.setResultMsg("业务处理成功");
		responseBo.setResult(result);
		return responseBo;
		
	}
	@ResponseBody
	@RequestMapping(value="/result2",method= RequestMethod.POST)
	public ResponseBo getresult2(@RequestBody RequestBo reqBo) {
		ResponseBo responseBo = new ResponseBo();
		Result result = new Result();
		responseBo.setCode("1");
		responseBo.setMsg("执行成功");
		result.setResultCode(reqBo.getCode());
		result.setResultContent(reqBo.getName());
		result.setResultMsg("业务处理成功");
		responseBo.setResult(result);
		return responseBo;
	}
	
	@ResponseBody
	@RequestMapping(value="/result3",method= RequestMethod.POST)
	public ResponseBo getresult3( String name) {
		ResponseBo responseBo = new ResponseBo();
		Result result = new Result();
		responseBo.setCode("1");
		responseBo.setMsg("执行成功");
		result.setResultCode("1");
		result.setResultContent(name);
		result.setResultMsg("业务处理成功");
		responseBo.setResult(result);
		return responseBo;
		
	}

}
