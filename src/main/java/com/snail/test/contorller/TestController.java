package com.snail.test.contorller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.snail.test.service.IUserService;
import com.snail.test.util.RedisUtil;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private IUserService userService;

    @Resource
    private RedisUtil redisUtil;

    @GetMapping("test")
    public ResponseEntity<String> testOne() {
        return ResponseEntity.ok("it is a test");
    }


    @GetMapping("save/mongo")
    public ResponseEntity<String> saveMongo() {
        userService.saveTestToMongo();
        return ResponseEntity.ok("200");
    }

    @GetMapping("save/redis")
    public ResponseEntity<Boolean> saveRedis() {
        boolean test = redisUtil.set("name", "chenliang", 20);
        return ResponseEntity.ok(test);
    }

    @GetMapping("save/es")
    public ResponseEntity<Boolean> saveEs() {
        userService.saveTestToEs();
        return ResponseEntity.ok(true);
    }


    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/create")
    public void newModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //初始化一个空模型
        Model model = repositoryService.newModel();

        //设置一些默认信息
        String name = "new-process";
        String description = "";
        int revision = 1;
        String key = "process";

        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);

        model.setName(name);
        model.setKey(key);
        model.setMetaInfo(modelNode.toString());

        repositoryService.saveModel(model);
        String id = model.getId();

        //完善ModelEditorSource
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace",
                "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.set("stencilset", stencilSetNode);
        repositoryService.addModelEditorSource(id,editorNode.toString().getBytes("utf-8"));
        response.sendRedirect("/modeler.html?modelId="+id);
    }

}
