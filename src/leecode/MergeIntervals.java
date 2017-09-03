package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import leecode.common.Interval;

/***
 * https://leetcode.com/problems/merge-intervals/description/
 * 
 * @author weiwei
 *
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;

        List<Interval> res = new ArrayList<Interval>();

        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            // overlap
            if (end >= cur.start) {
                end = Math.max(end, cur.end);
            } else {
                res.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        res.add(new Interval(start, end));

        return res;
    }

    // https://discuss.leetcode.com/topic/38628/beat-98-java-sort-start-end-respectively
    public List<Interval> merge2(List<Interval> intervals) {
        // sort start&end
        List<Integer> starts = intervals.stream().map(o -> o.start).sorted().collect(Collectors.toList());
        List<Integer> ends = intervals.stream().map(o -> o.end).sorted().collect(Collectors.toList());

        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0, n = intervals.size(); i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts.get(i + 1) > ends.get(i)) {
                res.add(new Interval(starts.get(j), ends.get(i)));
                j = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        MergeIntervals c = new MergeIntervals();
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        System.out.println(c.merge(intervals));
        System.out.println(c.merge2(intervals));
    }
}
