package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kodolamacz.spring.dao.tools.Generator;

/**
 * Created by acacko on 29.10.17
 */
@Service
public abstract class AbstractDaoImpl {

    @Autowired
    Generator generator;
}
