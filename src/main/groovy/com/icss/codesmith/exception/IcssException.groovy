package com.icss.codesmith.exception

/**
 * Created by XizeTian on 2016/12/30.
 */
class IcssException extends RuntimeException {
    IcssException() {
    }

    IcssException(String var1) {
        super(var1)
    }

    IcssException(String var1, Throwable var2) {
        super(var1, var2)
    }

    IcssException(Throwable var1) {
        super(var1)
    }

    IcssException(String var1, Throwable var2, boolean var3, boolean var4) {
        super(var1, var2, var3, var4)
    }
}
