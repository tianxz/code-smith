package org.vinci.codesmith.template.info

/**
 * Created by XizeTian on 2017/10/25.
 */
class PackageInfo {
    String fullName
    String rootName

    @Override
    String toString() {
        return this.fullName
    }
}
