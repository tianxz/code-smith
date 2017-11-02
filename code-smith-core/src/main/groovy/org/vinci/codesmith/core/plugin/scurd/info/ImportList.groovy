package org.vinci.codesmith.core.plugin.scurd.info

import org.vinci.codesmith.core.utils.PropertiesUtil

/**
 * Created by XizeTian on 2016/12/30.
 */
class ImportList extends ArrayList<String> {
    ImportList(List<FieldTemplateInfo> fs) {
        def prop = PropertiesUtil.of().getPackageProp()
        fs.each {
            def value = prop.getProperty(it.javaType)
            if (value != null && !contains(value)) {
                String[] sts = value.split(',')
                for (s in sts) {
                    if (!contains(s)) {
                        add(s)
                    }
                }
            }
        }
    }

    ImportList(String... imports) {
        for (String impt : imports) {
            this.add(impt)
        }
    }
}