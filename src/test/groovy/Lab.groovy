import jodd.datetime.JDateTime
import org.junit.Test

/**
 * Created by XizeTian on 2017/10/19.
 */
class Lab {
    @Test
    void main() {
        println new JDateTime("2017-01-01").toString("YYYY-MM-DD")
    }
}
