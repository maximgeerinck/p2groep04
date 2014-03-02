/*
 *  File: PresentationPlaceholder.java 
 *  Copyright (c) 2007  Peter Kliem (Peter.Kliem@jaret.de)
 *  A commercial license is available, see http://www.jaret.de.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package model;

import de.jaret.util.date.JaretDate;
import entity.Presentation;

/**
 * A placeholder for presentations spanning a complete day or strech over more than one day.
 */
public class PresentationPlaceholder 
{
    /** presentation this placeholder stands for. */
    protected Presentation _presentation;
    /** day of this placeholder. */
    protected Day _day;
    /** position of display. -1 is undefined. */
    protected int _position = -1;

    public PresentationPlaceholder(Day day, Presentation presentation) {
        _day = day;
        _presentation = presentation;
    }

    public Presentation getPresentation() {
        return _presentation;
    }

    public void setPresentation(Presentation presentation) {
        _presentation = presentation;
    }

    public Day getDay() {
        return _day;
    }

    public void setDay(Day day) {
        _day = day;
    }

    public int getPosition() {
        return _position;
    }

    public void setPosition(int position) {
        _position = position;
    }

    public boolean isFirst() {
        return _day.getDayDate().compareDateTo(new JaretDate(_presentation.getStartTime())) == 0;
    }

    public boolean isLast() {
        
        JaretDate jd = new JaretDate(_presentation.getEndTime()); 
        
        return _day.getDayDate().compareDateTo(jd) == 0 || (_day.getDayDate().compareDateTo(jd.copy().backDays(1)) == 0);
        //return _day.getDayDate().compareDateTo(jd) == 0 || (_day.getDayDate().compareDateTo(jd.copy().backDays(1)) == 0 && _presentation.isWholeDayPresentation());
    }

}
