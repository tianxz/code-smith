package org.vinci.codesmith.core.engine.impl

import org.vinci.codesmith.core.engine.TemplateEngine
import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateException
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by XizeTian on 2017/10/25.
 */
class FreemarkerEngine implements TemplateEngine {
    @Autowired
    Configuration configuration

    @Override
    String process(Map map, String templateName) {
        def value
        generate(map, templateName, { writer -> value = writer })
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
