package com.example.demo;

import java.io.IOException;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.json.Request;
import com.example.demo.json.Response;

@RestController
public class RestAPIController {
	private static PythonInterpreter interpreter;
	private static Resource resource = new ClassPathResource("case.py");
	private static String path;
	static {
		interpreter = new PythonInterpreter();
		try {
			path = resource.getFile().getPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Response callPythonFunc(String funcName, Request request) {
		interpreter.execfile(path);
		PyObject requestObj = interpreter.get("RequestObj", PyObject.class);
		requestObj.__setattr__("requestId", new PyString(request.getRequsetId()));
		PyFunction function = interpreter.get(funcName, PyFunction.class);
		PyObject responseObj = function.__call__(requestObj);
		String apiId = responseObj.__getattr__("apiId").toString();
		Response response = new Response();
		response.setApiId(apiId);
		return response;
	}


	
	@GetMapping("/test/get")
	public String test1() {
		Request request = new Request();
		request.setRequsetId("1");
		Response response = callPythonFunc("testAPI", request);
		return response.getApiId();
	}

	@PostMapping("/test/post")
	public Response test3(@RequestBody Request request) {
		Response response = callPythonFunc("testAPI", request);
		return response;
	}
}
