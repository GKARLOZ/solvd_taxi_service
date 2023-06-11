package com.solvd.taxiservice.db.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    private static final ThreadLocal<DateFormat> dateFormate = new ThreadLocal<DateFormat>(){
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM_dd");

        }
    };

    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormate.get().parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormate.get().format(v);
    }
}
