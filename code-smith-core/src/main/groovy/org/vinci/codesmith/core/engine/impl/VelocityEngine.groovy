package org.vinci.codesmith.core.engine.impl

import org.vinci.codesmith.core.engine.TemplateEngine
import freemarker.template.TemplateException
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by XizeTian on 2017/10/25.
 */
class VelocityEngine implements TemplateEngine {
    @Autowired
    org.apache.velocity.app.VelocityEngine ve

    @Override
    String process(Map map, String templateName) {
        def value
        generate(map, templateName, { writer -> value = writer })
        return value
    }

    void generate(Map map, String tempName, Closure closure) throws IOException, TemplateException {
        if (tempName.lastIndexOf(".vm") == -1) {
            tempName = tempName + ".vm"
        }

        Template template = ve.getTemplate("template/" + tempName)
        StringWriter sw = new StringWriter()
        template.merge(new VelocityContext(map), sw)
        if (sw != null) {
            sw.close()
        }
        if (closure) closure(sw)
    }
}
