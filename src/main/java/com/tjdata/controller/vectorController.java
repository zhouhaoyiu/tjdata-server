package com.tjdata.controller;

import com.tjdata.domain.Vector;
import com.tjdata.mapper.VectorMapper;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("vector")
public class vectorController {
    @Resource
    private VectorMapper vectorMapper;

    @PostMapping("addVector")
    public Object addVector(@RequestBody Vector vectorInfo) {
        String userName = vectorInfo.userName;
        String vectorName = vectorInfo.vectorName;
        String geneName = vectorInfo.geneName;
        String geneSequence = vectorInfo.geneSequence;
        String RES1 = vectorInfo.RES1;
        String RES2 = vectorInfo.RES2;
        String description = vectorInfo.description;

        int res = vectorMapper.addVector(userName,vectorName,geneName,geneSequence,RES1,RES2,description);

        return getObject(res, "载体");
    }

    static <string> Object getObject(int res, string name) {
        JSONObject json = new JSONObject();
        if (res == 1) {
            json.put("code", "0");
            json.put("msg", "添加" + name + "成功");
        } else {
            json.put("code", "1");
            json.put("msg", "添加" + name + "失败");
        }

        return json;
    }

    @GetMapping("getAllVector")
    public Object getAllVector() {
        List res = vectorMapper.getAllVector();
        JSONObject json = new JSONObject();
        json.put("code", "0");
        json.put("msg", "获得载体成功");
        json.put("data", res);
        return json;
    }
}
