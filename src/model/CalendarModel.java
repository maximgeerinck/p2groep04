package model;

import java.util.ArrayList;
import java.util.List;

import de.jaret.util.date.Interval;
import de.jaret.util.date.JaretDate;
import de.jaret.util.ui.timebars.model.DefaultTimeBarModel;
import de.jaret.util.ui.timebars.model.TimeBarRow;
import entity.Presentation;

public class CalendarModel extends DefaultTimeBarModel 
{
    /** date used as a base date for all intervals. */
    public static final JaretDate BASEDATE = new JaretDate(4, 3, 2014, 0, 0, 0);
    /**
     * Update or create the model for the given month. If the month is not already created, day entries will be created.
     * 
     * @param month month
     * @param year year
     */
    public void createMonth(int month, int year) {
        int beginIndex = getIndexForDate(new JaretDate(1, month, year, 0, 0, 0));
        if (beginIndex == -1) {
            createMonthInternal(month, year);
        }
    }
    /**
     * Get the index for the given date or -1.
     * 
     * @param jaretDate date
     * @return index or -1
     */
    public int getIndexForDate(JaretDate jaretDate) {
        for (int i = 0; i < _rows.size(); i++) {
            Day day = (Day) _rows.get(i);
            if (day.getDayDate().compareDateTo(jaretDate) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Create empty days for the given month. The method assumes that the existing days are present without gaps.
     * 
     * @param month month
     * @param year year
     */
    private void createMonthInternal(int month, int year) {
        if (_rows.size() == 0 || ((Day) _rows.get(_rows.size() - 1)).getDayDate().compareDateTo(new JaretDate(1, month, year, 0, 0, 0)) < 0) {
            // simply attach to the end
            JaretDate date = new JaretDate(1, month, year, 0, 0, 0);
            while (date.getMonth() == month) {
                Day day = new Day(date);
                addRow(day);
                date = date.copy().advanceDays(1);
            }
        } else {
            // add before beginning
            JaretDate date = new JaretDate(1, month, year, 0, 0, 0);
            int index = 0;
            while (date.getMonth() == month) {
                Day day = new Day(date);
                addRow(index++, day);
                date = date.copy().advanceDays(1);
            }
        }
    }
  
    /**
     * Retrieve the day for a given date.
     * 
     * @param date date of the day
     * @return the day or <code>null</code> if none could be found
     */
    public Day getDay(JaretDate date) {
        for (TimeBarRow row : _rows) {
            Day day = (Day) row;
            if (day.getDayDate().compareDateTo(date) == 0) {
                return day;
            }
        }
        return null;
    }

    /**
     * Retrieve the day for an index (simple cast from getRow).
     * 
     * @param idx index
     * @return day
     */
    public Day getDay(int idx) {
        return (Day) getRow(idx);
    }


    /**
     * {@inheritDoc} Adds handling of the placeholder creation.
     */
    protected void fireElementAdded(TimeBarRow row, Interval interval) 
    {
        Presentation app = (Presentation) interval;
        //deletePlaceholders(app);
        
        //Span voor meerdere dagen
        /*if (app.isSpansMultipleDays()) {
            Day day = (Day) row;
            int idx = getIndexForRow(day);
            createOrUpdatePlaceholders(idx, app);
        }*/

        super.fireElementAdded(row, interval);
    }

    /**
     * {@inheritDoc} Adds handling of the placeholder handling and checks whether an presentation is still registered
     * with the right day (row) of the model.
     */
    protected void fireElementChanged(TimeBarRow row, Interval interval) 
    {
        Presentation p = (Presentation) interval;

        Day day = (Day) checkDayOfPresentation((Presentation) interval, (Day) row);
        deletePlaceholders(p);
        /*if (app.isSpansMultipleDays()) {
            int idx = getIndexForRow(day);
            createOrUpdatePlaceholders(idx, app);
        }*/

        super.fireElementChanged(row, interval);
    }

    /**
     * Check and possibly correct the day for an appointment.
     * 
     * @param appointment appointment to check
     * @param day the current day
     * @return the new day
     */
    private Day checkDayOfPresentation(Presentation presentation, Day day) 
    {
        JaretDate date = new JaretDate(presentation.getStartTime());
        
        if (day.getDayDate().compareDateTo(date) == 0) {
            return day;
        }
        day.remInterval(presentation);
        Day newDay = getDay(date);
        newDay.addInterval(presentation);
        return newDay;
    }

    /**
     * {@inheritDoc} Adds handling of the placeholder deletion for the removed interval.
     */
    protected void fireElementRemoved(TimeBarRow row, Interval interval) {
        Presentation app = (Presentation) interval;
        deletePlaceholders(app);
        super.fireElementRemoved(row, interval);
    }

    /**
     * Remove all placeholders in the model for a given appointment.
     * 
     * @param app appointment
     */
    private void deletePlaceholders(Presentation app) {
        for (int i = 0; i < getRowCount(); i++) {
            getDay(i).removePlaceholder(app);
        }
    }

    /**
     * Create or update placeholder objects for an appointment on several days.
     * 
     * @param startDayIdx index of
     * @param appointment
     */
    private void createOrUpdatePlaceholders(int startDayIdx, Presentation presentation) {
        int idx = startDayIdx;
        Day day = getDay(idx);
        JaretDate date = new JaretDate(presentation.getEndTime());
        List<PresentationPlaceholder> placeholders = new ArrayList<PresentationPlaceholder>();
        int maxPos = -1;
        while (day.getDayDate().compareDateTo(date) <= 0) {
            // special check: if the date is the last date and the time is 00:00
            // --> do not add a placeholder!
            
            //if (!(day.getDayDate().compareDateTo(date) == 0 && presentation.isWholeDayPresentation())) {
            if (!(day.getDayDate().compareDateTo(date) == 0)) {
                PresentationPlaceholder ph = day.getPlaceholder(presentation);
                if (ph == null) {
                    ph = new PresentationPlaceholder(day, presentation);
                }
                placeholders.add(ph);
                day.getPlaceholders().add(ph);

                if (day.getMaxPlaceholderPos() > maxPos) {
                    maxPos = day.getMaxPlaceholderPos();
                }
            }
            idx++;
            day = getDay(idx);
        }

        for (PresentationPlaceholder presentationPlaceholder : placeholders) {
            presentationPlaceholder.setPosition(maxPos + 1);
        }
    }

    
    
}
