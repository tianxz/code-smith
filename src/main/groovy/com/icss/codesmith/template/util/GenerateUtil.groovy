package com.icss.codesmith.template.util

import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by XizeTian on 2016/12/19.
 */
@Component
class GenerateUtil {
    @Autowired
    Configuration configuration

    String generateString(Map map, String tempName) throws IOException, TemplateException {
        def value
        generate(map, tempName, { writer -> value = writer })
        return value
    }

    void generate(Map map, String tempName, Closure closure) throws IOException, TemplateException {
        if (tempName.lastIndexOf(".ftl") == -1) {
            tempName = tempName + ".ftl"
        }
        StringWriter writer = new StringWriter()
        Template temp = configuration.getTemplate(tempName)
        try {
            temp.process(map, writer)
            closure(writer)
        } finally {
            writer.close()
        }
    }
}
