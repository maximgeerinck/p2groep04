/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.controls;

import java.text.DateFormat;
import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Maxim
 */
public class DatePickerControl extends DatePicker
{
    private ObjectProperty<Calendar> calendar;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE ;
    private Format calendarFormatter = DateFormat.getDateInstance();
    
    public DatePickerControl() {
        super();
        setValue(LocalDate.now());
        calendar = new SimpleObjectProperty<Calendar>(Calendar.getInstance());

        calendar.addListener(new ChangeListener<Calendar>(){

            @Override
            public void changed(ObservableValue<? extends Calendar> obs, Calendar oldValue, Calendar newValue) {
                 System.out.println("calendar changed from "+calendarFormatter.format(oldValue.getTime())+" to "+calendarFormatter.format(newValue.getTime()));
                LocalDate localDate = LocalDate.now()
                    .withYear(newValue.get(Calendar.YEAR))
                    .withMonth(newValue.get(Calendar.MONTH)+1)
                    .withDayOfMonth(newValue.get(Calendar.DAY_OF_MONTH));
                setValue(localDate);
            }
        });
        
        valueProperty().addListener(new ChangeListener<LocalDate>(){
            @Override
            public void changed(ObservableValue<? extends LocalDate> obs, LocalDate oldValue, LocalDate newValue) {
                System.out.println("Value changed from "+dateFormatter.format(oldValue)+" to "+dateFormatter.format(newValue));
                Calendar cal = Calendar.getInstance();
                cal.set(getValue().getYear(), getValue().getMonthValue()-1, getValue().getDayOfMonth());
                calendar.set(cal);
            }
        
        });
    }

    public ObjectProperty<Calendar> calendarProperty() {        
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar.set(calendar);
    }

    public Calendar getCalendar() {
        return calendar.get();
    }
}
