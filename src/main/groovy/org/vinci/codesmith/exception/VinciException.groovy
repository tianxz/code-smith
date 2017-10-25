package org.vinci.codesmith.exception

/**
 * Created by XizeTian on 2016/12/30.
 */
class VinciException extends RuntimeException {
    VinciException() {
    }

    VinciException(String var1) {
        super(var1)
    }

    VinciException(String var1, Throwable var2) {
        super(var1, var2)
    }

    VinciException(Throwable var1) {
        super(var1)
    }

    VinciException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4)
    }
}
