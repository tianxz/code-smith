package org.vinci.codesmith.core.code

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.vinci.codesmith.core.exception.VinciException

import javax.annotation.PostConstruct

/**
 * Created by XizeTian on 2017/10/31.
 */
class BuitInFactory {
    private static final HashMap<String, BuitIn> hashMap = new HashMap<String, BuitIn>()
    @Autowired
    private              ApplicationContext      context

    void putBI(String name, bi) {
        if (hashMap.containsKey(name)) {
            throw new VinciException("[${name}]代码处理器名称已经被注册, 请换个名称")
        }
        hashMap.put(name, (BuitIn) bi)
    }

    BuitIn getBI(String name) {
        if (hashMap.containsKey(name)) {
            return hashMap.get(name)
        } else {
            throw new VinciException('无法找到代码处理器')
        }
    }

    @PostConstruct
    void init() {
        String[] beanNames = context.getBeanDefinitionNames()
        for (String beanName : beanNames) {
            Object BuitInChild = context.getBean(beanName)
            if (BuitInChild instanceof BuitIn) {
                BuitIn buitIn = (BuitIn) BuitInChild
                this.putBI(buitIn.beanName, BuitInChild)
            }
        }
    }
}