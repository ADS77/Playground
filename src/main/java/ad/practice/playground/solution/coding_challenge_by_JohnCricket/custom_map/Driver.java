package ad.practice.playground.solution.coding_challenge_by_JohnCricket.custom_map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {

    private static Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void main(String[]a){
        CustomMap map = new CustomMap();
        map.set("1",1,0);
        map.set("1", 2, 2);
        map.set("1",3, 5);
        logger.info("map.get(1,1) : {}", map.get("1",1));
        logger.info("d.get(1,3) : {}", map.get("1",3));
        logger.info("d.get(1,2) : {}", map.get("1",2));
    }
}
