/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.controls;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Maxim
 */
public class DatePickerControl extends DatePicker
{
    private ObjectProperty<Calendar> calendar;

    public DatePickerControl() {
        super();
        setValue(LocalDate.now());
    }

    /**
     * Get the value of calendar
     *
     * @return the value of calendar
     */
    public ObjectProperty<Calendar> calendarProperty() {        
        Calendar calendar = new GregorianCalendar();
        System.out.println("test");
        calendar.set(getValue().getYear(), getValue().getMonthValue(), getValue().getDayOfMonth());
        return new SimpleObjectProperty<>(calendar);
    }

    /**
     * Set the value of calendar
     *
     * @param calendar new value of calendar
     */
    public void setCalendar(Calendar calendar) {
        this.calendar.set(calendar);
        LocalDate ld = LocalDate.now();
        ld.withYear(calendar.get(Calendar.YEAR));
        ld.withMonth(calendar.get(Calendar.MONTH));
        ld.withDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));        
        setValue(ld);
    }
    
    public Calendar getCalendar() {
        return calendar.get();
    }
}
