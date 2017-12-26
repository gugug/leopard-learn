package com.duowan.beans.service.impl;

import com.duowan.beans.dao.SigninDao;
import com.duowan.beans.model.Signin;
import com.duowan.beans.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class SigninServiceImpl implements SigninService {

    @Autowired
    private SigninDao signinDao;

    @Override
    public boolean add(Signin signin) {
        return signinDao.add(signin);
    }

    @Override
    public Signin get(double signinId) {
        return signinDao.get(signinId);
    }

    @Override
    public boolean deleteBefore(Date startTime) {
        return signinDao.deleteBefore(startTime);
    }


}

