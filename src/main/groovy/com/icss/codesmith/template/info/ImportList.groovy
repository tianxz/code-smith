package com.icss.codesmith.template.info

import com.icss.codesmith.utils.PropertiesUtil

/**
 * Created by XizeTian on 2016/12/30.
 */
class ImportList extends ArrayList<String> {
    ImportList(List<FieldInfo> fs) {
        def prop = PropertiesUtil.me().getPackageProp();
        fs.each {
            def value = prop.getProperty(it.javaType);
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
}
