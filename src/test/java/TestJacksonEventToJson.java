import br.hm.example.jackson.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.Format;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by helmutmigge on 15/03/2017.
 */
public class TestJacksonEventToJson {

    private Event event;

    private Format format = new StdDateFormat();

    private final static String dateToIsoString_1 = "1983-01-11T18:00:00.000-0300";

    private final static String dateToIsoString_2 = "1983-01-11T21:00:00.000+0000";

    @Before
    public void createEvent() throws ParseException {

        Date date = (Date) format.parseObject(dateToIsoString_1);
        this.event = new Event("Cumpleaños", date);
    }

    @Test
    public void convertEventToJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Assert.assertEquals("{\"title\":\"Cumpleaños\",\"date\":\"1983-01-11T21:00:00.000+0000\"}", mapper.writeValueAsString(this.event));
    }

    @Test
    public void convertDateToJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Assert.assertEquals("\"" +dateToIsoString_2+"\"",mapper.writeValueAsString(event.getDate()));
    }

}
