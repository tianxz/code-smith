package org.vinci.codesmith.core.template.info

/**
 * Created by XizeTian on 2017/10/25.
 */
class PackageInfo {
    String fullName
    String rootName
    String domainName
    String daoName
    String mateName

    @Override
    String toString() {
        return this.fullName
    }
}
