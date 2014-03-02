package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import de.jaret.util.date.Interval;
import de.jaret.util.date.JaretDate;
import de.jaret.util.ui.timebars.model.DefaultRowHeader;
import de.jaret.util.ui.timebars.model.DefaultTimeBarRowModel;
import entity.Presentation;

/**
 * A day representation as an extenion of the timebar row model. A list of placeholders are used for indicting
 * presentations that span more than one day (rendereing is done by the header renderer).
 * 
 * @author Peter Kliem
 * @version $Id: Day.java 801 2008-12-27 22:44:54Z kliem $
 */
public class Day extends DefaultTimeBarRowModel {
    /** the date of the da. */
    private JaretDate _dayDate;

    /** List of placeholders. */
    private List<PresentationPlaceholder> _placeholders = new ArrayList<PresentationPlaceholder>();

    /**
     * Construct the day for a specific date.
     * @param date the day date
     */
    public Day(JaretDate date) {
        super();
        // use a copy on write list to allow smooth multi threading
        _intervals = new CopyOnWriteArrayList<Interval>();
        setRowHeader(new DefaultRowHeader(date.toDisplayStringDate(), this));
        _dayDate = date;
    }

    /**
     * Add an interval.
     * 
     * @param interval interval to add
     */
    public synchronized void addInterval(Interval interval) 
    {
        insertSorted(interval);
        // Check min/max modifications by the added interval
        if (_minDate == null || _intervals.size() == 1) {
            _minDate = interval.getBegin().copy();
            _maxDate = interval.getEnd().copy();
        } else {
            if (_minDate.compareTo(interval.getBegin()) > 0) {
                _minDate = interval.getBegin().copy();
            } else if (_maxDate.compareTo(interval.getEnd()) < 0) {
                _maxDate = interval.getEnd().copy();
            }
        }
        interval.addPropertyChangeListener(this);
        fireElementAdded(interval);
    }

    Comparator<Interval> intervalComparator = new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
            return i1.getBegin().compareTo(i2.getBegin());
        }
    };

    private void insertSorted(Interval interval) {
        if (_intervals.size() == 0) {
            _intervals.add(interval);
            return;
        }
        if (intervalComparator.compare(interval, _intervals.get(0)) < 0) {
            _intervals.add(0, interval);
            return;
        }
        for (int i = 0; i < _intervals.size() - 1; i++) {
            if (intervalComparator.compare(_intervals.get(i), interval) <= 0
                    && intervalComparator.compare(interval, _intervals.get(i + 1)) >= 0) {
                _intervals.add(i + 1, interval);
                return;
            }
        }
        _intervals.add(interval);
    }

    public JaretDate getDayDate() {
        return _dayDate;
    }

    /**
     * Look up an presentation on that day by comparing the id's.
     * 
     * @param id id to check
     * @return the presentation or <code>null</code>
     */
    public Presentation getPresentationById(int id) 
    {
        for (Interval interval : _intervals) {
            Presentation p = (Presentation) interval;
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    /**
     * Get all presentations for a day.
     * 
     * @return list of presentations
     */
    public List<Presentation> getPresentations() {
        List<Presentation> result = new ArrayList<>(_intervals.size());
        for (Interval interval : _intervals) {
            result.add((Presentation) interval);
        }
        return result;
    }

    /**
     * Retrieve all placeholders present.
     * @return the list of placeholders
     */
    public List<PresentationPlaceholder> getPlaceholders() {
        return _placeholders;
    }

    /**
     * Retrieve the placeholder for an presentation.
     * @param Presentation presentation
     * @return the placeholder for the presentation or <code>null</code>
     */
    public PresentationPlaceholder getPlaceholder(Presentation presentation) 
    {
        for (PresentationPlaceholder ph : _placeholders) {
            if (ph.getPresentation().equals(presentation)) {
                return ph;
            }
        }
        return null;
    }

    /**
     * Removes all placeholders for the given presentation.
     * 
     * @param Presentation presentation
     */
    public void removePlaceholder(Presentation presentation) 
    {
        PresentationPlaceholder ph = getPlaceholder(presentation);
        if (ph != null) {
            _placeholders.remove(ph);
        }
    }

    public int getMaxPlaceholderPos() {
        int max = -1;
        for (PresentationPlaceholder ph : _placeholders) {
            if (ph.getPosition() > max) {
                max = ph.getPosition();
            }
        }
        return max;
    }

    public Presentation getPlaceholderForPosition(int pos) {
        for (PresentationPlaceholder ph : _placeholders) {
            if (ph.getPosition() == pos) {
                return ph.getPresentation();
            }
        }
        return null;
    }

   /* public Collection<Presentation> getPresentationBySynchronizerId(String synchronizerId) {
        List<Presentation> result = new ArrayList<>(_intervals.size());
        for (Interval interval : _intervals) {
            Presentation p = (Presentation) interval;
            if (p.getSynchronizerId().equals(synchronizerId)) {
                result.add(p);
            }
        }
        return result;
    }*/

}
