package com.simpletask.qbuilder.services.impl;

import com.simpletask.qbuilder.DTO.TestTemplateDTO;
import com.simpletask.qbuilder.entities.TestTemplate;
import com.simpletask.qbuilder.mappers.TestTemplateMapper;
import com.simpletask.qbuilder.repositories.TestTemplateRepository;
import com.simpletask.qbuilder.services.TestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestTemplateServiceImpl implements TestTemplateService {

    private TestTemplateRepository testTemplateRepository;
    private TestTemplateMapper testTemplateMapper;

    @Autowired
    public TestTemplateServiceImpl(TestTemplateRepository testTemplateRepository,TestTemplateMapper testTemplateMapper) {
        this.testTemplateRepository=testTemplateRepository;
        this.testTemplateMapper = testTemplateMapper;
    }

    @Override
    public List<TestTemplateDTO> findAll(){
        List<TestTemplate> templates = testTemplateRepository.findAll();
        return testTemplateMapper.testTemplatesToTestTemplatesDto(templates);
    }

    @Override
    public TestTemplate addNewTestTemplate(TestTemplate testTemplate) {
        return testTemplateRepository.save(testTemplate);
    }

}
