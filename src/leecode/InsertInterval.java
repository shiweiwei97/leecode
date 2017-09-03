package leecode;

import java.util.ArrayList;
import java.util.List;

import leecode.common.Interval;

/***
 * https://leetcode.com/problems/insert-interval/description/
 * 
 * @author weiwei
 *
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList<Interval>();

        for (Interval i : intervals) {
            // before newInterval
            if (newInterval == null || i.end < newInterval.start) res.add(i);
            // after newInterval
            else if (i.start > newInterval.end) {
                res.add(newInterval);
                res.add(i);
                newInterval = null;
            }
            // merge on overlap
            else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }

        // no interval has start > the end of merged newInterval
        if (newInterval != null) res.add(newInterval);

        return res;
    }

    public static void main(String[] args) {

        InsertInterval c = new InsertInterval();

        List<Interval> intervals;
        Interval newInterval;

        intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 5));
        newInterval = new Interval(0, 0);
        System.out.println(c.insert(intervals, newInterval));

        intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 5));
        newInterval = new Interval(0, 1);
        System.out.println(c.insert(intervals, newInterval));

        intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        newInterval = new Interval(4, 9);
        System.out.println(c.insert(intervals, newInterval));

        intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        newInterval = new Interval(2, 5);
        System.out.println(c.insert(intervals, newInterval));

        intervals = new ArrayList<Interval>();
        newInterval = new Interval(5, 7);
        System.out.println(c.insert(intervals, newInterval));

        intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 5));
        newInterval = new Interval(2, 3);
        System.out.println(c.insert(intervals, newInterval));

        intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 5));
        newInterval = new Interval(6, 8);
        System.out.println(c.insert(intervals, newInterval));

        intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 5));
        newInterval = new Interval(0, 3);
        System.out.println(c.insert(intervals, newInterval));
    }
}
