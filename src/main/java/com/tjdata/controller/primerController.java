package com.tjdata.controller;


import com.tjdata.domain.Primer;
import com.tjdata.mapper.PrimerMapper;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.tjdata.controller.vectorController.getObject;

@RestController
@RequestMapping("primer")
public class primerController {
    @Resource
    private PrimerMapper primerMapper;

    @PostMapping("addPrimer")
    public Object addPrimer(@RequestBody Primer primerInfo) {
        String userName = primerInfo.userName;
        String orderDate = primerInfo.orderDate;
        String primerName = primerInfo.primerName;
        String baseSequence = primerInfo.baseSequence;

        int res = primerMapper.addPrimer(userName, orderDate, primerName, baseSequence);

        return getObject(res, "引物");
    }

    @GetMapping("getAllPrimer")
    public Object getAllPrimer() {
        List res = primerMapper.getAllPrimer();
        JSONObject json = new JSONObject();
        json.put("code", "0");
        json.put("msg", "获得引物成功");
        json.put("data", res);
        return json;
    }
}
