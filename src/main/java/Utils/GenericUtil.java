package Utils;

import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Generic Utils to create Random Test Data - Unused
 */
@NoArgsConstructor
public class GenericUtil {

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public Date getDate(){
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
        Date date = new Date();
        return date;
    }

}
