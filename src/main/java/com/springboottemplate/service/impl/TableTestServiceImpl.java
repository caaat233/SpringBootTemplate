package com.springboottemplate.service.impl;

import com.springboottemplate.mapper.TableTestMapper;
import com.springboottemplate.pojo.TableTestDO;
import com.springboottemplate.service.TableTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/28 14:19
 */
@Service
public class TableTestServiceImpl implements TableTestService {

    @Autowired
    TableTestMapper tableTestMapper;

    @Override
    public List<TableTestDO> findAll() {
        return tableTestMapper.findAll();
    }
}
