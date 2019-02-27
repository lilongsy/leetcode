/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // 返回的结果
        List<Interval> res = new ArrayList<>();
        if(intervals.isEmpty()) return res;
        // 按照start排序
        Collections.sort(intervals, (Interval i1, Interval i2) -> i1.start-i2.start);
        // 第一个元素初始化
        res.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++) {
            // 如果res最后一个元素的区间和intervals里没重复，则加入，否则则合并
            if(res.get(res.size()-1).end < intervals.get(i).start) res.add(intervals.get(i));
            else res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
        }
        return res;
    }
}