/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.cross;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public final class ZonedDateFactory {

    /**
     *
     */
    public static final String BR = "+03:00";

    /**
     *
     * @param zone
     * @return
     */
    public static ZonedDateTime now(final String zone){
        return ZonedDateTime.now( ZoneId.of("GMT".concat(of(zone))));
    }

    private static String of(final String zone) {
        var z = new String();

        switch (zone){
            case "BR" :
                z = BR;
                break;
        }

        return z;
    }

}
