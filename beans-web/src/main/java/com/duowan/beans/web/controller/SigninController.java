package com.duowan.beans.web.controller;

import java.util.Date;

import com.duowan.beans.model.Gain;
import com.duowan.beans.model.Signin;
import com.duowan.beans.service.GainService;
import com.duowan.beans.service.SigninService;
import com.duowan.beans.util.Signin.SigninUtil;
import com.duowan.leopard.commons.utility.DateUtil;
import com.duowan.leopard.web.mvc.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = SigninController.DIR)
public class SigninController {

    public static final String DIR = "/signin";

    @Autowired
    private SigninService signinService;

    @Autowired
    private GainService gainService;


    @RequestMapping
    public JsonView signin(long sessYyuid, int entryId) {
        Signin signin = signinService.get(sessYyuid);
        // 今天是否已签到
        boolean isSigned = SigninUtil.isSigned(signin);
        if (isSigned) {
            // 返回JsonView对象
            return new JsonView(false);
        } else {
            this.addSigninGain(sessYyuid, entryId);
            return new JsonView(true);
        }
    }

    private boolean addSigninGain(long yyuid, int entryId) {
        Gain gain = new Gain();
        gain.setGainId(yyuid);
        gain.setEntryId(entryId);
        gain.setDoubleGain(0);
        //因为签到是默认的，所以给默认值
        gain.setGameId(1);
        gain.setServerId(1);
        gain.setStatus(0);
        Date now = new Date();
        gain.setDate(DateUtil.getOnlyDate(now));
        gain.setPostTime(now);
        return gainService.add(gain);
    }


}
